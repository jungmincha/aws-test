package com.example.awsTest.bbs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardSearchReq {

    private int page;
    private int size;

}
