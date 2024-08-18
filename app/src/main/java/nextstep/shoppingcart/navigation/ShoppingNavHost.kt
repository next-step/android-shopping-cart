package nextstep.shoppingcart.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import nextstep.shoppingcart.ui.shopping.cart.navigation.navigateToShoppingCartScreen
import nextstep.shoppingcart.ui.shopping.cart.navigation.shoppingCart
import nextstep.shoppingcart.ui.shopping.productdetail.navigation.navigateToProductDetailScreen
import nextstep.shoppingcart.ui.shopping.productdetail.navigation.productDetail
import nextstep.shoppingcart.ui.shopping.productlist.navigation.productList


@Composable
fun ShoppingNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ShoppingRoute.PRODUCT_LIST,
        modifier = modifier
    ) {
        // 상품 목록
        productList(
            onClickItem = { product ->
                navController.navigateToProductDetailScreen(product)
            },
            onClickShoppingCart = {
                navController.navigateToShoppingCartScreen()
            }
        )
        // 상품 상세
        productDetail(
            onClickNavigateBack = {
                navController.navigateUp()
            },
            onClickCartButton = {
                navController.navigateToShoppingCartScreen()
            }
        )
        // 장바구니
        shoppingCart(
            onClickNavigateBack = {
                navController.navigateUp()
            }
        )
    }
}
