package nextstep.shoppingcart.navigation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.productlist.ProductListScreen
import java.util.UUID

internal fun NavController.navigateProductList() {
    navigate(ProductListRoute)
}

internal fun NavGraphBuilder.productListNavGraph(
    onProductClick: (Product) -> Unit,
) {
    composable<ProductListRoute> {
        val products by remember {
            mutableStateOf(
                List(20) {
                    Product(
                        id = UUID.randomUUID().toString(),
                        name = "PET보틀 - 정사각형 모양",
                        price = 10000,
                        imageUrl = "https://picsum.photos/500"
                    )
                }.distinctBy { it.id }
            )
        }

        ProductListScreen(
            products = products,
            onProductClick = onProductClick
        )
    }
}