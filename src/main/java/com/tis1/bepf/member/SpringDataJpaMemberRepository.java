package com.tis1.bepf.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository{
    @Override
    Optional<Member> findByNickName(String nickName);

    @Override
    Optional<Member> findByEmail(String email);
}
