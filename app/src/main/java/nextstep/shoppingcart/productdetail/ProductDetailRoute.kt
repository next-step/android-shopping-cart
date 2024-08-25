package nextstep.shoppingcart.productdetail

import androidx.compose.runtime.Composable
import kotlinx.serialization.Serializable
import nextstep.shoppingcart.common.model.Cart
import nextstep.shoppingcart.common.model.Product
import nextstep.shoppingcart.common.model.serializableType
import kotlin.reflect.typeOf

@Serializable
internal data class ProductDetailRoute(val product: Product) {

    companion object {
        val typeMap = mapOf(typeOf<Product>() to serializableType<Product>())
    }
}

@Composable
internal fun ProductDetailRoute(
    product: Product,
    onBackClick: () -> Unit,
) {
    ProductDetailScreen(
        product = product,
        onAddToCartClick = {
            Cart.addOne(product)
            onBackClick()
        },
        onBackClick = onBackClick,
    )
}