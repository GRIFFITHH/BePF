package com.tis1.bepf.member;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    Member registerAccount(MemberDTO memberDTO);

    void saveRegisteredAccount(Member member);

    void deleteMember(Long id);

    Optional<Member> findMember(Long id);

    List<Member> findAll();


}
