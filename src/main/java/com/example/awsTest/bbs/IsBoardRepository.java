package com.example.awsTest.bbs;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDateTime;


public interface IsBoardRepository extends JpaRepository<Issue_boardEntity , Long>{

    @Modifying
    @Transactional
    @Query(nativeQuery = true , value = "update issue_board set bhit = bhit + 1 where bid IN (:bid)")
    void uphit(Long bid);


    @Query(nativeQuery = true,
            countQuery = "SELECT * FROM issue_board ib",
            value = "SELECT " +
                    "* " +
                    "FROM issue_board ib " +
                    "ORDER BY ib.bid DESC")
    Page<Issue_boardEntity> findAllNativeQueryBoardList(Pageable pageable);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,
            value = "" +
                    "INSERT INTO mydb.issue_board\n" +
                    "(btitle, bcontent, bname, bhit, bdate)\n" +
                    "VALUES" +
                    "(" +
                    ":btitle," +
                    ":bcontent," +
                    ":bname,"  +
                    ":bhit," +
                    ":bdate"+
                    ")")
    void saveNativeQueryBoard(@Param("btitle") String btitle, @Param("bcontent")  String bcontent, @Param("bname") String bname, @Param("bhit") int bhit, @Param("bdate")LocalDateTime bdate);
}
