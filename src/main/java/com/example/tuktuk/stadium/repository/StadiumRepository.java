package com.example.tuktuk.stadium.repository;

import com.example.tuktuk.stadium.domain.stadium.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StadiumRepository extends JpaRepository<Stadium,Long> {


    @Query("SELECT s FROM Stadium s WHERE s.id = :id")
    public Optional<Stadium> findById(Long id);

    @Query("SELECT s FROM Stadium s WHERE s.ownerId.id = :id")
    public List<Stadium> findByOwnerId(Long id);
}
