package poolparty.core.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import poolparty.core.member.Grade;
import poolparty.core.member.Member;

import java.lang.annotation.RetentionPolicy;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    void vip_o() {
        // given
        Member member = new Member(1L, "caitlyn", Grade.VIP);

        // when
        int discount = discountPolicy.discount(member, 13000);

        // then
        assertThat(discount).isEqualTo(1300);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다")
    void vip_x() {
        // given
        Member member = new Member(1L, "ezreal", Grade.BASIC);

        // when
        int discount = discountPolicy.discount(member, 10000);

        // then
        assertThat(discount).isEqualTo(0);
//        Assertions.assertThat(discount).isEqualTo(1300);
    }
}