package com.oneday.digest.domain.member.dao;

import com.oneday.digest.domain.member.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@RequiredArgsConstructor
public class MemberRepository {
    private static Long totalCount = 0L;
    private final ConcurrentHashMap<Member, Long> members = new ConcurrentHashMap<>();

    public Long save(Member member) {
        members.put(member, totalCount);
        return totalCount++;
    }
    public Member findById(Long id) {
        return members.keySet().stream()
                .filter(member -> members.get(member).equals(id))
                .findFirst()
                .orElseThrow();
    }
}
