package nextstep.shoppingcart.productlist

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import nextstep.shoppingcart.common.model.Product

internal fun NavController.navigateProductList() {
    navigate(ProductListRoute)
}

internal fun NavGraphBuilder.productListNavGraph(
    onProductClick: (Product) -> Unit,
    onCartClick: () -> Unit,
) {
    composable<ProductListRoute> {

        ProductListRoute(
            onProductClick = onProductClick,
            onCartClick = onCartClick
        )
    }
}