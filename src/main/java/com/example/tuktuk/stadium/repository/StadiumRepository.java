package com.example.tuktuk.stadium.repository;

import com.example.tuktuk.global.Province;
import com.example.tuktuk.stadium.controller.dto.responseDto.stadium.StadiumSimpleReadResDto;
import com.example.tuktuk.stadium.domain.stadium.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StadiumRepository extends JpaRepository<Stadium, Long> {

    public Optional<Stadium> findById(Long id);

    @Query("SELECT s FROM Stadium s WHERE s.ownerId.userId = :id")
    public List<Stadium> findByOwnerId(String id);

    @Query("SELECT s FROM Stadium s WHERE s.location.province = :province")
    public List<Stadium> findByProvince(Province province);

    @Query("SELECT s FROM Stadium s WHERE LOWER(s.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    public List<Stadium> findByKeyword(@Param("keyword") String keyword);
}
