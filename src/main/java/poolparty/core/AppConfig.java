package poolparty.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import poolparty.core.discount.DiscountPolicy;
import poolparty.core.discount.FixDiscountPolicy;
import poolparty.core.discount.RateDiscountPolicy;
import poolparty.core.member.MemberRepository;
import poolparty.core.member.MemberService;
import poolparty.core.member.MemberServiceImpl;
import poolparty.core.member.MemoryMemberRepository;
import poolparty.core.order.OrderService;
import poolparty.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }


}
