package com.seokyeong.healthproject.data.dto;

import com.seokyeong.healthproject.data.entity.ExerciseHistory;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ExerciseHistoryDto {
    private Long userId; // 유저 아이디
    private String exerciseId; // 운동 아이디
    private LocalDate date; // 날짜
    private int exerciseSet; // 세트 수
    private int weight; // 무게
    private int rep; // 반복 횟수


    public ExerciseHistory toEntity() {
        return ExerciseHistory.builder()
                .userId(userId)
                .exerciseId(exerciseId)
                .date(date)
                .exerciseSet(exerciseSet)
                .weight(weight)
                .rep(rep)
                .build();
    }
}
