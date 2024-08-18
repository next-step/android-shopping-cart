package nextstep.shoppingcart.data.goods.impl

import nextstep.shoppingcart.data.goods.Product
import nextstep.shoppingcart.data.goods.ProductRepository

class ProductRepositoryImpl : ProductRepository {
    override fun getProducts(): List<Product> {
        return listOf(
            Product(
                productId = 1,
                name = "PET보틀-정사각형",
                price = 10000,
                imageUrl = "https://picsum.photos/156/158"
            ),
            Product(
                productId = 2,
                name = "PET보틀-밀크티",
                price = 12000,
                imageUrl = "https://picsum.photos/156/158"
            ),
            Product(
                productId = 3,
                name = "PET보틀-정사각각형",
                price = 10000,
                imageUrl = "https://picsum.photos/156/158"
            ),
            Product(
                productId = 4,
                name = "PET보틀-납작(200ml)",
                price = 12000,
                imageUrl = "https://picsum.photos/156/158"
            ),
            Product(
                productId = 5,
                name = "PET보틀-정사각형",
                price = 10000,
                imageUrl = "https://picsum.photos/156/158"
            ),
            Product(
                productId = 6,
                name = "PET보틀-납작(200ml)",
                price = 12000,
                imageUrl = "https://picsum.photos/156/158"
            ),
            Product(
                productId = 7,
                name = "PET보틀-정사각형",
                price = 10000,
                imageUrl = "https://picsum.photos/156/158"
            ),
            Product(
                productId = 8,
                name = "PET보틀-납작(200ml)",
                price = 12000,
                imageUrl = "https://picsum.photos/156/158"
            )
        )
    }

    override fun getProduct(productId: Int): Product? {
        return getProducts().firstOrNull { it.productId == productId }
    }
}