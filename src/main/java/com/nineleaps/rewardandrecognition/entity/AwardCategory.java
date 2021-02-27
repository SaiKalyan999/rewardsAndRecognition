package com.nineleaps.rewardandrecognition.entity;

public enum AwardCategory {
    Monthly("Monthly"),

    Yearly("Yearly");


    private final String value;

    AwardCategory(String value) {
        this.value = value;
    }
}
