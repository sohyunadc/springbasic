package poolparty.core;

import poolparty.core.member.Grade;
import poolparty.core.member.Member;
import poolparty.core.member.MemberService;
import poolparty.core.member.MemberServiceImpl;
import poolparty.core.order.Order;
import poolparty.core.order.OrderService;
import poolparty.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "caitlyn", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "BF", 13000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());

    }
}
