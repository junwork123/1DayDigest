package com.oneday.digest.domain.member.application;

import com.oneday.digest.domain.member.dao.MemberRepository;
import com.oneday.digest.domain.member.domain.Member;
import com.oneday.digest.domain.member.exception.MemberNotFoundException;
import com.oneday.digest.domain.model.Address;
import com.oneday.digest.domain.model.Name;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Long createMember(createMember member) {
        return memberRepository.save(Member.builder()
                .name(member.name())
                .address(member.address())
                .build());
    }
    public MemberResponse getMember(Long id){
        return MemberResponse.from(memberRepository.findById(id)
                .orElseThrow(MemberNotFoundException::new));
    }

    @Builder
    public record createMember(Name name, Address address) {
    }

    @Builder
    public record MemberResponse (
            @NotBlank
            String firstName,
            @NotBlank
            String lastName,
            @NotBlank
            String street,
            @NotBlank
            String city,
            @NotBlank
            String state,
            @NotBlank
            String zipCode) {
        public static MemberService.MemberResponse from(Member member) {
            return MemberService.MemberResponse.builder()
                    .firstName(member.getName().firstName())
                    .lastName(member.getName().lastName())
                    .street(member.getAddress().street())
                    .city(member.getAddress().city())
                    .zipCode(member.getAddress().zipcode())
                    .build();
        }
    }
}
