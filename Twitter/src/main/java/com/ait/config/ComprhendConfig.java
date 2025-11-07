package com.ait.config;

import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.comprehend.ComprehendClient;
@Configuration
public class ComprhendConfig {
	 // 🔐 Replace with your actual AWS credentials
	
    private static final String AWS_ACCESS_KEY = "AKIAVRUVT4EBBUVI7NNY";
    private static final String AWS_SECRET_KEY = "a9wIlKCUap2g6N/+cI9pdwuVy0EhSrdtJfobAri/";

    public  final ComprehendClient getcomprehendClient() {
    	return ComprehendClient.builder()
        .region(Region.US_EAST_1)
        .credentialsProvider(StaticCredentialsProvider.create(
                AwsBasicCredentials.create(AWS_ACCESS_KEY, AWS_SECRET_KEY)
        ))
        .build();
    } 
}
