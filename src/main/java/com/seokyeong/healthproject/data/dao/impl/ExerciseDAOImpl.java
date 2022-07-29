package com.seokyeong.healthproject.data.dao.impl;

import com.seokyeong.healthproject.data.dao.ExerciseDAO;
import com.seokyeong.healthproject.data.entity.ExerciseEntity;
import com.seokyeong.healthproject.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExerciseDAOImpl implements ExerciseDAO {

    ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseDAOImpl(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public ExerciseEntity saveExercise(ExerciseEntity exerciseEntity) {
        exerciseRepository.save(exerciseEntity);
        return exerciseEntity;
    }

    @Override
    public List<ExerciseEntity> getAllExercise(Long userId) {
        List<ExerciseEntity> exerciseEntityList = exerciseRepository.findByUser(userId);

        return exerciseEntityList;
    }

    @Override
    public List<ExerciseEntity> getExercise(Long userId, String exerciseId) {
        List<ExerciseEntity> exerciseEntityList = exerciseRepository.findByUserAndExercise(userId, exerciseId);

        return exerciseEntityList;
    }

    @Override
    public List<ExerciseEntity> getExerciseByDate(Long userId, LocalDate date) {
        List<ExerciseEntity> exerciseEntityList = exerciseRepository.findByUserIdAndDate(userId, date);
//        ExerciseEntity exerciseEntity = exerciseRepository.findByUserIdAndDate(userId, date);

        return exerciseEntityList;
    }
}
