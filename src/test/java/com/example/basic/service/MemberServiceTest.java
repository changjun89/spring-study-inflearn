package com.example.basic.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.example.basic.domain.Member;
import com.example.basic.repository.MemoryMemberRepository;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    private final MemoryMemberRepository repository = new MemoryMemberRepository();
    private final MemberService service = new MemberService(repository);

    @BeforeEach
    void setup() {
        repository.clear();
    }

    @Test
    void join() {
        //given
        Member member = new Member("회원1");

        //when
        service.join(member);

        //then
        Member findMember = service.findOne(member.getId()).get();
        assertThat(member).isEqualTo(findMember);
    }

    @Test
    void 회원가입_중복이름_예외() {
        //given
        Member member = new Member("회원1");
        Member member2 = new Member("회원1");

        //when
        service.join(member);
        //then
        assertThatThrownBy(
            () -> service.join(member2)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void findMembers() {
        //given
        Member member = new Member("회원1");
        Member member2 = new Member("회원2");

        //when
        service.join(member);
        service.join(member2);

        //then
        List<Member> members = service.findMembers();
        assertThat(members.size()).isEqualTo(2);

    }

    @Test
    void findOne() {
    }
}