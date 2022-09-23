package com.seokyeong.healthproject.data.entity;

import com.seokyeong.healthproject.data.dto.UserDto;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 유저 아이디

    @Column(nullable = false)
    private String name; // 이름

    @Column(nullable = false)
    private String email; // 이메일 

    @Column
    private String picture; // 사진

    @Column
    private String age; // 나이

    @Column
    private String gender; // 성별

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role; // 역할

    @Builder
    public User(String name, String email, String picture, Role role) { // 로그인용 생성자
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public UserDto toDto() {
        return UserDto.builder()
                .id(id)
                .name(name)
                .email(email)
                .picture(picture)
                .age(age)
                .gender(gender)
                .build();
    }

    public User update(String name, String picture) { // 업데이트
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey() { // 역할 가져오기
        return this.role.getKey();
    }
}
