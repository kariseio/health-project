package com.seokyeong.healthproject.handler;

import com.seokyeong.healthproject.data.entity.ExerciseEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface ExerciseDataHandler {
    ExerciseEntity saveExerciseEntity(Long userId, String exerciseId, LocalDateTime date, int sets, int weight, int times);

    ExerciseEntity getExerciseEntity(Long userId, String exerciseId);

    List<ExerciseEntity> getExerciseEntityByDate(Long userId, LocalDateTime date);
}
