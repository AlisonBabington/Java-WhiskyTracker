package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;

import java.util.List;

public interface WhiskyRepositoryCustom {
    List<Whisky> getAllWhiskiesFromYear(int year);
    List<Whisky> getAllWhiskiesFromDistilleryOverAge(Long distilleryId, int age);
    List<Whisky> getAllWhiskiesFromRegion(String region);

}
