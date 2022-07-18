package com.seokyeong.healthproject.data.dao;

import com.seokyeong.healthproject.data.entity.ExerciseEntity;

public interface ExerciseDAO {
    ExerciseEntity saveExercise(ExerciseEntity exerciseEntity);

    ExerciseEntity getExercise(String userId, String exerciseId);
}
