package nextstep.shoppingcart.productdetail

import kotlinx.serialization.Serializable
import nextstep.shoppingcart.common.model.Product
import nextstep.shoppingcart.common.model.serializableType
import kotlin.reflect.typeOf

@Serializable
internal data class ProductDetailRoute(val product: Product) {
    companion object {
        val typeMap = mapOf(typeOf<Product>() to serializableType<Product>())
    }
}