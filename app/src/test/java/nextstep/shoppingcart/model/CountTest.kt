package nextstep.shoppingcart.model

import nextstep.shoppingcart.domain.model.Count
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class CountTest {
    @Test
    fun `개수의 값이 1미만이면 최소값인 1로 지정된다`() {
        // when
        val countOfMinusOne = Count.of(-1)
        val countOfZero = Count.of(0)

        // then
        assertAll(
            { assertThat(countOfMinusOne.value).isEqualTo(1) },
            { assertThat(countOfZero.value).isEqualTo(1) },
        )
    }

    @Test
    fun `개수의 값을 증가시킬 수 있다`() {
        // given
        val count = Count.ONE

        // when
        val actual = count.increase()

        // then
        assertThat(actual.value).isEqualTo(2)
    }

    @Test
    fun `개수의 값을 감소시킬 수 있다`() {
        // given
        val count: Count = Count.of(5)

        // when
        val actual: Count = count.decrease()

        // then
        assertThat(actual.value).isEqualTo(4)
    }

    @Test
    fun `개수의 값이 최소값인 1일때, 값을 감소시켜도 그대로 1이다`() {
        // given
        val count = Count.ONE

        // when
        val actual = count.decrease()

        // then
        assertThat(actual.value).isEqualTo(1)
    }
}
