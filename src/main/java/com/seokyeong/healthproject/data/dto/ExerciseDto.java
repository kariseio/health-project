package com.seokyeong.healthproject.data.dto;

import com.seokyeong.healthproject.data.entity.ExerciseEntity;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ExerciseDto {
    private Long userId;
    private String exerciseId;
    private LocalDateTime date;
    private int sets;
    private int weight;
    private int reps;


    public ExerciseEntity toEntity() {
        return ExerciseEntity.builder()
                .userId(userId)
                .exerciseId(exerciseId)
                .date(date)
                .sets(sets)
                .weight(weight)
                .reps(reps)
                .build();
    }
}
