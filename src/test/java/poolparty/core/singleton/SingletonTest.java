package poolparty.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import poolparty.core.AppConfig;
import poolparty.core.member.MemberService;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        // 1. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        // 2. 조회: 호출할 때 마다 객체를 생성 한번 더
        MemberService memberService2 = appConfig.memberService();

        // 참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // memberService1 != memberService2
        assertThat(memberService1).isNotSameAs(memberService2);

    }

//    public static void main(String[] args) {
//        SingletonService singletonService = new SingletonService();
//          싱글톤 private 이어서 컴파일 오류남
//    }


    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonService() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);
        //드디어 같은 객체 인스턴스를 확인했다. 생성하고 가져다 쓴다.

        assertThat(singletonService1).isSameAs(singletonService2);
        assertThat(singletonService1).isEqualTo(singletonService2);

        // isSameAs -> same ==
        // isEqualTo -> equal equals
    }


}

