package nextstep.shoppingcart.productlist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import nextstep.shoppingcart.common.model.Product
import nextstep.shoppingcart.common.model.dummyProducts

internal fun NavController.navigateProductList() {
    navigate(ProductListRoute)
}

internal fun NavGraphBuilder.productListNavGraph(
    onProductClick: (Product) -> Unit,
    onCartClick: () -> Unit,
) {
    composable<ProductListRoute> {
        val products by remember { mutableStateOf(dummyProducts) }

        ProductListScreen(
            products = products,
            onProductClick = onProductClick,
            onCartClick = onCartClick,
        )
    }
}