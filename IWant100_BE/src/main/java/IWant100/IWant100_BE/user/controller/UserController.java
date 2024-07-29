package IWant100.IWant100_BE.user.controller;

import IWant100.IWant100_BE.user.domain.DTO.RequestUserSaveDTO;
import IWant100.IWant100_BE.user.domain.DTO.ResponseUserGetDTO;
import IWant100.IWant100_BE.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    // 유저 등록
    public ResponseEntity<Map<String, Object>> saveUser(@RequestBody RequestUserSaveDTO requestUserSaveDTO) {

        // 유저 등록 service
        UUID userId = userService.saveUser(requestUserSaveDTO);

        // 유저 등록 성공 여부
        Boolean success = userId != null;

        //Map을 통해 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "유저 등록 성공" : "유저 등록 시 DAO 저장 실패");
        requestMap.put("userId", userId);

        //status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    @GetMapping("/{userId}")
    // 유저 조회
    public ResponseEntity<Map<String, Object>> getUser(@PathVariable("userId") UUID userId) {

        // 유저 조회 service
        ResponseUserGetDTO requestUserSaveDTO = userService.getUser(userId);

        // 유저 조회 성공 여부
        Boolean success = requestUserSaveDTO != null;

        //Map을 통해 메시지와 info 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "유저 조회 성공" : "유저 조회 시 DAO 검색 실패");
        requestMap.put("userInfo", requestUserSaveDTO);

        //status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }
}
