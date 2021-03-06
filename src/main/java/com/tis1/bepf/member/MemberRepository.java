package com.tis1.bepf.member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByNickName(String nickName);
    Optional<Member> findByEmail(String email);
    List<Member> findAll();

}
