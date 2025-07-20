package com.ait;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ait")
public class EcomExpressApplication {
    public static void main(String[] args) {
        SpringApplication.run(EcomExpressApplication.class, args);
    }
}
