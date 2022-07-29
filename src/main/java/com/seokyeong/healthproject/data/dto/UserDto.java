package com.seokyeong.healthproject.data.dto;

import com.seokyeong.healthproject.data.entity.UserEntity;
import lombok.*;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String picture;
    private String age;
    private String sex;

    public UserEntity toEntity() {
        return UserEntity.builder()
//                .id(id)
                .name(name)
                .email(email)
                .picture(picture)
//                .age(age)
//                .sex(sex)
                .build();
    }
}
