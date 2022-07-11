package com.seokyeong.healthproject.repository;

import com.seokyeong.healthproject.data.entity.HealthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthRepository extends JpaRepository<HealthEntity, String> {
}
