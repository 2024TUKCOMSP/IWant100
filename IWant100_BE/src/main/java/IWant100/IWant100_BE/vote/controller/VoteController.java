package IWant100.IWant100_BE.vote.controller;

import IWant100.IWant100_BE.vote.domain.DTO.RequestVoteDeleteDTO;
import IWant100.IWant100_BE.vote.domain.DTO.RequestVoteSaveDTO;
import IWant100.IWant100_BE.vote.domain.DTO.ResponseVoteGetDTO;
import IWant100.IWant100_BE.vote.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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

    // 메인화면 인기투표 조회
    @GetMapping
    public ResponseEntity<Map<String, Object>> getVote() {

        // 투표 조회 service
        ResponseVoteGetDTO responseVoteGetDTO = voteService.getVote();

        // 투표 조회 여부
        boolean success = responseVoteGetDTO != null;

        //Map을 통해 메시지와 info 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "투표 조회 성공" : "투표 조회 시 DAO 검색 실패");
        requestMap.put("voteInfo", responseVoteGetDTO);

        //status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 투표 전체조회
    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getVoteAll() {

        // 투표 전체조회 service
        List<ResponseVoteGetDTO> responseVoteGetDTOList = voteService.getVoteAll();

        // 투표 전체조회 여부
        boolean success = responseVoteGetDTOList != null;

        //Map을 통해 메시지와 List 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "투표 전체 조회 성공" : "투표 전체 조회 시 DAO 검색 실패");
        requestMap.put("voteList", responseVoteGetDTOList);

        //status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 내가 만든 투표 전체조회
    @GetMapping("/all/user/{userId}")
    public ResponseEntity<Map<String, Object>> getMyVoteAll(@PathVariable("userId") UUID userId) {

        // 투표 전체조회 service
        List<ResponseVoteGetDTO> responseVoteGetDTOList = voteService.getMyVoteAll(userId);

        // 투표 전체조회 여부
        boolean success = responseVoteGetDTOList != null;

        //Map을 통해 메시지와 List 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "내가 만든 투표 전체 조회 성공" : "내가 만든 투표 전체 조회 시 DAO 검색 실패");
        requestMap.put("voteList", responseVoteGetDTOList);

        //status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 투표 생성
    @PostMapping
    public ResponseEntity<Map<String, Object>> saveVote(@RequestBody RequestVoteSaveDTO requestVoteSaveDTO) {

        // 투표 생성 service
        UUID voteId = voteService.exec(requestVoteSaveDTO);

        // 투표 성공 여부
        boolean success = voteId != null;

        //Map을 통해 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "투표 생성 성공" : "투표 생성 시 DAO 저장 실패");
        requestMap.put("voteId", voteId);

        //status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 투표 삭제
    @DeleteMapping
    public ResponseEntity<Map<String, Object>> deleteVote(@RequestBody RequestVoteDeleteDTO requestVoteDeleteDTO) {

        // 투표 삭제 service 성공 여부
        boolean success = voteService.exec(requestVoteDeleteDTO);

        //Map을 통해 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "투표 삭제 성공" : "투표 삭제 실패");

        //status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }
}