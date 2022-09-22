package com.example.awsTest.bbs.view;

import com.example.awsTest.bbs.BoardService;
import com.example.awsTest.bbs.IsBoardRepository;
import com.example.awsTest.bbs.Issue_boardEntity;
import com.example.awsTest.bbs.dto.BoardSearchReq;
import com.example.awsTest.reply.ReplyEntity;
import com.example.awsTest.reply.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
@RequestMapping("/view")
@RequiredArgsConstructor
@Slf4j
public class ViewController {
    private final BoardService boardService;
    private final IsBoardRepository isBoardRepository;
    private final ReplyService replyService;

    /*
    게시판 리스트
    */
    @GetMapping("/board")
    public ModelAndView viewBoardList(ModelAndView mv){
        log.info("boardList");
        mv.addObject("list", isBoardRepository.findAll(Sort.by(Sort.Direction.DESC, "bid")));
        mv.setViewName("board/home");
        return mv;

    }

    /*
    게시글 상세 페이지
    */
    @GetMapping("/board/{bid}")
    public ModelAndView viewContent(@PathVariable("bid") Long bid, ModelAndView mv) {
        log.info("contentView");
        isBoardRepository.uphit(bid);
        mv.addObject("content_view", isBoardRepository.findById(bid).orElseThrow(()-> new RuntimeException("정보가 없습니다.")));
        mv.setViewName("board/content_view");
        return mv;

    }

    /*
    게시글 수정 상세 페이지
    */
    @GetMapping("/board/edit/{bid}")
    public ModelAndView viewModify(@PathVariable("bid") Long bid, ModelAndView mv) {
        log.info("modifyView");
        mv.addObject("modify_view", isBoardRepository.findById(bid).orElseThrow(()-> new RuntimeException("정보가 없습니다.")));
        mv.setViewName("board/modify_view");
        return mv;

    }

    /*
    게시글 작성 페이지
    */
    @GetMapping("/board/write_view")
    public ModelAndView viewWrite(ModelAndView mv) {
        log.info("write");
        mv.setViewName("board/write_view");
        return mv;

    }

    /*
    게시글 작성
    */
    @PostMapping("/board/save")
    public ModelAndView viewWrite(Issue_boardEntity issue_boardEntity, ModelAndView mv){//@RequestBody return type json
        log.info("write");
        isBoardRepository.save(issue_boardEntity);
        mv.setViewName("redirect:/view/board");
        return mv;
    }

    /*
    게시글 수정
    */
    @PostMapping("/board/update")
    public ModelAndView viewUpdate(Issue_boardEntity issue_boardEntity, ModelAndView mv){//@RequestBody return type json
        log.info("update");
        isBoardRepository.save(issue_boardEntity);
        mv.setViewName("redirect:/view/board");
        return mv;
    }

    /*
    게시글 삭제
    */
    @PostMapping("/board/delete/{bid}")
    public ModelAndView update(@PathVariable("bid")Long bid ,ModelAndView mv){
        log.info("delete");
        isBoardRepository.deleteById(bid);
        mv.setViewName("redirect:/view/board");
        return mv;
    }

}
