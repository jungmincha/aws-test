package com.example.awsTest.bbs;

import com.example.awsTest.bbs.dto.BoardSearchReq;
import com.example.awsTest.reply.ReplyEntity;
import com.example.awsTest.reply.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/*
toy 프로젝트에서 가져온 코드입니다.
*/
@Log4j2
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BoardController {

    private final BoardService boardService;
    private final ReplyService replyService;

    @GetMapping("/vue")//jpa로 작성한 게시판 읽기
    public String vue(){
        log.info("vue-test");
        return "vue/index";

    }

    @PostMapping("/jpa/board")//jpa로 작성한 게시판 읽기
    public Map<String , Object> boardList(@RequestBody BoardSearchReq req){
        log.info("boardList");
        return boardService.boardList(req);

    }

    @PostMapping("/native-query/board")//네이티브 쿼리로 작성한 게시판 읽기
    public ResponseEntity<Map<String , Object>> nativeQueryboardList(@RequestBody BoardSearchReq req){
        log.info("nativeQueryboardList");
        return ResponseEntity.ok(boardService.nativeQueryboardList(req));

    }

    @GetMapping("/native-query/group-concat-test")
    public ResponseEntity<Map<String,Object>> nativeQueryGroupConcatTest() {
        return ResponseEntity.ok(boardService.nativeQueryGroupConcatTest());
    }

    @PostMapping("/query-dsl/board")//쿼리dsl로 작성한 게시판 읽기
    public ResponseEntity<Map<String , Object>> queryDslboardList(@RequestBody BoardSearchReq req){
        log.info("queryDslboardList");
        return ResponseEntity.ok(boardService.queryDslboardList(req));

    }

    @GetMapping("/board/{bid}")//read content_view 리팩토링 완료
    public Map<String , Object> contentView(@PathVariable("bid") Long bid) {
        log.info("contentView");
        return boardService.contentView(bid);

    }

    @GetMapping("/board/edit/{bid}")//read modifyView 리팩토링 완료
    public Map<String , Object> modifyView(@PathVariable("bid") Long bid) {
        log.info("modifyView");
        return  boardService.modifyView(bid);

    }

    @PostMapping("/board/write")//create board 리팩토링 완료
    public Map<String , Object> write(@RequestBody Issue_boardEntity issue_boardEntity){//@RequestBody return type json
        log.info("write");
        return boardService.write(issue_boardEntity);
    }

    @PostMapping("/native-query/board/write")//create board 리팩토링 완료
    public ResponseEntity<Map<String , Object>> nativeQuerywrite (@RequestBody Issue_boardEntity issue_boardEntity){//@RequestBody return type json
        log.info("write");
        return ResponseEntity.ok(boardService.nativeQuerywrite(issue_boardEntity));
    }

    @DeleteMapping("/board/{bid}")//delete board
    public void delete(@PathVariable("bid")Long bid){
        log.info("delete");
        boardService.delete(bid);
    }

    @PutMapping("/board/edit/{bid}")//update board 리팩토링 완료
    public Map<String , Object> update(@PathVariable("bid")Long bid ,@RequestBody Issue_boardEntity issue_boardEntity){
        log.info("update");
        return boardService.update(bid , issue_boardEntity);
    }

    @GetMapping("/board/comments/{bid}")//read replyList 리팩토링 완료
    public Map<String, Object> replyList(@PathVariable("bid") Long bid) {
        log.info("reply");
        return replyService.replyList(bid);
    }

    @PostMapping("/board/comments/{bid}")//create reply 
    public Map<String, Object> reply(@PathVariable("bid") Long bid, @RequestBody ReplyEntity replyEntity){
        log.info("reply");
        return replyService.reply(replyEntity , bid);
    }

    @PutMapping("/board/comments/{bid}")//update reply
    public Map<String, Object>  replyUpdate(@PathVariable("bid") Long bid, @RequestBody ReplyEntity replyEntity){
        log.info("replyUpdate");
        return replyService.reply(replyEntity , bid);
    }

    @DeleteMapping("/board/comments/{rid}")//delete comments
    public void replyDelete(@PathVariable("rid") Long rid){
        log.info("replyDelete");
        replyService.deleteComments(rid);
    }
}



   