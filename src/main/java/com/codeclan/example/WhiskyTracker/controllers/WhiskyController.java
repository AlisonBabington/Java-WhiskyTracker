package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/{year}")
    public List<Whisky> getWhiskyOver(@PathVariable int year) {
        return whiskyRepository.getAllWhiskiesFromYear(year);
    }

    @GetMapping(value = "/{distillery}/{age}")
    public List<Whisky> getWhiskyFromDistilleryOlderThan(@PathVariable Long distilleryId, int age) {
        return whiskyRepository.getAllWhiskiesFromDistilleryOverAge(distilleryId, age);
    }






}
