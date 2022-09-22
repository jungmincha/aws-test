package com.example.awsTest.reply;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "reply")
public class ReplyEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rid")
    private Long rid;

    @Column(nullable = false)
    private String rname;

    @Column(columnDefinition="TEXT" , nullable = false)
    private String rcontent;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime rdate;

    @Column(nullable = false)
    private Long bid;//외래키

    public void setBid(Long bid) {
        this.bid = bid;
    }


}