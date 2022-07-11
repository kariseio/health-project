package com.seokyeong.healthproject.data.dto;

import com.seokyeong.healthproject.data.entity.HealthEntity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class HealthDto {
    private String healthName;
    private int weight;
    private int count;
    private int sets;

    public HealthEntity toEntity() {
        return HealthEntity.builder()
                .healthName(healthName)
                .weight(weight)
                .count(count)
                .sets(sets)
                .build();
    }
}
