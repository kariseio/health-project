package com.seokyeong.healthproject.repository;

import com.seokyeong.healthproject.data.entity.ExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ExerciseRepository extends JpaRepository<ExerciseEntity, String> {
    List<ExerciseEntity> findByUserIdAndDate(Long userId, LocalDateTime date);

}
