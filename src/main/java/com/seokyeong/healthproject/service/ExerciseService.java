package com.seokyeong.healthproject.service;

import com.seokyeong.healthproject.data.dto.ExerciseDto;

public interface ExerciseService {
    ExerciseDto saveExercise(String userId, String exerciseId, int sets, int weight, int times);

    ExerciseDto getExercise(String userId, String exerciseId);
}
