package com.example.awsTest.bbs;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "issue_board")
public class Issue_boardEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "bid")
    private Long bid; 

    @Column(nullable = false)
    private String btitle;

    @Column(nullable = false)
    private String bname;
    
    @Column(columnDefinition="TEXT" , nullable = false)
    private String bcontent;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime bdate;

    @Column(nullable = false)
    private int bhit;


   
}
