package com.example.awsTest.reply;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReplyRepository extends JpaRepository<ReplyEntity , Long> {

    @Query(nativeQuery = true , value = "select * from reply r inner join issue_board i on r.bid = i.bid where i.bid IN (:bid)")
    List<ReplyEntity> findByBoard_id(@Param("bid")Long bid );

    @Modifying
    @Query(nativeQuery = true , value = "delete from reply where bid IN (:bid)")
    void deleteBoard_id(@Param("bid")Long bid );
    
}
