package com.capg.fms.schedule.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.fms.schedule.model.ScheduledFlight;

public interface IScheduleRepo extends JpaRepository<ScheduledFlight, Integer>{

}
