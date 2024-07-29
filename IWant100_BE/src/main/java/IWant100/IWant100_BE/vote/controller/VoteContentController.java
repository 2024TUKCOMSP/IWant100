package IWant100.IWant100_BE.vote.controller;

import IWant100.IWant100_BE.vote.domain.DTO.RequestVoteContentSaveDTO;
import IWant100.IWant100_BE.vote.domain.DTO.RequestVoteSaveDTO;
import IWant100.IWant100_BE.vote.domain.DTO.ResponseVoteContentGetDTO;
import IWant100.IWant100_BE.vote.domain.DTO.ResponseVoteContentResultGetDTO;
import IWant100.IWant100_BE.vote.service.VoteContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin("*")
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
        UUID voterId = voteContentService.saveVoteContent(requestVoteContentSaveDTO);

        // 투표하기 여부
        boolean success = voterId != null;

        //Map을 통해 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "투표하기 성공" : "투표하기 시 DAO 저장 실패");
        requestMap.put("voterId", voterId);

        //status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 투표 세부 조회
    @GetMapping("/vote/{voteId}/user/{userId}")
    public ResponseEntity<Map<String, Object>> getVoteContent(@PathVariable("voteId") UUID voteId, @PathVariable("userId") UUID userId) {

        // 투표 세부 조회 service
        ResponseVoteContentGetDTO responseVoteContentGetDTO = voteContentService.getVoteContent(voteId, userId);

        // 투표 세부 조회 여부
        boolean success = responseVoteContentGetDTO != null;

        //Map을 통해 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "투표 세부 조회 성공" : "투표 세부 조회 시 DAO 검색 실패");
        requestMap.put("voteInfo", responseVoteContentGetDTO);

        //status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 투표 결과 조회
    @GetMapping("/vote/{voteId}")
    public ResponseEntity<Map<String, Object>> getVoteContentResult(@PathVariable("voteId") UUID voteId) {

        // 투표 결과 조회 service
        ResponseVoteContentResultGetDTO responseVoteContentResultGetDTO = voteContentService.getVoteContentResult(voteId);

        // 투표 결과 조회 여부
        boolean success = responseVoteContentResultGetDTO != null;

        //Map을 통해 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "투표 결과 조회 성공" : "투표 결과 조회 시 DAO 검색 실패");
        requestMap.put("voteInfo", responseVoteContentResultGetDTO);

        //status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }
}
