package nextstep.shoppingcart.ui.screen

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.FakeData
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.ui.screen.component.CenterAppBar
import androidx.compose.runtime.setValue
import nextstep.shoppingcart.ui.screen.component.BackAppBar

enum class ProductDestination(@StringRes val title: Int) {
    ProductList(title = R.string.appbar_product_title),
    ProductDetail(title = R.string.appbar_product_detail_title),
    ShoppingCart(title = R.string.appbar_shopping_cart_title)
}

@Composable
fun ProductApp() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = ProductDestination.valueOf(
        navBackStackEntry?.destination?.route ?: ProductDestination.ProductList.name
    )

    val fakeItemList = FakeData.products
    var seletedProduct by remember { mutableStateOf<Product?>(null) }
    var addCartProduct by remember { mutableStateOf<Product?>(null) }

    Scaffold(
        topBar = {
            if (currentScreen == ProductDestination.ProductList) {
                CenterAppBar(
                    title = stringResource(id = currentScreen.title),
                    onClick = {
                        navController.navigate(ProductDestination.ShoppingCart.name)
                    }
                )
            } else {
                BackAppBar(
                    title = stringResource(id = currentScreen.title),
                    canNavigateBack = navController.previousBackStackEntry != null,
                    backButton = { navController.popBackStack() }
                )
            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = ProductDestination.ProductList.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            composable(
                route = ProductDestination.ProductList.name
            ) {
                ProductScreen(
                    productList = fakeItemList,
                    onProductClick = { product ->
                        seletedProduct = product
                        navController.navigate(ProductDestination.ProductDetail.name)
                    }
                )
            }
            composable(
                route = ProductDestination.ProductDetail.name,
            ) { backStackEntry ->
                ProductDetailScreen(
                    product = seletedProduct!!,
                    addProductClick = { product ->
                        addCartProduct = product
                        navController.navigate(ProductDestination.ShoppingCart.name)
                    }
                )
            }
            composable(
                route = ProductDestination.ShoppingCart.name,
            ) { backStackEntry ->
                ShoppingCartScreen()
            }
        }
    }
}