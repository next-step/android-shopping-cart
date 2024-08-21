package nextstep.shoppingcart.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import nextstep.shoppingcart.cart.navigateCart
import nextstep.shoppingcart.common.model.Product
import nextstep.shoppingcart.productdetail.navigateProductDetail
import nextstep.shoppingcart.productlist.ProductListRoute

internal class MainNavigator(
    val navController: NavHostController
) {
    val startDestination = ProductListRoute

    fun navigateProductList() {
        navController.navigate(ProductListRoute)
    }

    fun navigateProductDetail(product: Product) {
        navController.navigateProductDetail(product)
    }

    fun navigateCart() {
        navController.navigateCart()
    }

    fun popBackStack() {
        if (navController.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED) {
            navController.popBackStack()
        }
    }
}

@Composable
internal fun rememberMainNavigator(
    navController: NavHostController = rememberNavController()
): MainNavigator = remember(navController) { MainNavigator(navController) }