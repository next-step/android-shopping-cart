package nextstep.shoppingcart.util

import kotlinx.coroutines.delay
import nextstep.shoppingcart.model.Product

object DataUtil {
    val dummyProducts = listOf(
        Product(
            "PET보틀-원형(500ml)",
            42200,
            "https://picsum.photos/id/30/1280/901"
        ),
        Product(
            "PET보틀-원형(500ml)",
            42200,
            "https://picsum.photos/id/30/1280/901"
        ),
        Product(
            "PET보틀-원형(500ml)",
            42200,
            "https://picsum.photos/id/30/1280/901"
        ),
        Product(
            "PET보틀-원형(500ml)",
            42200,
            "https://picsum.photos/id/30/1280/901"
        ),
        Product(
            "PET보틀-원형(500ml)",
            42200,
            "https://picsum.photos/id/30/1280/901"
        ),
    )

    suspend fun getProducts(): List<Product> {
        delay(500)
        return dummyProducts
    }
}