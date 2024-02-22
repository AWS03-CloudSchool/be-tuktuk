package com.example.tuktuk.schedule.repository;

import com.example.tuktuk.schedule.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {

    @Query("SELECT s FROM Schedule s WHERE s.id = :id AND s.isDeleted = false")
    public Optional<Schedule> findById(Long id);

}
