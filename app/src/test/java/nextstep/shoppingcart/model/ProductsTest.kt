package nextstep.shoppingcart.model

import nextstep.shoppingcart.data.FakeProductRepository
import nextstep.shoppingcart.domain.model.Price
import nextstep.shoppingcart.domain.model.Product
import nextstep.shoppingcart.domain.model.Products
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ProductsTest {
    @Test
    fun `상품을 id를 기준으로 가져올 수 있다`() {
        // given
        val products: Products = FakeProductRepository.getAllProducts()
        val id = 5

        // when
        val actual: Product? = products.getProductByIdOrNull(id)

        // then
        assertThat(actual).isEqualTo(
            Product(
                id = 5,
                name = "External Hard Drive",
                price = Price.of(11000),
                imageUrl = "https://media.istockphoto.com/id/2135718673/ko/%EC%82%AC%EC%A7%84/usb%EB%A5%BC-%ED%86%B5%ED%95%B4-%EC%B5%9C%EC%8B%A0-%EB%85%B8%ED%8A%B8%EB%B6%81%EC%97%90-%EC%97%B0%EA%B2%B0%EB%90%9C-%EC%99%B8%EC%9E%A5-%ED%95%98%EB%93%9C-%EB%94%94%EC%8A%A4%ED%81%AC-%EB%93%9C%EB%9D%BC%EC%9D%B4%EB%B8%8C.jpg?s=2048x2048&w=is&k=20&c=zIxxhouNFbgoZ_p1RDMdYU548omU6Ha3gLbjfFqgp3c="
            )
        )
    }

    @Test
    fun `상품을 id를 기준으로 가져올때 일치하는 id의 상품이 없다면 null을 반환한다`() {
        // given
        val products: Products = FakeProductRepository.getAllProducts()
        val id = -1

        // when
        val actual: Product? = products.getProductByIdOrNull(id)

        // then
        assertThat(actual).isNull()
    }
}
