package com.ait.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ait.bean.PostBean;
import com.ait.bean.PostWithSentimentDTO;
import com.ait.config.ComprhendConfig;
import com.ait.model.PostEntity;
import com.ait.model.SentimentScoreEntity;
import com.ait.repository.PostRepository;
import com.ait.repository.SentimentScoreRepository;
import com.ait.service.PostService;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.comprehend.ComprehendClient;
import software.amazon.awssdk.services.comprehend.model.DetectDominantLanguageRequest;
import software.amazon.awssdk.services.comprehend.model.DetectDominantLanguageResponse;
import software.amazon.awssdk.services.comprehend.model.DetectSentimentRequest;
import software.amazon.awssdk.services.comprehend.model.DetectSentimentResponse;
import software.amazon.awssdk.services.translate.TranslateClient;
import software.amazon.awssdk.services.translate.model.TranslateTextRequest;
import software.amazon.awssdk.services.translate.model.TranslateTextResponse;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	PostRepository postRepository;
	@Autowired
	ComprhendConfig comprhendconfig;
	@Autowired
	SentimentScoreRepository sentimentScoreRepository;

	//save post in database and check sentiment analysis 
	@Override
	public List<PostEntity> createPost(PostBean bean) throws Exception {
		PostEntity postentity = new PostEntity();
		BeanUtils.copyProperties(bean, postentity);
		PostEntity save = postRepository.save(postentity);

		DetectSentimentResponse detect = detect(postentity);
		SentimentScoreEntity sentimentscoreentity = new SentimentScoreEntity();

		sentimentscoreentity.setPostId(save.getId());
		sentimentscoreentity.setMixed(detect.sentimentScore().mixed());
		sentimentscoreentity.setPositive(detect.sentimentScore().positive());
		sentimentscoreentity.setNegative(detect.sentimentScore().negative());
		sentimentscoreentity.setNeutral(detect.sentimentScore().neutral());
		sentimentscoreentity.setSentiment(detect.sentimentAsString());
		sentimentscoreentity.setUserName(save.getUsername());
		sentimentScoreRepository.save(sentimentscoreentity);
		List<PostEntity> byUsername = postRepository.findPostsByUser(postentity.getUsername());
		return byUsername;
	}

	//private static final String AWS_ACCESS_KEY = "";
	//private static final String AWS_SECRET_KEY = "";

public DetectSentimentResponse detect(PostEntity postentity) throws Exception{
	
	String originalText = postentity.getContent();

   
      getComprehendClient();
 
    // Step 2: Detect the dominant language
    DetectDominantLanguageRequest langRequest = DetectDominantLanguageRequest.builder()
            .text(originalText)
            .build();

    //language check
    DetectDominantLanguageResponse langResponse = comprehendClient.detectDominantLanguage(langRequest);

    if (langResponse.languages().isEmpty()) {
        throw new RuntimeException("No dominant language detected.");
    }

    String detectedLanguage = langResponse.languages().get(0).languageCode();
    String textToAnalyze = originalText;

    // Step 3: Translate if language is not English
    if (!"en".equals(detectedLanguage)) {
    	getTranslateClient();
               

        TranslateTextRequest translateRequest = TranslateTextRequest.builder()
                .text(originalText)
                .sourceLanguageCode(detectedLanguage)
                .targetLanguageCode("en")
                .build();

        TranslateTextResponse translateResponse = translateClient.translateText(translateRequest);
        textToAnalyze = translateResponse.translatedText();
    }

    // Step 4: Perform sentiment analysis
    DetectSentimentRequest sentimentRequest = DetectSentimentRequest.builder()
            .text(textToAnalyze)
            .languageCode("en")
            .build();

    DetectSentimentResponse sentimentResponse = comprehendClient.detectSentiment(sentimentRequest);
    return sentimentResponse;
}

	@Override
	public int incrementLikeCount(int postId) {
		Optional<PostEntity> postOpt = postRepository.findById(postId);
		if (postOpt.isPresent()) {
			PostEntity post = postOpt.get();
			post.setLikeCount(post.getLikeCount() + 1);
			postRepository.save(post);
			return post.getLikeCount();
		} else {
			throw new RuntimeException("Post not found");
		}
	}

	@Override
	public boolean deletePostById(int id) {
		postRepository.deleteById(id);
		return false;
	}

	@Override
	public List<PostWithSentimentDTO> getPost(String username) {

		List<PostEntity> posts = postRepository.findPostsByUser(username);
		List<SentimentScoreEntity> sentiments = sentimentScoreRepository.findScoresByUser(username);

		// Step 1: Create a Map from postId to SentimentScoreEntity
		Map<Integer, SentimentScoreEntity> sentimentMap = new HashMap<>();
		for (SentimentScoreEntity s : sentiments) {
			sentimentMap.put(s.getPostId(), s);
		}

		// Step 2: Combine into a list of PostWithSentimentDTO
		List<PostWithSentimentDTO> combinedList = new ArrayList<>();

		for (PostEntity post : posts) {
			SentimentScoreEntity sentiment = sentimentMap.get(post.getId()); // may be null
			PostWithSentimentDTO dto = new PostWithSentimentDTO();
			dto.setPost(post);
			dto.setSentiment(sentiment); // can be null if no sentiment found
			combinedList.add(dto);
		}
		return combinedList;
	}

	ComprehendClient comprehendClient = null;

	public ComprehendClient getComprehendClient() {
		if (comprehendClient == null) {
			// Step 1: Initialize AWS Comprehend client with region
			comprehendClient = ComprehendClient.builder().region(Region.US_EAST_1).credentialsProvider(
					StaticCredentialsProvider.create(AwsBasicCredentials.create(AWS_ACCESS_KEY, AWS_SECRET_KEY)))
					.build();
		}
		return comprehendClient;
	}

	TranslateClient translateClient = null;

	public TranslateClient getTranslateClient() {
		if (translateClient == null) {
			translateClient = TranslateClient.builder().region(Region.AP_SOUTH_1).credentialsProvider(
					StaticCredentialsProvider.create(AwsBasicCredentials.create(AWS_ACCESS_KEY, AWS_SECRET_KEY)))
					.build();
		}

		return translateClient;
	}

}
