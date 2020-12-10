package poolparty.core;

import poolparty.core.discount.FixDiscountPolicy;
import poolparty.core.member.MemberService;
import poolparty.core.member.MemberServiceImpl;
import poolparty.core.member.MemoryMemberRepository;
import poolparty.core.order.OrderService;
import poolparty.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }


}
