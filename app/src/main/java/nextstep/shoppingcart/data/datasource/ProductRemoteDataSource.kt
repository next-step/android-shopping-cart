package nextstep.shoppingcart.data.datasource

import kotlinx.coroutines.delay
import nextstep.shoppingcart.data.model.ProductResponse
import java.util.UUID
import kotlin.math.absoluteValue
import kotlin.random.Random

class ProductRemoteDataSource {

    private val random = Random(System.currentTimeMillis())

    suspend fun fetchProducts(category: String): List<ProductResponse> {
        delay(random.nextLong(100L, 200L))

        return dummyProducts.getOrDefault(category, emptyList())
    }

    suspend fun fetchCategory(): List<String> {
        delay(random.nextLong(100L, 300L))

        return categories
    }

    companion object {
        private val categories = listOf(
            "밥·도시락",
            "라면·면",
            "국·탕·찌개",
            "과일·채소·샐러드",
            "정육·수산·계란"
        )

        private val dummyProducts = hashMapOf<String, List<ProductResponse>>()

        init {
            categories.forEach { category ->
                dummyProducts[category] = List(50) { index ->
                    val uuid = UUID.randomUUID()
                    val seed = uuid.mostSignificantBits.absoluteValue % 10_000

                    ProductResponse(
                        id = uuid.toString(),
                        imageUrl = "https://picsum.photos/200/300?random=$seed",
                        name = "$category 상품 ${index + 1}",
                        category = category,
                        price = (1000..10000).random()
                    )
                }
            }
        }
    }
}
