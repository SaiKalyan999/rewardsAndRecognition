package com.nineleaps.rewardandrecognition.entity;

public enum Role {
    HR("HR"),
    Manager("Manager"),
    Founder("Founder"),
    Developer("Developer");

    private final String value;
    Role(String value) {
        this.value = value;
    }
    }
