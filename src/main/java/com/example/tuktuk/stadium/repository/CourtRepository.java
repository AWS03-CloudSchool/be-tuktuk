package com.example.tuktuk.stadium.repository;

import com.example.tuktuk.stadium.domain.court.Court;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourtRepository extends JpaRepository<Court, Long> {
    public Optional<Court> findById(Long id);

    @Query("SELECT c FROM Court c WHERE c.stadium.id = :stadiumId")
    public List<Court> findByStadiumId(Long stadiumId);
}
