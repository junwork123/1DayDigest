package com.oneday.digest.domain.member.dto;

import com.oneday.digest.domain.member.application.MemberService;
import com.oneday.digest.domain.model.Address;
import com.oneday.digest.domain.model.Name;

import javax.validation.constraints.NotBlank;

public record SignUpRequest(
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
    public MemberService.createMember toServiceDto() {
        return MemberService.createMember.builder()
                .name(new Name(firstName, lastName))
                .address(new Address(street, city, zipCode))
                .build();
    }
}
