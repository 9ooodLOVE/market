package korit.market.Repository;

import korit.market.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.IntStream;

public class MemberRepositoryTests {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void insertMembers() {

        IntStream.rangeClosed(1,100).forEach(i -> {
            Member member = Member.builder()
                    .email("user"+i + "@aaa.com")
                    .memberPwd("1111")
                    .memberName("USER"+i)
                    .build();
            
            memberRepository.save(member);
        });
    }
}
