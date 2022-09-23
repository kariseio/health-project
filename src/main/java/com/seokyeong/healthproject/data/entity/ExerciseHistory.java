package com.seokyeong.healthproject.data.entity;

import com.seokyeong.healthproject.data.dto.ExerciseHistoryDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ExerciseHistory {
    private Long userId; // 유저 아이디
    @Id
    private String exerciseId; // 운동 아이디
    private LocalDate date; // 날짜
    private int exerciseSet; // 세트 수
    private int weight; // 무게
    private int rep; // 반복 횟수

    public ExerciseHistoryDto toDto() {
        return ExerciseHistoryDto.builder()
                .userId(userId)
                .exerciseId(exerciseId)
                .date(date)
                .weight(weight)
                .rep(rep)
                .exerciseSet(exerciseSet)
                .build();
    }
}
