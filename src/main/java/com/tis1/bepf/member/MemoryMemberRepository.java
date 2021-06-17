package com.tis1.bepf.member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {

        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public static void main(String[] args) {
        //test
        MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
        Member member = new Member();
        member.setName("spring");
        member.setPassword(1234);
        member.setJob("student");
        memoryMemberRepository.save(member);
        Member member2 = new Member();
        member2.setJob("lawyer");
        member2.setName("spring2");
        member2.setPassword(12341234);
        memoryMemberRepository.save((member2));


        System.out.println(memoryMemberRepository.findById(1L));
        System.out.println(memoryMemberRepository.findByName("spring"));
        System.out.println(memoryMemberRepository.findAll());
        System.out.println(memoryMemberRepository.findById(2L));
        System.out.println(memoryMemberRepository.findAll());
        System.out.println(member.toString());
        System.out.println(member2.toString());
    }

}
