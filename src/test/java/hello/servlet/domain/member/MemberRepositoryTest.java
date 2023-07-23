package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save(){
        //given
        Member member = new Member("zino", 32);
        //when
        Member saveMember = memberRepository.save(member);
        //then
        Member byId = memberRepository.findById(saveMember.getId());
        assertThat(byId).isEqualTo(saveMember);

    }

    @Test
    void findAll(){
        Member member1 = new Member("zino", 32);
        Member member2 = new Member("gogo", 32);
        Member saveMember = memberRepository.save(member1);
        Member saveMember1 = memberRepository.save(member2);
        //given
        List<Member> all = memberRepository.findAll();
        //when
        Member members = all.get(0);
        //then
        assertThat(all.size()).isEqualTo(2);
        assertThat(all).contains(saveMember,saveMember1);

    }

}