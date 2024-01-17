package com.example.tuktuk.stadium.repository;

import com.example.tuktuk.stadium.domain.court.Court;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourtRepository extends JpaRepository<Court, Long> {
  public Optional<Court> findById(Long id);
}
