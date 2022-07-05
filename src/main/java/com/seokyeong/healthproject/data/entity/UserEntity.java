package com.seokyeong.healthproject.data.entity;

import com.seokyeong.healthproject.data.dto.UserDTO;
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
    private String name;

    private String age;

    private String sex;

    public UserDTO toEntity() {
        return UserDTO.builder()
                .name(name)
                .age(age)
                .sex(sex)
                .build();
    }
}