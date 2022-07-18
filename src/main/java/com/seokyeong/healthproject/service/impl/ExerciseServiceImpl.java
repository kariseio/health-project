package com.seokyeong.healthproject.service.impl;

import com.seokyeong.healthproject.data.dto.ExerciseDto;
import com.seokyeong.healthproject.data.entity.ExerciseEntity;
import com.seokyeong.healthproject.handler.ExerciseDataHandler;
import com.seokyeong.healthproject.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;

public class ExerciseServiceImpl implements ExerciseService {

    ExerciseDataHandler exerciseDataHandler;

    @Autowired
    public ExerciseServiceImpl(ExerciseDataHandler exerciseDataHandler) {
        this.exerciseDataHandler = exerciseDataHandler;
    }

    @Override
    public ExerciseDto saveExercise(String userId, String exerciseId, int sets, int weight, int times) {
        ExerciseEntity exerciseEntity = exerciseDataHandler.saveExerciseEntity(userId, exerciseId, sets, weight, times);

        return exerciseEntity.toDto();
    }

    @Override
    public ExerciseDto getExercise(String userId, String exerciseId) {
        ExerciseEntity exerciseEntity = exerciseDataHandler.getExerciseEntity(userId, exerciseId);

        return exerciseEntity.toDto();
    }
}
