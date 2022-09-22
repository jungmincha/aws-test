package com.example.awsTest.bbs;



import java.time.LocalDateTime;

public interface IssueBoardIF {


    Long getBid();
    String getBtitle();
    String getBname();
    String getBcontent();
    LocalDateTime getBdate();
    int getBhit();

}
