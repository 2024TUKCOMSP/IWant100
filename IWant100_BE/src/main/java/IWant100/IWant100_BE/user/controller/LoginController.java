package IWant100.IWant100_BE.user.controller;

import IWant100.IWant100_BE.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin("*")
public class LoginController {
    LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    // 구글 로그인
    @GetMapping("/login/oauth2/code/{registrationId}")
    public ResponseEntity<Map<String, Object>> goggleLogin(@RequestParam("code") String code, @PathVariable("registrationId") String registrationId) {

        // 구글 로그인 service
        UUID userId = loginService.socialLogin(code, registrationId);

        // 구글 로그인 성공 여부
        Boolean success = userId != null;

        //Map을 통해 메시지와 info 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "구글 로그인 성공" : "구글 로그인 실패");
        requestMap.put("userId", userId);

        //status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }
}
