package nextstep.shoppingcart.ui.shoppinglist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import nextstep.shoppingcart.data.Cart.addOne
import nextstep.shoppingcart.data.Cart.removeOne
import nextstep.shoppingcart.data.Products.dummyProducts
import nextstep.shoppingcart.data.Products.findProductById
import nextstep.shoppingcart.data.Products.updateProducts

@Composable
fun ShoppingListRoute(
    onShoppingCartClick: () -> Unit,
    onItemClick: (productId: Long) -> Unit,
) {
    var products by remember { mutableStateOf(dummyProducts.updateProducts()) }

    ShoppingListScreen(
        products = products,
        onShoppingCartClick = onShoppingCartClick,
        onItemClick = onItemClick,
        onPutClick = { cartProductId ->
            addOne(findProductById(cartProductId))
            products = dummyProducts.updateProducts()
        },
        onAddClick = { cartProductId ->
            addOne(findProductById(cartProductId))
            products = dummyProducts.updateProducts()
        },
        onSubtractClick = { cartProductId ->
            removeOne(findProductById(cartProductId))
            products = dummyProducts.updateProducts()
        },
    )
}
