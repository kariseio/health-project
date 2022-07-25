package com.seokyeong.healthproject.service;

import com.seokyeong.healthproject.data.dto.ExerciseDto;

import java.time.LocalDateTime;
import java.util.List;

public interface ExerciseService {
    ExerciseDto saveExercise(String userId, String exerciseId, LocalDateTime date, int sets, int weight, int reps);

    ExerciseDto getExercise(String userId, String exerciseId);

    List<ExerciseDto> getExerciseByDate(String userId, LocalDateTime date);
}
