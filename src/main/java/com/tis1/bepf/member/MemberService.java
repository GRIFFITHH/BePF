package com.tis1.bepf.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository ;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /* 회원가입 */
    public Long join(Member member){

        long start = System.currentTimeMillis();

        try{
            validateDuplicateMember(member); // 중복회원 검증
            memberRepository.save(member);
            return member.getId();
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("join = "+timeMs+"ms");
        }
    }

    private void validateDuplicateMember(Member member) {
        //같은 이름이 있는 중복 회원x
        memberRepository.findByEmail(member.getEmail())
                .ifPresent(member1 -> {
                    throw new IllegalStateException(("이미 존재하는 회원입니다."));
                });
    }

    public List<Member> findMembers() {
        long start = System.currentTimeMillis();
        try {
            return memberRepository.findAll();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("findMembers " + timeMs + "ms");
        }
    }

    public Optional<Member> findOne(Long MemberId){
        return memberRepository.findById(MemberId);
    }
}