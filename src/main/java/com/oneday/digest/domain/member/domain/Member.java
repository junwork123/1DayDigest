package com.oneday.digest.domain.member.domain;

import com.oneday.digest.domain.model.Address;
import com.oneday.digest.domain.model.Name;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    private Long id;

    @NotEmpty
    private String loginId;
    @NotEmpty
    private String password;
    @NotEmpty

    private Name name;
    private Address address;
    @Builder
    public Member(Long id, String loginId, String password, Name name, Address address) {
        this.id = id;
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.address = address;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
