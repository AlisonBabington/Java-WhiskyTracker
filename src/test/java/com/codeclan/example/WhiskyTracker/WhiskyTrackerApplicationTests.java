package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.Null;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canGetWhiskiesFromYear() {
		List<Whisky> results = whiskyRepository.getAllWhiskiesFromYear(2018);
	}

	@Test
	public void canGetWhiskiesFromRegion() {
		List<Whisky> results = whiskyRepository.getAllWhiskiesFromRegion("Speyside");
	}

	@Test
	public void canGetDistilleriesFromRegion() {
		List<Distillery> results = distilleryRepository.getAllDistileriesFromRegion("Speyside");
	}

	@Test
	public void canGetWhiskiesFromDistilleryOverAge() {
		List<Whisky> results = whiskyRepository.getAllWhiskiesFromDistilleryOverAge(2L, 10);
	}

	@Test
	public void canGetWhiskiesFromDistilleryATage() {
		List<Distillery> results = distilleryRepository.getDistilleriesThatHaveWhiskyAt(12);
	}

}
