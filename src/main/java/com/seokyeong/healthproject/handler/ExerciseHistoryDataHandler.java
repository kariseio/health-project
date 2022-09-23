package com.seokyeong.healthproject.handler;

import com.seokyeong.healthproject.data.entity.ExerciseHistory;

import java.time.LocalDate;
import java.util.List;

public interface ExerciseHistoryDataHandler {
    // 운동 기록 저장
    ExerciseHistory saveExerciseHistory(Long userId, String exerciseId, LocalDate date, int exerciseSet, int weight, int rep);
    // 모든 운동 기록 검색
    List<ExerciseHistory> getExerciseHistory(Long userId);
    // 운동 기준 운동 기록 검색
    List<ExerciseHistory> getExerciseHistoryById(Long userId, String exerciseId);
    // 날짜 기준 운동 기록 검색
    List<ExerciseHistory> getExerciseHistoryByDate(Long userId, LocalDate date);
}
