package com.example.awsTest.bbs;

import com.example.awsTest.reply.ReplyEntity;
import com.example.awsTest.reply.ReplyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
class BoardControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    BoardService boardService;
    @MockBean
    ReplyService replyService;

    @Test
    @DisplayName("댓글 리스트 가져오기 테스트")
    void getReply() throws Exception {
        Map<String, Object> rtnMap = new LinkedHashMap<>();
        ReplyEntity reply = new ReplyEntity();
        reply.setBid(1L);
        reply.setRcontent("testRcontent");
        reply.setRname("testRname");

        ReplyEntity reply2 = new ReplyEntity();
        reply2.setBid(2L);
        reply2.setRcontent("testRcontent2");
        reply2.setRname("testRname2");

        List<ReplyEntity> replyEntities = List.of(reply, reply2);
        rtnMap.put("data", replyEntities);

        given(replyService.replyList(1L))
                .willReturn(rtnMap);

        String bid = "1";

        mockMvc.perform(
                get("/board/comments/" + bid))
                .andExpect(status().isOk())
                .andDo(print());

        verify(replyService).replyList(1L);

    }

    @Test
    @DisplayName("게시글 한개 가져오기 테스트")
    void getBoardList() throws Exception {
        Map<String, Object> rtnMap = new LinkedHashMap<>();
        Issue_boardEntity issue_board = new Issue_boardEntity();
        issue_board.setBid(1L);
        issue_board.setBcontent("testBcontent");
        issue_board.setBname("testBname");
        rtnMap.put("data", issue_board);
        given(boardService.contentView(1L))
                .willReturn(rtnMap);
        log.info("test1==========================");

        String bid = "1";

        mockMvc.perform(
                get("/board/" + bid))
                .andExpect(status().isOk())
//                .andExpect(jsonPath("bname").exists())
//                .andExpect(jsonPath("$.btitle").exists())
                .andDo(print());
        log.info("test2==========================");
        verify(boardService).contentView(1L);
        log.info("test3==========================");
    }

    @Test
    @DisplayName("게시글 작성")
    void saveBoard() throws Exception {
        Map<String, Object> rtnMap = new LinkedHashMap<>();
        Issue_boardEntity issue_board = new Issue_boardEntity();

        issue_board.setBid(11L);
        issue_board.setBcontent("saveBcontent");
        issue_board.setBname("saveBname");
        issue_board.setBhit(1000);
        //issue_board.setBdate(LocalDateTime.now());

        rtnMap.put("data", issue_board);

        given(boardService.write(issue_board)).willReturn(rtnMap);

        String json = new ObjectMapper().writeValueAsString(issue_board);

        mockMvc.perform(
                post("/board/write")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());

        verify(boardService).write(issue_board);



    }


}
