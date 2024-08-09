package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryMemberRepository implements  MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence =0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member); //아이디 세팅후 스토어에 저장
        return member; // 저장된 결과값 반환
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return  store.values().stream() //스트림으로 변환해줌 데이터를 쉽게 처리할 수 있도록 해줌
                .filter(member -> member.getName().equals(name)) //Member랑 name이 일치하는지 확인함
                .findAny();


    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());

    }


    public void clearStore(){
        store.clear();
    }
}
