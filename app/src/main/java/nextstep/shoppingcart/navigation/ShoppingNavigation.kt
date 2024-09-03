package nextstep.shoppingcart.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import nextstep.shoppingcart.screen.ShoppingCartScreen
import nextstep.shoppingcart.screen.ShoppingDetailScreen
import nextstep.shoppingcart.screen.ShoppingListScreen

const val SHOPPING_LIST_ROUTE = "SHOPPING_LIST_ROUTE"
const val SHOPPING_DETAIL_ROUTE = "SHOPPING_DETAIL_ROUTE"
const val SHOPPING_CART_ROUTE = "SHOPPING_CART_ROUTE"

internal const val productIdArg = "productId"

fun NavController.navigateToDetail(
    productId : Int,
    navOptions: NavOptions? = null
) {
    this.navigate(SHOPPING_DETAIL_ROUTE + "/${productId}", navOptions)
}

fun NavController.navigateToCart(navOptions: NavOptions? = null) {
    this.navigate(SHOPPING_CART_ROUTE, navOptions)
}

fun NavGraphBuilder.shoppingListScreen(
    onClickDetail : (Int) -> Unit,
    onClickCart : () -> Unit
) {
    composable(
        route = SHOPPING_LIST_ROUTE
    ) {
        ShoppingListScreen(
            navigateToDetail = onClickDetail,
            navigateToCart = onClickCart
        )
    }
}

fun NavGraphBuilder.shoppingDetailScreen(
    onClickCart : () -> Unit,
    onClickBack : () -> Unit
) {
    composable(
        route = "$SHOPPING_DETAIL_ROUTE/{$productIdArg}",
        arguments = listOf(navArgument(productIdArg) { type = NavType.IntType })
    ) { entry ->
        entry.arguments?.getInt(productIdArg)?.let {
            ShoppingDetailScreen(
                productId = it,
                onClickCart = onClickCart,
                onClickBack = onClickBack
            )
        }

    }
}

fun NavGraphBuilder.shoppingCartScreen(
    onClickBack : () -> Unit
) {
    composable(
        route = SHOPPING_CART_ROUTE
    ) {
        ShoppingCartScreen(
            onBackClick = onClickBack
        )
    }
}