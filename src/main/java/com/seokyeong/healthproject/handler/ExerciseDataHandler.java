package com.seokyeong.healthproject.handler;

import com.seokyeong.healthproject.data.entity.ExerciseEntity;

import java.time.LocalDate;
import java.util.List;

public interface ExerciseDataHandler {
    ExerciseEntity saveExerciseEntity(Long userId, String exerciseId, LocalDate date, int sets, int weight, int times);

    List<ExerciseEntity> getAllExerciseEntity(Long userId);

    List<ExerciseEntity> getExerciseEntity(Long userId, String exerciseId);

    List<ExerciseEntity> getExerciseEntityByDate(Long userId, LocalDate date);
}
