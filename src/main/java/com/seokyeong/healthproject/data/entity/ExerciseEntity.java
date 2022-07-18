package com.seokyeong.healthproject.data.entity;

import com.seokyeong.healthproject.data.dto.ExerciseDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ExerciseEntity {
    @Id
    private String healthName;

    private int weight;

    private int count;

    private int sets;

    public ExerciseDto toDto() {
        return ExerciseDto.builder()
                .healthName(healthName)
                .weight(weight)
                .count(count)
                .sets(sets)
                .build();
    }
}
