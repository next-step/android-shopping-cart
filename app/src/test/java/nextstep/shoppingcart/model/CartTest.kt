package nextstep.shoppingcart.model

import nextstep.shoppingcart.domain.model.Cart
import nextstep.shoppingcart.domain.model.CartItem
import nextstep.shoppingcart.domain.model.Count
import nextstep.shoppingcart.domain.model.Price
import nextstep.shoppingcart.domain.model.Product
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CartTest {
    @Test
    fun `장바구니가 가진 상품 가격의 총합을 계산할 수 있다`() {
        // given
        val cart = Cart(
            initialItems = listOf(
                CartItem(
                    product = Product(
                        id = 1, name = "과자", price = Price.of(value = 2000), imageUrl = "",
                    ),
                    count = Count.of(2),
                ),
                CartItem(
                    product = Product(
                        id = 2, name = "비누", price = Price.of(value = 1000), imageUrl = "",
                    ),
                    count = Count.of(5),
                ),
            )
        )

        // when
        val actual = cart.totalPrice

        // then
        assertThat(actual).isEqualTo(9000)
    }

    @Test
    fun `장바구니가 가진 상품이 없을 때 총 가격을 계산하면 0이다`() {
        // given
        val cart = Cart() // default value가 emptyList()

        // when
        val actual = cart.totalPrice

        // then
        assertThat(actual).isZero()
    }

    @Test
    fun `장바구니에 추가하고자하는 상품이 없다면 추가한다`() {
        // given
        val cart = Cart()
        val product = Product(
            id = 1,
            name = "과자",
            price = Price.of(value = 2000),
            imageUrl = "",
        )

        // when
        val actual: Cart = cart.addOne(product)

        // then
        assertThat(actual.items).isEqualTo(
            listOf(
                CartItem(
                    product = product,
                    count = Count.ONE,
                ),
            )
        )
    }

    @Test
    fun `장바구니에 이미 추가하고자하는 상품이 존재한다면 개수만 증가한다`() {
        // given
        val product = Product(
            id = 1, name = "과자", price = Price.of(value = 2000), imageUrl = "",
        )
        val cart = Cart(
            listOf(
                CartItem(product = product, count = Count.ONE)
            )
        )

        // when
        val actual = cart.addOne(product)

        // then
        assertThat(actual.items).isEqualTo(
            listOf(
                CartItem(
                    product = product,
                    count = Count.of(2),
                )
            )
        )
    }

    @Test
    fun `장바구니에 존재하는 상품의 개수를 감소할 수 있다`() {
        // given
        val product = Product(
            id = 1,
            name = "과자",
            price = Price.of(value = 2000),
            imageUrl = "",
        )
        val cart = Cart(
            listOf(
                CartItem(
                    product = product,
                    count = Count.of(5),
                )
            )
        )

        // when
        val actual = cart.removeOne(product)

        // then
        assertThat(actual.items).isEqualTo(
            listOf(
                CartItem(
                    product = product,
                    count = Count.of(4),
                )
            )
        )
    }

    @Test
    fun `장바구니에서 제거하고자하는 상품의 개수가 1개라면 장바구니에서 상품이 제거된다`() {
        // given
        val product = Product(
            id = 1,
            name = "과자",
            price = Price.of(value = 2000),
            imageUrl = "",
        )
        val cart = Cart(
            listOf(
                CartItem(
                    product = product,
                    count = Count.ONE,
                )
            )
        )

        // when
        val actual = cart.removeOne(product)

        // then
        assertThat(actual.items).isEmpty()
    }

    @Test
    fun `장바구니에서 제거하고자하는 상품이 존재하지 않는다면 그대로 같은 장바구니를 반환한다`() {
        // given
        val product = Product(
            id = 1,
            name = "과자",
            price = Price.of(value = 2000),
            imageUrl = "",
        )
        val cart = Cart()

        // when
        val actual = cart.removeOne(product)

        // then
        assertThat(actual).isSameAs(cart)
    }

    @Test
    fun `장바구니에서 상품의 개수와 상관없이 상품을 한번에 제거 할 수 있다`() {
        // given
        val product = Product(
            id = 1,
            name = "과자",
            price = Price.of(value = 2000),
            imageUrl = "",
        )
        val cart = Cart(
            listOf(
                CartItem(
                    product = product,
                    count = Count.of(10),
                )
            )
        )

        // when
        val actual = cart.removeAll(product)

        // then
        assertThat(actual.items).isEmpty()
    }

    @Test
    fun `장바구니에서 상품의 개수와 상관없이 상품을 한번에 제거할 때 상품이 존재하지 않는다면 그대로 같은 장바구니를 반환한다`() {
        // given
        val product = Product(
            id = 1,
            name = "과자",
            price = Price.of(value = 2000),
            imageUrl = "",
        )
        val cart = Cart()

        // when
        val actual = cart.removeAll(product)

        // then
        assertThat(actual).isSameAs(cart)
    }
}
