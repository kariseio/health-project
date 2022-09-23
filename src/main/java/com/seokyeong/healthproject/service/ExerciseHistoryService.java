package com.seokyeong.healthproject.service;

import com.seokyeong.healthproject.data.dto.ExerciseHistoryDto;

import java.time.LocalDate;
import java.util.List;

public interface ExerciseHistoryService {
    // 운동 기록 저장
    ExerciseHistoryDto saveExerciseHistory(Long userId, String exerciseId, LocalDate date, int exerciseSet, int weight, int rep);
    // 모든 운동 기록 검색
    List<ExerciseHistoryDto> getExerciseHistory(Long userId);
    // 운동 기준 운동 기록 검색
    List<ExerciseHistoryDto> getExerciseHistoryById(Long userId, String exerciseId);
    // 날짜 기준 운동 기록 검색
    List<ExerciseHistoryDto> getExerciseHistoryByDate(Long userId, LocalDate date);
}
