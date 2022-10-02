package com.example.awsTest.users.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserInfoDto {

    private String username;

    private String nickname;

    private String authorityName;
}
