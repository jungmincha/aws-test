package com.example.awsTest.users.entity;

import com.example.awsTest.common.BaseTimeEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Set;

@Entity //데이터베이스와 1:1로 맵핑되는 객체
@Table(name = "users")//user는 예약어라 users로
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Users extends BaseTimeEntity {

    @JsonIgnore
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //pk자동증가 전략 + 1
    private Long userId;

    @Column(name = "username", length = 50, unique = true)
    @Email(message = "이메일 형식을 맞춰주세요.")
    private String username;

    @JsonIgnore
    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "nickname", length = 50)
    private String nickname;

    @JsonIgnore
    @Column(name = "activated")
    private boolean activated; //활성화 여부

    //    @JsonIgnore
//    @Column(name = "activated")
//    private boolean activated; //활성화 여부
//
    @Column(name = "authority_name")
    private String authorityName;

    @Column(name = "del_yn")
    private String delYn;



    @ManyToMany//User(회원) 객체와 Authority(권한)객체의 N:N 관계를  User 1 : N user_authority(조인테이블이다) N : 1 Autority 로 정의 했다
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
    private Set<Authority> authorities;
}