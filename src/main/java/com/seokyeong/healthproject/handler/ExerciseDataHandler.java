package com.seokyeong.healthproject.handler;

import com.seokyeong.healthproject.data.entity.ExerciseEntity;

public interface ExerciseDataHandler {
    ExerciseEntity saveExerciseEntity(String userId, String exerciseId, int sets, int weight, int times);

    ExerciseEntity getExerciseEntity(String userId, String exerciseId);
}
