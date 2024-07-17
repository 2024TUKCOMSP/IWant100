package IWant100.IWant100_BE.vote.controller;

import IWant100.IWant100_BE.vote.domain.DTO.RequestVoteSaveDTO;
import IWant100.IWant100_BE.vote.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/vote")
public class VoteController {
    VoteService voteService;

    @Autowired
    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    // 투표 생성
    @PostMapping
    public ResponseEntity<Map<String, Object>> saveVote(@RequestBody RequestVoteSaveDTO requestVoteSaveDTO) {

        // 투표 생성 service
        UUID voteId = voteService.exec(requestVoteSaveDTO);

        // 주간부스 등록 성공 여부
        boolean success = voteId != null;

        //Map을 통해 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "투표 생성 성공" : "투표 생성 시 DAO 저장 실패");
        requestMap.put("voteId", voteId);

        //status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }
}