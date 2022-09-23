package com.seokyeong.healthproject.handler.impl;

import com.seokyeong.healthproject.data.dao.ExerciseHistoryDAO;
import com.seokyeong.healthproject.data.entity.ExerciseHistory;
import com.seokyeong.healthproject.handler.ExerciseHistoryDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class ExerciseHistoryDataHandlerImpl implements ExerciseHistoryDataHandler {

    ExerciseHistoryDAO exerciseHistoryDAO; // DAO

    @Autowired // DAO 의존성 주입
    public ExerciseHistoryDataHandlerImpl(ExerciseHistoryDAO exerciseHistoryDAO) {
        this.exerciseHistoryDAO = exerciseHistoryDAO;
    }

    // 운동 기록 저장
    @Override
    public ExerciseHistory saveExerciseHistory(Long userId, String exerciseId, LocalDate date, int exerciseSet, int weight, int rep) {
        ExerciseHistory exerciseHistory = new ExerciseHistory(userId, exerciseId, date, exerciseSet, weight, rep);

        return exerciseHistoryDAO.saveExerciseHistory(exerciseHistory);
    }
    
    // 모든 운동 기록 검색
    @Override
    public List<ExerciseHistory> getExerciseHistory(Long userId) {
        return exerciseHistoryDAO.getExerciseHistory(userId);
    }

    // 운동 기준 운동 기록 검색
    @Override
    public List<ExerciseHistory> getExerciseHistoryById(Long userId, String exerciseId) {
        return exerciseHistoryDAO.getExerciseHistoryById(userId, exerciseId);
    }

    // 날짜 기준 운동 기록 검색
    @Override
    public List<ExerciseHistory> getExerciseHistoryByDate(Long userId, LocalDate date) {
        return exerciseHistoryDAO.getExerciseHistoryByDate(userId, date);
    }
}
