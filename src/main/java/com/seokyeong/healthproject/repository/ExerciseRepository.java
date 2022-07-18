package com.seokyeong.healthproject.repository;

import com.seokyeong.healthproject.data.entity.ExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<ExerciseEntity, String> {
}
