package com.seokyeong.healthproject.data.entity;

import com.seokyeong.healthproject.data.dto.ExerciseDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ExerciseEntity {
    private Long userId;
    @Id
    private String exerciseId;
    private LocalDateTime date;
    private int sets;
    private int weight;
    private int reps;

    public ExerciseDto toDto() {
        return ExerciseDto.builder()
                .userId(userId)
                .exerciseId(exerciseId)
                .date(date)
                .weight(weight)
                .reps(reps)
                .sets(sets)
                .build();
    }
}
