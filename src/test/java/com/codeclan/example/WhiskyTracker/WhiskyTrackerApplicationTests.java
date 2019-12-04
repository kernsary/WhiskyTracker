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

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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
	public void canFindWhiskiesByYear(){
		List<Whisky> foundWhiskies = whiskyRepository.findAllByYear(2018);
		assertEquals(2, foundWhiskies.size());
	}

	@Test
	public void canFindWhiskiesByAgeAndDistilleryName(){
		List<Whisky> foundWhiskies = whiskyRepository.findAllByDistilleryNameAndAge("Rosebank", 12);
		assertEquals("The Rosebank 12 - Flora and Fona", foundWhiskies.get(0).getName());
	}

	@Test
	public void canFindWhiskiesByDistilleryRegion(){
		List<Whisky> foundWhiskies = whiskyRepository.findAllByDistilleryRegion("Lowland");
		assertEquals("The Rosebank 12 - Flora and Fona", foundWhiskies.get(0).getName());
	}

	@Test
	public void canFindDistilleriesByRegion(){
		List<Distillery> foundDistilleries = distilleryRepository.findAllByRegion("Lowland");
		assertEquals("Rosebank", foundDistilleries.get(0).getName());
	}

	@Test
	public void canFindDistilleriesByWhiskyAge() {
		List<Distillery> foundDistilleries = distilleryRepository.findAllByWhiskiesAge(25);
		assertEquals("Macallan", foundDistilleries.get(0).getName());
	}
}
