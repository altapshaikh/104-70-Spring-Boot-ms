package com.alt.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class MyTools {

	@Tool(name = "msg", description = "welcome msg")
	public String getWelcomeMsg() {
		return "welcome to Spring AI...!!!";
	}
	@Tool(name = "add", description = "welcome msg")
	public int add(int a ,int b) {
		return a+b;
	}
	
	private final RestClient restClient;

    public MyTools() {
        this.restClient = RestClient.builder()
                .baseUrl("https://dummyjson.com")
                .build();
    }

    @Tool(name = "getProducts", description = "Fetch list of products from dummyjson.com")
    public String getProducts() {
        try {
            String response = restClient.get()
                    .uri("/products/1")
                    .retrieve()
                    .body(String.class);

            return "📦 Products from dummyjson.com:\n" + response;

        } catch (Exception e) {
            return "❌ Failed to fetch products: " + e.getMessage();
        }
    }
}
