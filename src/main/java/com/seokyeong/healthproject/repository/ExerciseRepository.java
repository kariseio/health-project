package com.seokyeong.healthproject.repository;

import com.seokyeong.healthproject.data.entity.ExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExerciseRepository extends JpaRepository<ExerciseEntity, String> {
    List<ExerciseEntity> findByUserIdAndDate(Long userId, LocalDate date);
    List<ExerciseEntity> findAll();
    List<ExerciseEntity> findByUser(Long userId);
    List<ExerciseEntity> findByUserAndExercise(Long userId, String exerciseId);

}
