package com.oneday.digest.domain.member.dao;

import com.oneday.digest.domain.member.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@RequiredArgsConstructor
@Repository
public class MemberRepository {
    private static Long sequence = 0L;
    private static final ConcurrentHashMap<Long, Member> members = new ConcurrentHashMap<>();

    public Long save(Member member) {
        member.setId(++sequence);
        members.put(member.getId(), member);
        return member.getId();
    }
    public Member findById(Long id) {
        return members.get(id);
    }

    public Optional<Member> findByLoginId(String loginId) {
        return members.values().stream()
                .filter(member -> member.getLoginId().equals(loginId))
                .findFirst();
    }
    public Member deleteById(Long id) {
        return members.remove(id);
    }

    public List<Member> findAll() {
        return List.copyOf(members.values());
    }
}
