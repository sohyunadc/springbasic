package poolparty.core;

import poolparty.core.discount.DiscountPolicy;
import poolparty.core.discount.FixDiscountPolicy;
import poolparty.core.discount.RateDiscountPolicy;
import poolparty.core.member.MemberRepository;
import poolparty.core.member.MemberService;
import poolparty.core.member.MemberServiceImpl;
import poolparty.core.member.MemoryMemberRepository;
import poolparty.core.order.OrderService;
import poolparty.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }


}
