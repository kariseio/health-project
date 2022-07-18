package com.seokyeong.healthproject.service;

import com.seokyeong.healthproject.data.dto.ExerciseDto;

public interface UserService {
    ExerciseDto saveExercise(String exerciseId, String exerciseName, int sets, int weight, int times);

    ExerciseDto getExercise(String exerciseId);
}
