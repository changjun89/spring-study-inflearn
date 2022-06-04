package com.example.basic.service;

import com.example.basic.domain.Member;
import com.example.basic.repository.MemberRepository;
import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    /**
     *
     * @param member
     * @return
     */
    public Long join(Member member) {
        validateMember(member);
        return repository.save(member).getId();
    }

    private void validateMember(Member member) {
        repository.findByName(member.getName())
            .ifPresent(member1 -> {
                throw new IllegalArgumentException("이미 존재하는 이름입니다.");
            });
    }

    public List<Member> findMembers() {
        return repository.findAll();
    }

    public Optional<Member> findOne(Long id) {
        return repository.findById(id);
    }
}
