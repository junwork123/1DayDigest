package com.oneday.digest.domain.member.domain;

import com.oneday.digest.domain.model.Address;
import com.oneday.digest.domain.model.Name;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    private Name name;
    private Address address;
    @Builder
    public Member(Name name, Address address) {
        this.name = name;
        this.address = address;
    }
}
