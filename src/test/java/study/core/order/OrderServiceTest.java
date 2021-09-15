package study.core.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.core.discount.AppConfig;
import study.core.member.Grade;
import study.core.member.Member;
import study.core.member.MemberService;

import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceTest {

    AppConfig appConfig = new AppConfig();
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

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