package com.seokyeong.healthproject.repository;

import com.seokyeong.healthproject.data.entity.ExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExerciseRepository extends JpaRepository<ExerciseEntity, String> {
    List<ExerciseEntity> findAll();
    List<ExerciseEntity> findByUserId(Long userId);
    List<ExerciseEntity> findByUserIdAndExerciseId(Long userId, String exerciseId);
    List<ExerciseEntity> findByUserIdAndDate(Long userId, LocalDate date);
}
