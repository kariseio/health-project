package com.seokyeong.healthproject.service;

import com.seokyeong.healthproject.data.dto.ExerciseDto;

import java.time.LocalDateTime;
import java.util.List;

public interface ExerciseService {
    ExerciseDto saveExercise(Long userId, String exerciseId, LocalDateTime date, int sets, int weight, int reps);

    ExerciseDto getExercise(Long userId, String exerciseId);

    List<ExerciseDto> getExerciseByDate(Long userId, LocalDateTime date);
}
