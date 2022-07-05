package com.seokyeong.healthproject.data.dto;

import com.seokyeong.healthproject.data.entity.UserEntity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserDTO {
    private String name;
    private String age;
    private String sex;

    public UserEntity toEntity() {
        return UserEntity.builder()
                .name(name)
                .age(age)
                .sex(sex)
                .build();
    }
}
