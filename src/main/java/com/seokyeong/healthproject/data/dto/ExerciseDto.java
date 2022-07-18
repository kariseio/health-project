package com.seokyeong.healthproject.data.dto;

import com.seokyeong.healthproject.data.entity.ExerciseEntity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ExerciseDto {
    private String userId;
    private String exerciseId;
    private int sets;
    private int weight;
    private int times;


    public ExerciseEntity toEntity() {
        return ExerciseEntity.builder()
                .exerciseId(exerciseId)
                .sets(sets)
                .weight(weight)
                .times(times)
                .build();
    }
}
