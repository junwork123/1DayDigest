package com.oneday.digest.domain.member.api;

import com.oneday.digest.domain.member.application.MemberService;
import com.oneday.digest.domain.member.dto.SignUpRequest;
import com.oneday.digest.global.common.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.oneday.digest.global.common.ApiResult.ApiEntity;

@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
public class MemberApi {
    private final MemberService memberService;

    @PostMapping("/member")
    public ApiEntity<Long> signUp(@Valid @RequestBody SignUpRequest request) {
        return ApiResult.success(memberService.createMember(request.toServiceDto()));
    }
    @GetMapping("/member/{id}")
    public ApiEntity<?> getMember(@PathVariable Long id){
        return ApiResult.success(memberService.getMember(id));
    }
}
