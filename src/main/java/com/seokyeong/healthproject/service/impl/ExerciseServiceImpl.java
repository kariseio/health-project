package com.seokyeong.healthproject.service.impl;

import com.seokyeong.healthproject.data.dto.ExerciseDto;
import com.seokyeong.healthproject.data.entity.ExerciseEntity;
import com.seokyeong.healthproject.handler.ExerciseDataHandler;
import com.seokyeong.healthproject.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    ExerciseDataHandler exerciseDataHandler;

    @Autowired
    public ExerciseServiceImpl(ExerciseDataHandler exerciseDataHandler) {
        this.exerciseDataHandler = exerciseDataHandler;
    }

    @Override
    public ExerciseDto saveExercise(Long userId, String exerciseId, LocalDate date, int sets, int weight, int reps) {
        ExerciseEntity exerciseEntity = exerciseDataHandler.saveExerciseEntity(userId, exerciseId, date, sets, weight, reps);

        return exerciseEntity.toDto();
    }

    @Override
    public List<ExerciseDto> getAllExercise(Long userId) {
        List<ExerciseEntity> exerciseEntityList = exerciseDataHandler.getAllExerciseEntity(userId);
        List<ExerciseDto> exerciseDtoList = new ArrayList<>();

        for(ExerciseEntity exerciseEntity : exerciseEntityList) {
            exerciseDtoList.add(exerciseEntity.toDto());
        }

        return exerciseDtoList;
    }

    @Override
    public List<ExerciseDto> getExercise(Long userId, String exerciseId) {
        List<ExerciseEntity> exerciseEntityList = exerciseDataHandler.getExerciseEntity(userId, exerciseId);
        List<ExerciseDto> exerciseDtoList = new ArrayList<>();

        for(ExerciseEntity exerciseEntity : exerciseEntityList) {
            exerciseDtoList.add(exerciseEntity.toDto());
        }

        return exerciseDtoList;
    }

    @Override
    public List<ExerciseDto> getExerciseByDate(Long userId, LocalDate date) {
        List<ExerciseEntity> exerciseEntityList = exerciseDataHandler.getExerciseEntityByDate(userId, date);
        List<ExerciseDto> exerciseDtoList = new ArrayList<>();

        for(ExerciseEntity exerciseEntity : exerciseEntityList) {
            exerciseDtoList.add(exerciseEntity.toDto());
        }

        return exerciseDtoList;
    }
}
