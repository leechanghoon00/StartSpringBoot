package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import hello.hello_spring.service.MemberSerivce;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemberSerivce memberSerivce ;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){ // 테스트 실행하기전에 실행
        memberRepository = new MemoryMemberRepository();
        memberSerivce = new MemberSerivce(memberRepository);

    }

    @AfterEach
    public void afterEach(){ //afterEach = 메서드가 끝날떄마다 실행
        memberRepository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("Spring");

        memberRepository.save(member);

        Member result = memberRepository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }


    @Test
    public void findByName() {
        //회원가입
        Member member1 = new Member();
        member1.setName("spring1");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memberRepository.save(member2);

        Member result = memberRepository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);


}

    @Test
    public void findAll() {
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        memberRepository.save(member1);
        Member member2 = new Member();
        member2.setName("spring2");
        memberRepository.save(member2);

        List<Member> result = memberRepository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
