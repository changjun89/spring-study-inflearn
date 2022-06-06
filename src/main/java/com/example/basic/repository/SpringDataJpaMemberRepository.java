package com.example.basic.repository;

import com.example.basic.domain.Member;
import java.util.Optional;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>,
    MemberRepository {

    @Override
    Optional<Member> findByName(String name);
}
