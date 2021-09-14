package study.core.order;

import org.junit.jupiter.api.Test;
import study.core.member.Grade;
import study.core.member.Member;
import study.core.member.MemberService;
import study.core.member.MemberServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    public void createOrder() {
        // given
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        // when
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        // then
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}