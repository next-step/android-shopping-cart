package nextstep.shoppingcart.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.toRoute
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.product_detail.ProductDetailScreen
import nextstep.shoppingcart.ui.product_list.ProductListScreen

@Composable
fun NavigationRoot(
    navController: NavHostController,
) {
    NavHost(
        startDestination = ProductDestination,
        navController = navController,
    ) {
        productGraph(navController)
    }
}

private fun NavGraphBuilder.productGraph(navController: NavController) {
    navigation<ProductDestination>(
        startDestination = ProductList,
    ) {
        composable<ProductList> {
            ProductListScreen(
                onProductClick = {
                    navController.navigate(ProductDetail(it.imageUrl, it.name, it.price))
                }
            )
        }

        composable<ProductDetail> { backstackEntry ->
            val productDetail = backstackEntry.toRoute<ProductDetail>()

            ProductDetailScreen(
                product = Product(
                    imageUrl = productDetail.imageUrl,
                    name = productDetail.name,
                    price = productDetail.price
                ),
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
