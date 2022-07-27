package com.seokyeong.healthproject.handler.impl;

import com.seokyeong.healthproject.data.dao.ExerciseDAO;
import com.seokyeong.healthproject.data.entity.ExerciseEntity;
import com.seokyeong.healthproject.handler.ExerciseDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class ExerciseDataHandlerImpl implements ExerciseDataHandler {

    ExerciseDAO exerciseDAO;

    @Autowired
    public ExerciseDataHandlerImpl(ExerciseDAO exerciseDAO) {
        this.exerciseDAO = exerciseDAO;
    }


    @Override
    public ExerciseEntity saveExerciseEntity(String userId, String exerciseId, LocalDateTime date, int sets, int weight, int times) {
        ExerciseEntity exerciseEntity = new ExerciseEntity(userId, exerciseId, date, sets, weight, times);

        return exerciseDAO.saveExercise(exerciseEntity);
    }

    @Override
    public ExerciseEntity getExerciseEntity(String userId, String exerciseId) {
        return exerciseDAO.getExercise(userId, exerciseId);
    }

    @Override
    public List<ExerciseEntity> getExerciseEntityByDate(String userId, LocalDateTime date) {
        return exerciseDAO.getExerciseByDate(userId, date);
    }
}
