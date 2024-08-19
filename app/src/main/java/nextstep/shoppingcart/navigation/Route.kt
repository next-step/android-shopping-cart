package nextstep.shoppingcart.navigation

import kotlinx.serialization.Serializable
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.model.serializableType
import kotlin.reflect.typeOf

@Serializable
object ProductListRoute

@Serializable
internal data class ProductDetailRoute(val product: Product) {
    companion object {
        val typeMap = mapOf(typeOf<Product>() to serializableType<Product>())
    }
}