package poolparty.core.order;

import poolparty.core.discount.DiscountPolicy;
import poolparty.core.discount.FixDiscountPolicy;
import poolparty.core.member.Member;
import poolparty.core.member.MemberRepository;
import poolparty.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

}
