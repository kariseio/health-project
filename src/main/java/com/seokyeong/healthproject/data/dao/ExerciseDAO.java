package com.seokyeong.healthproject.data.dao;

import com.seokyeong.healthproject.data.entity.ExerciseEntity;

import java.time.LocalDate;
import java.util.List;

public interface ExerciseDAO {
    ExerciseEntity saveExercise(ExerciseEntity exerciseEntity);

    List<ExerciseEntity> getAllExercise(Long userId);

    List<ExerciseEntity> getExercise(Long userId, String exerciseId);

    List<ExerciseEntity> getExerciseByDate(Long userId, LocalDate date);
}
