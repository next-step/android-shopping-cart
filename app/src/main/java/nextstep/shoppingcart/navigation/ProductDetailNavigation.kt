package nextstep.shoppingcart.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import nextstep.shoppingcart.ui.shopping.model.Product
import nextstep.shoppingcart.ui.shopping.productdetail.ProductDetailScreen


fun NavController.navigateToProductDetailScreen(product: Product) {
    val route = ShoppingRoute.PRODUCT_DETAIL
        .replace("{name}", product.name)
        .replace("{imageUrl}", product.imageUrl)
        .replace("{price}", product.price.toString())
    navigate(route)
}

fun NavGraphBuilder.productDetail(
    onClickNavigateBack: () -> Unit,
    onClickCartButton: () -> Unit
) {
    composable(
        route = ShoppingRoute.PRODUCT_DETAIL,
        arguments = listOf(
            navArgument("name") { type = NavType.StringType },
            navArgument("imageUrl") { type = NavType.StringType },
            navArgument("price") { type = NavType.LongType }
        )
    ) { backStackEntry ->
        val name = backStackEntry.arguments?.getString("name") ?: ""
        val imageUrl = backStackEntry.arguments?.getString("imageUrl") ?: ""
        val price = backStackEntry.arguments?.getLong("price") ?: 0L
        ProductDetailScreen(
            name = name,
            imageUrl = imageUrl,
            price = price,
            onClickNavigateBack = onClickNavigateBack,
            onClickCartButton = onClickCartButton
        )
    }
}
