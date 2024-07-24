package IWant100.IWant100_BE.vote.controller;

import IWant100.IWant100_BE.vote.domain.DTO.RequestVoteContentSaveDTO;
import IWant100.IWant100_BE.vote.domain.DTO.RequestVoteSaveDTO;
import IWant100.IWant100_BE.vote.service.VoteContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
//@CrossOrigin("*")
@RequestMapping("/vote-content")
public class VoteContentController {
    VoteContentService voteContentService;

    @Autowired
    public VoteContentController(VoteContentService voteContentService) {
        this.voteContentService = voteContentService;
    }

    // 투표하기
    @PostMapping
    public ResponseEntity<Map<String, Object>> saveVoteContent(@RequestBody RequestVoteContentSaveDTO requestVoteContentSaveDTO) {

        // 투표하기 service
        UUID userId = voteContentService.saveVoteContent(requestVoteContentSaveDTO);

        // 투표하기 여부
        boolean success = userId != null;

        //Map을 통해 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "투표하기 성공" : "투표하기 시 DAO 저장 실패");
        requestMap.put("userId", userId);

        //status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }
}
