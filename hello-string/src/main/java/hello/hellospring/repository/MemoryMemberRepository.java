package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; //sequence => 0, 1, 2 생성해주는 애(Atomic long)

    @Override
    public hello.hellospring.domain.Member save(hello.hellospring.domain.Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<hello.hellospring.domain.Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<hello.hellospring.domain.Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<hello.hellospring.domain.Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
