package com.seokyeong.healthproject.service.impl;

import com.seokyeong.healthproject.data.dto.ExerciseHistoryDto;
import com.seokyeong.healthproject.data.entity.ExerciseHistory;
import com.seokyeong.healthproject.handler.ExerciseHistoryDataHandler;
import com.seokyeong.healthproject.service.ExerciseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExerciseHistoryServiceImpl implements ExerciseHistoryService {

    ExerciseHistoryDataHandler exerciseHistoryDataHandler; // 핸들러

    @Autowired // 핸들러 의존성 주입
    public ExerciseHistoryServiceImpl(ExerciseHistoryDataHandler exerciseHistoryDataHandler) {
        this.exerciseHistoryDataHandler = exerciseHistoryDataHandler;
    }

    // 운동 기록 저장
    @Override
    public ExerciseHistoryDto saveExerciseHistory(Long userId, String exerciseId, LocalDate date, int exerciseSet, int weight, int rep) {
        ExerciseHistory exerciseHistory = exerciseHistoryDataHandler.saveExerciseHistory(userId, exerciseId, date, exerciseSet, weight, rep);

        return exerciseHistory.toDto();
    }

    // 모든 운동 기록 검색
    @Override
    public List<ExerciseHistoryDto> getExerciseHistory(Long userId) {
        List<ExerciseHistory> exerciseHistoryList = exerciseHistoryDataHandler.getExerciseHistory(userId);
        List<ExerciseHistoryDto> exerciseHistoryDtoList = new ArrayList<>();

        for(ExerciseHistory exerciseHistory : exerciseHistoryList) {
            exerciseHistoryDtoList.add(exerciseHistory.toDto());
        }

        return exerciseHistoryDtoList;
    }

    // 운동 기준 운동 기록 검색
    @Override
    public List<ExerciseHistoryDto> getExerciseHistoryById(Long userId, String exerciseId) {
        List<ExerciseHistory> exerciseHistoryList = exerciseHistoryDataHandler.getExerciseHistoryById(userId, exerciseId);
        List<ExerciseHistoryDto> exerciseHistoryDtoList = new ArrayList<>();

        for(ExerciseHistory exerciseHistory : exerciseHistoryList) {
            exerciseHistoryDtoList.add(exerciseHistory.toDto());
        }

        return exerciseHistoryDtoList;
    }

    // 날짜 기준 운동 기록 검색
    @Override
    public List<ExerciseHistoryDto> getExerciseHistoryByDate(Long userId, LocalDate date) {
        List<ExerciseHistory> exerciseHistoryList = exerciseHistoryDataHandler.getExerciseHistoryByDate(userId, date);
        List<ExerciseHistoryDto> exerciseHistoryDtoList = new ArrayList<>();

        for(ExerciseHistory exerciseHistory : exerciseHistoryList) {
            exerciseHistoryDtoList.add(exerciseHistory.toDto());
        }

        return exerciseHistoryDtoList;
    }
}
