package com.seokyeong.healthproject.data.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

@Getter
@RequiredArgsConstructor
public enum Role { // 역할에 따른 제한
    GUEST("ROLE_GUEST", "손님"), // 게스트
    USER("ROLE_USER", "일반 사용자"); // 일반 사용자

    private final String key;
    private final String title;
}
