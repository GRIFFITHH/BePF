package com.tis1.bepf.member;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;


class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setEmail("momoto@gmail");
        member.setPassword("1234");
        member.setNickName("spring");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        //System.out.println("result = " + (result == member));
        Assertions.assertThat(member).isEqualTo(result);

    }
    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setNickName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setNickName("spring2");
        repository.save(member2);

        Member result = repository.findByNickName("spring1").get();

        Assertions.assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setNickName("spring");
        member1.setPassword("1234");
        member1.setEmail("spring@naver.com");

        repository.save(member1);

        Member member2 = new Member();
        member2.setNickName("spring2");
        member2.setPassword("12345");
        member2.setEmail("spring2@naver.com");

        repository.save(member2);

        List<Member> result = repository.findAll();

        Assertions.assertThat(result.size()).isEqualTo(2);

    }
}