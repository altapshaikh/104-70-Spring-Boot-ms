package com.alt;

import java.util.List;

import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.alt.tools.MyTools;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
     //   System.out.println("🟢 Spring Boot MCP Server Starting...");
        SpringApplication.run(Application.class, args);
    //    System.out.println("✅ Spring Boot MCP Server Started!");
    }

    @Bean
    public List<ToolCallback> toolCallbacks(MyTools myTool) {
        return List.of(ToolCallbacks.from(myTool));
    }

}
