package nextstep.shoppingcart

import nextstep.shoppingcart.model.Product

object FakeProductsRepository {
    fun getProducts(): List<Product> {
        return (1L..100L).map { id ->
            Product(
                id = id,
                name = "상품$id",
                price = 10000L,
                imageUrl = "https://picsum.photos/200",
            )
        }
    }

    fun getProduct(id: Long): Product {
        return Product(
            id = id,
            name = "상품$id",
            price = 10000L,
            imageUrl = "https://picsum.photos/200",
        )
    }
}
