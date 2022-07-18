package com.seokyeong.healthproject.data.dto;

import com.seokyeong.healthproject.data.entity.ExerciseEntity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ExerciseDto {
    private String healthName;
    private int weight;
    private int count;
    private int sets;

    public ExerciseEntity toEntity() {
        return ExerciseEntity.builder()
                .healthName(healthName)
                .weight(weight)
                .count(count)
                .sets(sets)
                .build();
    }
}
