package com.example.awsTest.bbs;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class IsBoardDto {

    private Long bid;

    private String btitle;

    private String bname;

    private String bcontent;

    private LocalDateTime bdate;

    private int bhit;
    

    
}