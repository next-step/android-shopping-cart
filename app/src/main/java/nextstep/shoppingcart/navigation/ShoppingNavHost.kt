package nextstep.shoppingcart.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController


@Composable
fun ShoppingNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ShoppingRoute.PRODUCT_LIST
    ) {
        // 상품 목록
        productList()
        // 상품 상세
        productDetail()
        // 장바구니
        shoppingCart()
    }
}
