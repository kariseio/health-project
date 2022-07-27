package com.seokyeong.healthproject.data.dao;

import com.seokyeong.healthproject.data.entity.ExerciseEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface ExerciseDAO {
    ExerciseEntity saveExercise(ExerciseEntity exerciseEntity);

    ExerciseEntity getExercise(Long userId, String exerciseId);

    List<ExerciseEntity> getExerciseByDate(Long userId, LocalDateTime date);
}
