package com.nineleaps.rewardandrecognition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages={"com.nineleaps"})
public class RewardsAndRecognition {

    public static void main(String[] args) {

        SpringApplication.run(RewardsAndRecognition.class, args);
    }
}