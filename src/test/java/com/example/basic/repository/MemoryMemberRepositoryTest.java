package com.example.basic.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.basic.domain.Member;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @BeforeEach
    void setup() {
        repository.clear();
    }

    @Test
    void save() {
        Member member = new Member(
            "홍길동"
        );
        repository.save(member);

        Optional<Member> findMember = repository.findById(member.getId());

        assertThat(findMember.get()).isEqualTo(member);
    }

    @Test
    void findByName() {
        Member member = new Member(
            "홍길동"
        );
        repository.save(member);

        Member member1 = new Member(
            "임꺽정"
        );
        repository.save(member1);

        Optional<Member> findMember = repository.findByName("임꺽정");

        assertThat(findMember.get()).isEqualTo(member1);
    }


    @Test
    void findAll() {
        Member member = new Member(
            "홍길동"
        );
        repository.save(member);

        Member member1 = new Member(
            "임꺽정"
        );
        repository.save(member1);

        List<Member> allMember = repository.findAll();

        assertThat(allMember.size()).isEqualTo(2);
    }

}