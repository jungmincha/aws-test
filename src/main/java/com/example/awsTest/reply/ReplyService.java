package com.example.awsTest.reply;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@RequiredArgsConstructor
@Service
public class ReplyService {

    private final ReplyRepository replyRepository;

    
  
    public Map<String, Object> replyList(Long bid) {//read replyList

        log.info("replyList");

        Map<String, Object> repMap = new HashMap<>();
        List<ReplyEntity> replyList = replyRepository.findByBoard_id(bid);
        repMap.put("newReply", replyList);
       
        return repMap;
    }

    @Transactional
    public Map<String, Object> reply(ReplyEntity replyEntity , Long bid) {//create or update reply

        Map<String , Object> repMap = new HashMap<>();

        log.info("reply");

        replyEntity.setBid(bid);
        ReplyEntity replySave = replyRepository.save(replyEntity);
        repMap.put("data", replySave);

        return repMap;

    }

    @Transactional
    public void deleteComments(Long rid) {//delete comments

        log.info("transac-deleteComments");
        replyRepository.deleteById(rid);
    }

}
