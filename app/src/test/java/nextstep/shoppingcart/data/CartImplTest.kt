package nextstep.shoppingcart.data

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertNull
import nextstep.shoppingcart.domain.model.Product
import org.junit.Test

class CartImplTest {
    @Test
    fun 카트에_상품을_추가하면_카트_목록에_상품이_추가된다() {
        // given
        val cart: Cart = CartImpl()
        val product =
            Product(
                id = 1,
                name = "상품1",
                price = 1000,
                imgUrl = "https://image.com",
            )

        // when
        cart.add(product)

        // then
        assertEquals(1, cart.items.size)
        assertNotNull(cart.items.find { it.product == product })
    }

    @Test
    fun 카트에_상품을_삭제하면_카트_목록에_상품이_삭제된다() {
        // given
        val cart: Cart = CartImpl()
        val product =
            Product(
                id = 1,
                name = "상품1",
                price = 1000,
                imgUrl = "https://image.com",
            )
        cart.add(product)

        // when
        cart.remove(product)

        // then
        assertEquals(0, cart.items.size)
        assertNull(cart.items.find { it.product == product })
    }

    // 상품이 중복 추가되었을 때 수량이 상승
    @Test
    fun 카트에_동일_상품이_추가되면_수량이_상승한다() {
        // given
        val cart: Cart = CartImpl()
        val product =
            Product(
                id = 1,
                name = "상품1",
                price = 1000,
                imgUrl = "https://image.com",
            )

        // when
        cart.add(product)
        cart.add(product)

        // then
        assertEquals(1, cart.items.size)
        assertEquals(2, cart.items.find { it.product == product }?.quantity)
    }

    // 상품이 중복 추가되었을 때 총 가격이 상승
    @Test
    fun 카트에_동일_상품이_추가되면_총_가격이_상승한다() {
        // given
        val cart: Cart = CartImpl()
        val product =
            Product(
                id = 1,
                name = "상품1",
                price = 1000,
                imgUrl = "https://image.com",
            )

        // when
        cart.add(product)
        cart.add(product)

        // then
        assertEquals(2000, cart.totalPrice)
    }

    // 상품이 중복 삭제되었을 때 수량이 감소
    @Test
    fun 카트에_동일_상품이_삭제되면_수량이_감소한다() {
        // given
        val cart: Cart = CartImpl()
        val product =
            Product(
                id = 1,
                name = "상품1",
                price = 1000,
                imgUrl = "https://image.com",
            )
        cart.add(product)
        cart.add(product)

        // when
        cart.remove(product)

        // then
        assertEquals(1, cart.items.find { it.product == product }?.quantity)
    }

    // 상품이 중복 삭제되었을 때 총 가격이 감소
    @Test
    fun 카트에_동일_상품이_삭제되면_총_가격이_감소한다() {
        // given
        val cart: Cart = CartImpl()
        val product =
            Product(
                id = 1,
                name = "상품1",
                price = 1000,
                imgUrl = "https://image.com",
            )
        cart.add(product)

        // when
        cart.remove(product)

        // then
        assertEquals(0, cart.totalPrice)
    }

    // 상품 취소
    @Test
    fun 카트에_상품을_취소하면_카트_목록에서_상품이_삭제된다() {
        // given
        val cart: Cart = CartImpl()
        val product =
            Product(
                id = 1,
                name = "상품1",
                price = 1000,
                imgUrl = "https://image.com",
            )
        val items = cart.add(product)

        // when
        cart.cancel(items.first())

        // then
        assertEquals(0, cart.items.size)
        assertNull(cart.items.find { it.product == product })
    }
}
