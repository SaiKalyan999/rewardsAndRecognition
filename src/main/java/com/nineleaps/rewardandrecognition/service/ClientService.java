package com.nineleaps.rewardandrecognition.service;

import com.nineleaps.rewardandrecognition.dto.ClientDto;

public interface ClientService {
    ClientDto getUser(final String email);
}
