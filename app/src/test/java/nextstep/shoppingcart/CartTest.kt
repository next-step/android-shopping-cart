package nextstep.shoppingcart

import nextstep.shoppingcart.data.Cart
import nextstep.shoppingcart.model.Product
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class CartTest {

    @Before
    fun setup() {
        Cart.clear()
    }

    @Test
    fun 장바구니에_상품을_하나_추가하면_장바구니_아이템이_추가된다() {
        // given
        val product = Product(
            name = "iPhone 15 Pro Max",
            imageUrl = "https://img.danawa.com/prod_img/500000/334/189/img/28189334_1.jpg",
            price = 1_900_000,
        )

        // when
        Cart.addOne(product)

        // then
        Assert.assertEquals(Cart.items.size, 1)
        Assert.assertEquals(Cart.totalPrice, 1_900_000)
        Assert.assertNotNull(Cart.items.find { it.product == product })
    }

    @Test
    fun 장바구니에_같은_상품을_두개_추가하면_장바구니_아이템은_하나이다() {
        // given
        val product = Product(
            name = "iPhone 15 Pro Max",
            imageUrl = "https://img.danawa.com/prod_img/500000/334/189/img/28189334_1.jpg",
            price = 1_900_000,
        )

        // when
        Cart.addOne(product)
        Cart.addOne(product)

        // then
        Assert.assertEquals(Cart.items.size, 1)
        Assert.assertEquals(Cart.totalPrice, 3_800_000)
    }

    @Test
    fun 장바구니에_다른_상품을_두개_추가하면_장바구니_아이템이_추가된다() {
        // given
        val product1 = Product(
            name = "iPhone 15 Pro Max",
            imageUrl = "https://img.danawa.com/prod_img/500000/334/189/img/28189334_1.jpg",
            price = 1_900_000,
        )
        val product2 = Product(
            name = "iPhone 15 Pro",
            imageUrl = "https://img.danawa.com/prod_img/500000/767/209/img/28209767_1.jpg",
            price = 1_550_000,
        )

        // when
        Cart.addOne(product1)
        Cart.addOne(product2)

        // then
        Assert.assertEquals(Cart.items.size, 2)
        Assert.assertEquals(Cart.totalPrice, 3_450_000)
    }

    @Test
    fun 같은_상품이_2개_들어있는_장바구니에_하나_제거하면_갯수가_1이된다() {
        // given
        val product = Product(
            name = "iPhone 15 Pro Max",
            imageUrl = "https://img.danawa.com/prod_img/500000/334/189/img/28189334_1.jpg",
            price = 1_900_000,
        )
        Cart.addOne(product)
        Cart.addOne(product)

        // when
        Cart.removeOne(product)

        // then
        Assert.assertEquals(Cart.items.size, 1)
        Assert.assertEquals(Cart.totalPrice, 1_900_000)
    }

    @Test
    fun 한개의_상품이_들어있는_장바구니에_하나_제거하면_장바구니_아이템은_없어진다() {
        // given
        val product = Product(
            name = "iPhone 15 Pro Max",
            imageUrl = "https://img.danawa.com/prod_img/500000/334/189/img/28189334_1.jpg",
            price = 1_900_000,
        )
        Cart.addOne(product)

        // when
        Cart.removeOne(product)

        // then
        Assert.assertEquals(Cart.items.size, 0)
    }

    @Test
    fun 상품을_제거하면_장바구니_아이템은_없어진다() {
        // given
        val product = Product(
            name = "iPhone 15 Pro Max",
            imageUrl = "https://img.danawa.com/prod_img/500000/334/189/img/28189334_1.jpg",
            price = 1_900_000,
        )
        Cart.addOne(product)
        Cart.addOne(product)

        // when
        Cart.removeAll(product)

        // then
        Assert.assertEquals(Cart.items.size, 0)
    }

}
