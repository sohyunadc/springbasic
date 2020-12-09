package poolparty.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import poolparty.core.member.Grade;
import poolparty.core.member.Member;
import poolparty.core.member.MemberService;
import poolparty.core.member.MemberServiceImpl;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "caitlyn", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "BF", 13000);
        Assertions.assertThat(order.calculatePrice()).isEqualTo(12000);
    }
}
