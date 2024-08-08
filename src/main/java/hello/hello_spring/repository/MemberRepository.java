package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member); //회원이 저장
    Optional<Member> findById(Long id); // 아이디 찾기
    Optional<Member> findByName(String name); // 이름 찾기
    List<Member> findAll(); // 지금까지 저장된 모든 리스트 반환
}
