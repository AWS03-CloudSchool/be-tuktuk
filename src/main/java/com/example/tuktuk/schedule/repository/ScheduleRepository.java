package com.example.tuktuk.schedule.repository;

import com.example.tuktuk.schedule.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {

}
