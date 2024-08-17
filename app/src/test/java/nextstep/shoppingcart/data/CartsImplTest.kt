package nextstep.shoppingcart.data

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertNull
import junit.framework.TestCase.assertTrue
import nextstep.shoppingcart.domain.model.Product
import org.junit.Test

class CartsImplTest {
    @Test
    fun 카트에_상품을_추가하면_카트_목록에_상품이_추가된다() {
        // given
        val carts: Carts = CartsImpl()
        val product =
            Product(
                id = 1,
                name = "상품1",
                price = 1000,
                imgUrl = "https://image.com",
            )

        // when
        carts.add(product)

        // then
        assertEquals(1, carts.items.size)
        assertNotNull(carts.items.find { it.product == product })
    }

    @Test
    fun 카트에_상품을_삭제하면_카트_목록에_상품이_삭제된다() {
        // given
        val carts: Carts = CartsImpl()
        val product =
            Product(
                id = 1,
                name = "상품1",
                price = 1000,
                imgUrl = "https://image.com",
            )
        carts.add(product)

        // when
        carts.remove(product)

        // then
        assertEquals(0, carts.items.size)
        assertNull(carts.items.find { it.product == product })
    }

    // 전체 삭제
    @Test
    fun 카트에_상품을_전체_삭제하면_카트_목록이_비어있다() {
        // given
        val carts: Carts = CartsImpl()
        val product1 =
            Product(
                id = 1,
                name = "상품1",
                price = 1000,
                imgUrl = "https://image.com",
            )
        val product2 =
            Product(
                id = 2,
                name = "상품2",
                price = 2000,
                imgUrl = "https://image.com",
            )
        carts.add(product1)
        carts.add(product2)

        // when
        carts.removeAll()

        // then
        assertTrue(carts.items.isEmpty())
    }

    // 상품이 중복 추가되었을 때 수량이 상승
    @Test
    fun 카트에_동일_상품이_추가되면_수량이_상승한다() {
        // given
        val carts: Carts = CartsImpl()
        val product =
            Product(
                id = 1,
                name = "상품1",
                price = 1000,
                imgUrl = "https://image.com",
            )

        // when
        carts.add(product)
        carts.add(product)

        // then
        assertEquals(1, carts.items.size)
        assertEquals(2, carts.items.find { it.product == product }?.count)
    }

    // 상품이 중복 추가되었을 때 총 가격이 상승
    @Test
    fun 카트에_동일_상품이_추가되면_총_가격이_상승한다() {
        // given
        val carts: Carts = CartsImpl()
        val product =
            Product(
                id = 1,
                name = "상품1",
                price = 1000,
                imgUrl = "https://image.com",
            )

        // when
        carts.add(product)
        carts.add(product)

        // then
        assertEquals(2000, carts.totalPrice)
    }

    // 상품이 중복 삭제되었을 때 수량이 감소
    @Test
    fun 카트에_동일_상품이_삭제되면_수량이_감소한다() {
        // given
        val carts: Carts = CartsImpl()
        val product =
            Product(
                id = 1,
                name = "상품1",
                price = 1000,
                imgUrl = "https://image.com",
            )
        carts.add(product)
        carts.add(product)

        // when
        carts.remove(product)

        // then
        assertEquals(1, carts.items.find { it.product == product }?.count)
    }

    // 상품이 중복 삭제되었을 때 총 가격이 감소
    @Test
    fun 카트에_동일_상품이_삭제되면_총_가격이_감소한다() {
        // given
        val carts: Carts = CartsImpl()
        val product =
            Product(
                id = 1,
                name = "상품1",
                price = 1000,
                imgUrl = "https://image.com",
            )
        carts.add(product)

        // when
        carts.remove(product)

        // then
        assertEquals(0, carts.totalPrice)
    }
}
