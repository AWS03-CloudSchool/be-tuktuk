package com.example.tuktuk.schedule.repository;

import com.example.tuktuk.schedule.domain.Schedule;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {

    @Query("SELECT s FROM Schedule s WHERE s.id = :id AND s.isDeleted = false")
    public Optional<Schedule> findById(Long id);

    @Query("SELECT s FROM Schedule s WHERE s.courtId.id = :courtId")
    public List<Schedule> findByCourtId(Long courtId);
}
