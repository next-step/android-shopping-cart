package nextstep.shoppingcart.ui.shoppingdetail

import androidx.compose.runtime.Composable
import nextstep.shoppingcart.data.Cart.addOne
import nextstep.shoppingcart.data.Products.findProductById

@Composable
fun ShoppingDetailRoute(
    productId: Long,
    onBackClick: () -> Unit,
    onAddClick: () -> Unit,
) {
    val product = findProductById(productId)

    ShoppingDetailScreen(
        product = product,
        onBackClick = onBackClick,
        onAddClick = {
            addOne(product)
            onAddClick()
        },
    )
}
