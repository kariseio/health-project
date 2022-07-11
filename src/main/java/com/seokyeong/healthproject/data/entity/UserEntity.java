package com.seokyeong.healthproject.data.entity;

import com.seokyeong.healthproject.data.dto.UserDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class UserEntity {
    @Id
    private String id;

    private String name;

    private String age;

    private String sex;

    public UserDto toDto() {
        return UserDto.builder()
                .id(id)
                .name(name)
                .age(age)
                .sex(sex)
                .build();
    }
}
