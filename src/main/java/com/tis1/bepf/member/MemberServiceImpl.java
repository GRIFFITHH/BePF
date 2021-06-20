package com.tis1.bepf.member;


import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository ;

    public MemberServiceImpl(MemberRepository memberRepository) { this.memberRepository = memberRepository; }

    @Override
    public Member registerAccount(MemberDTO memberDTO) {
        if (emailExists(memberDTO.getEmail())){
            throw new IllegalStateException("이미 존재하는 이메일입니다.");
        } else {
            final Member member = new Member();
            member.setEmail(memberDTO.getEmail());
            member.setNickName(memberDTO.getNickName());
            member.setPassword(memberDTO.getPassword());
            return memberRepository.save(member);
        }
    }

    @Override
    public void saveRegisteredAccount(Member member) {
        // 작성 예정
    }

    @Override
    public void deleteMember(Long id) {
        // 작성 예정
    }

    @Override
    public Optional<Member> findMember(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }

    // 같은 이름이 있는 중복 회원이 있는지 확인한다.
    private boolean emailExists(String email){
        return memberRepository.findByEmail(email).isPresent();
    }
}