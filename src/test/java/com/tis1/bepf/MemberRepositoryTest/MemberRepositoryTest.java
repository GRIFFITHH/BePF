package com.tis1.bepf.MemberRepositoryTest;

import com.tis1.bepf.member.Member;
import com.tis1.bepf.member.MemberRepository;
import com.tis1.bepf.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

public class MemberRepositoryTest {
    Member member = new Member();
    MemberRepository memberRepository = new MemoryMemberRepository();

    @Test
    void 테스트(){
        member.setId(1L);
        member.setJob("student");
        member.setName("문광훈");
        member.setPassword(1234);
        System.out.println(memberRepository.findAll());
    }

}
