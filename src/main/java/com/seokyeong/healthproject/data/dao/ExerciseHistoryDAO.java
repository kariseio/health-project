package com.seokyeong.healthproject.data.dao;

import com.seokyeong.healthproject.data.entity.ExerciseHistory;

import java.time.LocalDate;
import java.util.List;

public interface ExerciseHistoryDAO {
    // 운동 기록 저장
    ExerciseHistory saveExerciseHistory(ExerciseHistory exerciseHistory);
    // 모든 운동 기록 검색
    List<ExerciseHistory> getExerciseHistory(Long userId);
    // 운동 기준 운동 기록 검색
    List<ExerciseHistory> getExerciseHistoryById(Long userId, String exerciseId);
    // 날짜 기준 운동 기록 검색
    List<ExerciseHistory> getExerciseHistoryByDate(Long userId, LocalDate date);
}

