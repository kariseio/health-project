package com.seokyeong.healthproject.data.dao.impl;

import com.seokyeong.healthproject.data.dao.ExerciseHistoryDAO;
import com.seokyeong.healthproject.data.entity.ExerciseHistory;
import com.seokyeong.healthproject.repository.ExerciseHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExerciseHistoryDAOImpl implements ExerciseHistoryDAO {

    ExerciseHistoryRepository exerciseHistoryRepository; // 저장소

    @Autowired // 저장소 의존성 주입
    public ExerciseHistoryDAOImpl(ExerciseHistoryRepository exerciseHistoryRepository) {
        this.exerciseHistoryRepository = exerciseHistoryRepository;
    }

    // 운동 기록 저장
    @Override
    public ExerciseHistory saveExerciseHistory(ExerciseHistory exerciseHistory) {
        exerciseHistoryRepository.save(exerciseHistory);
        return exerciseHistory;
    }

    // 모든 운동 기록 검색
    @Override
    public List<ExerciseHistory> getExerciseHistory(Long userId) {
        List<ExerciseHistory> exerciseHistoryList = exerciseHistoryRepository.findByUserId(userId);

        return exerciseHistoryList;
    }

    // 운동 기준 운동 기록 검색
    @Override
    public List<ExerciseHistory> getExerciseHistoryById(Long userId, String exerciseId) {
        List<ExerciseHistory> exerciseHistoryList = exerciseHistoryRepository.findByUserIdAndExerciseId(userId, exerciseId);

        return exerciseHistoryList;
    }

    // 날짜 기준 운동 기록 검색
    @Override
    public List<ExerciseHistory> getExerciseHistoryByDate(Long userId, LocalDate date) {
        List<ExerciseHistory> exerciseHistoryList = exerciseHistoryRepository.findByUserIdAndDate(userId, date);


        return exerciseHistoryList;
    }
}
