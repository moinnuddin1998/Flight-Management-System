package com.capg.fms.schedule.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.fms.schedule.model.Schedule;
import com.capg.fms.schedule.model.ScheduledFlight;
import com.capg.fms.schedule.service.ScheduleServiceImp;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
class ScheduleServiceImpTest {

@Autowired	
ScheduleServiceImp service;	

ScheduledFlight sflight;
Schedule schedule;
	
   @BeforeAll
	 void setup() 
	{
	 sflight = new ScheduledFlight(135,180,new Schedule(),444l);
		
	}	
 
 
 
	@Test
	void testAddScheduleFlight() {
		
		ScheduledFlight sflight1 = service.addScheduleFlight(444l, sflight);
		assertEquals(sflight,sflight1);
		
	}

	@Test
	void testViewScheduledFlight() {
		ScheduledFlight sflight1 = service.viewScheduledFlight(135);
		assertEquals(sflight,sflight1);
	}


	@Test
	void testDeleteScheduledFlight() {
	
		 service.deleteScheduledFlight(128);
		 
		
	}

	@Test
	void testModifyScheduledFlight() {
		ScheduledFlight sflight1 = service.modifyScheduledFlight(128, 180, 444l, schedule);
		assertEquals(sflight,sflight1);
	}

}
