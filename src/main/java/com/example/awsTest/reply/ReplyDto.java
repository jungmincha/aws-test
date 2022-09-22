package com.example.awsTest.reply;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class ReplyDto {

    private Long rid;

    private String rname;

    private String rcontent;

    private LocalDateTime rdate;

    private Long bid;//외래키
  
    
}
