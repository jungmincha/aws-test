package com.example.awsTest.bbs;

import com.example.awsTest.bbs.dto.BoardSearchReq;
import com.example.awsTest.reply.ReplyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Log4j2
@RequiredArgsConstructor
@Service
public class BoardService {

    private final IsBoardRepository isBoardRepository;

    private final ReplyRepository replyRepository;

    private final IsBoardQueryRepository isBoardQueryRepository;


    public  Map<String , Object> boardList(BoardSearchReq req) {//read boardList
        log.info("jpa-read");
        Map<String , Object> hashMap = new HashMap<>();
        Pageable pageable = PageRequest.of(req.getPage(), req.getSize());
        Page<Issue_boardEntity> boardPagingList = isBoardRepository.findAll(pageable);
        hashMap.put("list", boardPagingList);

        return hashMap;

}

    @Transactional
    public Map<String , Object> write(Issue_boardEntity issue_board) {//write or update

        log.info("write");
        
        Map<String , Object> postMap = new HashMap<>();
        Issue_boardEntity getPost =isBoardRepository.save(issue_board);
        postMap.put("code", "S");
        postMap.put("data", getPost);

        return postMap;
    }

    public Map<String , Object> contentView(Long bid) {//read content_view

        log.info("content-read");

        Map<String , Object> ctvMap = new HashMap<>();

        Optional<Issue_boardEntity> isBoardDetail = isBoardRepository.findById(bid);
        isBoardRepository.uphit(bid);
        ctvMap.put("data", isBoardDetail);

         return ctvMap;

    }

    @Transactional
    public Map<String, Object> modifyView(Long bid) {//read modify_view
      
        log.info("modify-read");

        Map<String, Object> mdfMap = new HashMap<>();
        Optional<Issue_boardEntity> isBoardDetailModify = isBoardRepository.findById(bid);

        mdfMap.put("code", "S");
        mdfMap.put("data", isBoardDetailModify);

        return mdfMap;

    }

    @Transactional
    public void delete(Long bid) { //delete board or comments

        log.info("delete");

        replyRepository.deleteBoard_id(bid);//board delete
        isBoardRepository.deleteById(bid);// delete board

    }


    @Transactional
    public void bhit(Long bid) {// up hit

        log.info("uphit");

        isBoardRepository.uphit(bid);
    }

    @Transactional
    public Map<String , Object> update(Long bid , Issue_boardEntity issue_boardEntity) {

        log.info("pdate");

        Map<String, Object> updMap = new HashMap<>();

        issue_boardEntity.setBid(bid);
        Issue_boardEntity issue_board = isBoardRepository.save(issue_boardEntity);

        updMap.put("code", "S");
        updMap.put("data", issue_board);

        return updMap;

    }


    /*네이티브 쿼리로 만든 게시판 조회*/
    public Map<String, Object> nativeQueryboardList(BoardSearchReq req) {
        Map<String, Object> dtMap = new HashMap<>();
        Pageable pageable = PageRequest.of(req.getPage(), req.getSize());
        Page<Issue_boardEntity> boardPagnativeQueryboardListingList = isBoardRepository.findAllNativeQueryBoardList(pageable);
        dtMap.put("code", "S");
        dtMap.put("data", boardPagnativeQueryboardListingList);
        return dtMap;
    }

    /*쿼리dsl로 만든 게시판 조회*/
    public Map<String, Object> queryDslboardList(BoardSearchReq req) {
        Map<String, Object> dtMap = new HashMap<>();
        Pageable pageable = PageRequest.of(req.getPage(), req.getSize());
        Page<Issue_boardEntity> boardPagnativeQueryboardListingList = isBoardQueryRepository.findAllQueryDslboardList(pageable);
        dtMap.put("code", "S");
        dtMap.put("data", boardPagnativeQueryboardListingList);
        return dtMap;
    }

    /*네이티브 쿼리로 만든 게시판 등록*/
    public Map<String, Object> nativeQuerywrite(Issue_boardEntity issue_boardEntity) {
        log.info("write");
        Map<String, Object> dtMap = new HashMap<>();
        isBoardRepository.saveNativeQueryBoard(issue_boardEntity.getBtitle(), issue_boardEntity.getBcontent(), issue_boardEntity.getBname(), issue_boardEntity.getBhit(), LocalDateTime.now());
        dtMap.put("code", "S");
        //dtMap.put("data", issue_board);
        return dtMap;
    }
}
