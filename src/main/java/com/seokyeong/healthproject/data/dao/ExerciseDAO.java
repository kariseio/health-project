package com.seokyeong.healthproject.data.dao;

import com.seokyeong.healthproject.data.entity.ExerciseEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface ExerciseDAO {
    ExerciseEntity saveExercise(ExerciseEntity exerciseEntity);

    ExerciseEntity getExercise(String userId, String exerciseId);

    List<ExerciseEntity> getExerciseByDate(String userId, LocalDateTime date);
}
