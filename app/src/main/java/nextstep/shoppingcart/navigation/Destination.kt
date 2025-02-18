package nextstep.shoppingcart.navigation

import kotlinx.serialization.Serializable

/**
 * Product data class와 구분하기 위해 Destination 접미사 추가
 */
@Serializable
data object ProductDestination

@Serializable
data class ProductDetail(
    val id: String,
    val imageUrl: String,
    val name: String,
    val price: Int,
)

@Serializable
data object ProductList

@Serializable
data object Basket
