package nextstep.shoppingcart.model

import nextstep.shoppingcart.domain.model.Price
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PriceTest {
    @Test
    fun `가격의 값이 음수라면 0원으로 처리된다`() {
        // when
        val price = Price.of(-1)

        // then
        assertThat(price.value).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 1000])
    fun `가격의 값이 0보다 크거나 같다면 그대로 해당 값으로 유지된다`(value: Int) {
        // when
        val price = Price.of(value)

        // then
        assertThat(price.value).isEqualTo(value)
    }
}
