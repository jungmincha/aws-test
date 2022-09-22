package com.example.awsTest.bbs;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import static com.example.awsTest.bbs.QIssue_boardEntity.issue_boardEntity;

@Repository
@RequiredArgsConstructor
public class IsBoardQueryRepository {

    private final JPAQueryFactory queryFactory;


    public Page<Issue_boardEntity> findAllQueryDslboardList(Pageable pageable) {
        QueryResults<Issue_boardEntity> queryResults =
                queryFactory
                        .select(issue_boardEntity)
                        .from(issue_boardEntity)
                        .offset(pageable.getOffset())
                        .limit(pageable.getPageSize())
                        .orderBy(issue_boardEntity.bid.desc())
                        .fetchResults();
        return new PageImpl<>(queryResults.getResults(), pageable, queryResults.getTotal());
    }
}
