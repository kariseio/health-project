package com.seokyeong.healthproject.repository;

import com.seokyeong.healthproject.data.entity.HealthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<HealthEntity, String> {
}
