package com.oneday.digest.domain.member.api;

import com.oneday.digest.domain.member.application.MemberService;
import com.oneday.digest.domain.member.dto.SignUpRequest;
import com.oneday.digest.global.common.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.oneday.digest.global.common.ApiResult.ApiEntity;

@Slf4j
@Validated
@RestController("/members")
@RequiredArgsConstructor
public class MemberApi {
    private final MemberService memberService;

    @PostMapping
    public ApiEntity<?> addMember(@Valid @RequestBody SignUpRequest request, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ApiResult.fail(bindingResult);
        }
        return ApiResult.success(memberService.createMember(request.toServiceDto()));
    }
    @GetMapping("/{id}")
    public ApiEntity<?> getMember(@PathVariable Long id){
        return ApiResult.success(memberService.getMember(id));
    }
}
