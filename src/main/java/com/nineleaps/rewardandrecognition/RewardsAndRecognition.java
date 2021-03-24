package com.nineleaps.rewardandrecognition;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})

@ComponentScan(basePackages = {"com.nineleaps"})
public class RewardsAndRecognition {

    public static void main(String[] args) {

        SpringApplication.run(RewardsAndRecognition.class, args);
    }








}