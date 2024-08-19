package nextstep.shoppingcart.model

import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
internal data class Product(
    val id: String,
    val name: String,
    val price: Int,
    val imageUrl: String?,
)

internal val dummyProducts = List(20) {
    Product(
        id = UUID.randomUUID().toString(),
        name = "PET보틀 - 정사각형 모양",
        price = 10000,
        imageUrl = "https://picsum.photos/500"
    )
}.distinctBy { it.id }
