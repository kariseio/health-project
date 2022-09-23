package com.seokyeong.healthproject.data.dto;

import com.seokyeong.healthproject.data.entity.User;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserDto {
    private Long id; // 유저 아이디
    private String name; // 이름
    private String email; // 이메일
    private String picture; // 사진
    private String age; // 나이
    private String gender; // 성별

    public User toEntity() {
        return User.builder()
                .id(id)
                .name(name)
                .email(email)
                .picture(picture)
                .age(age)
                .gender(gender)
                .build();
    }
}
