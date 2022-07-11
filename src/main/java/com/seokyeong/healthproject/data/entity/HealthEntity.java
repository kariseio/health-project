package com.seokyeong.healthproject.data.entity;

import com.seokyeong.healthproject.data.dto.HealthDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class HealthEntity {
    @Id
    private String healthName;

    private int weight;

    private int count;

    private int sets;

    public HealthDto toDto() {
        return HealthDto.builder()
                .healthName(healthName)
                .weight(weight)
                .count(count)
                .sets(sets)
                .build();
    }
}
