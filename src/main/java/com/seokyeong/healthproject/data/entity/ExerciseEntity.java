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
    private String userId;
    @Id
    private String exerciseId;

    private int sets;
    private int weight;
    private int times;

    public ExerciseDto toDto() {
        return ExerciseDto.builder()
                .userId(userId)
                .exerciseId(exerciseId)
                .weight(weight)
                .times(times)
                .sets(sets)
                .build();
    }
}
