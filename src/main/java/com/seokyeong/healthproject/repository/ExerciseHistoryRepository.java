package com.seokyeong.healthproject.repository;

import com.seokyeong.healthproject.data.entity.ExerciseHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExerciseHistoryRepository extends JpaRepository<ExerciseHistory, String> {
    List<ExerciseHistory> findAll();
    List<ExerciseHistory> findByUserId(Long userId);
    List<ExerciseHistory> findByUserIdAndExerciseId(Long userId, String exerciseId);
    List<ExerciseHistory> findByUserIdAndDate(Long userId, LocalDate date);


}
