package com.example.my.domain.auth.Controller;

import com.example.my.common.dto.ResDTO;
import com.example.my.domain.auth.dto.req.ReqAuthPostJoinDTOApiV1;
import com.example.my.domain.auth.service.AuthServiceApiV1;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/auth")
public class AuthControllerApiV1 {

    private final AuthServiceApiV1 authServiceApiV1;

    // 시큐리티 없을 때의 코드
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@Valid @RequestBody ReqAuthPostLoginDTOApiV1 dto, HttpSession session) {
//        return authServiceApiV1.login(dto, session);
//    }

    @PostMapping("/join")
    public ResponseEntity<ResDTO<Object>> join(@Valid @RequestBody ReqAuthPostJoinDTOApiV1 reqDto) {
        return authServiceApiV1.join(reqDto);
    }

}
