package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;

import java.util.List;

public interface DistilleryRepositoryCustom {
    List<Whisky> getAllWhiskiesFromRegion(String region);
    List<Distillery> getAllDistileriesFromRegion(String region);
    List<Distillery> getDistilleriesThatHaveWhiskyAt(int age);
}
