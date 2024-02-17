package nextstep.shoppingcart.products

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import nextstep.shoppingcart.NavigationItem
import nextstep.shoppingcart.products.component.GridProductItems
import nextstep.shoppingcart.products.component.ProductsScreenTopBar

@Composable
fun ProductsScreen(
    navHostController: NavHostController,
    productItemUiStates: List<ProductItemUiState>,
) {
    Scaffold(
        topBar = {
            ProductsScreenTopBar(
                onCartIconClick = { navHostController.navigate(NavigationItem.Cart.route) }
            )
        }
    ) { innerPadding ->
        GridProductItems(
            modifier = Modifier.padding(innerPadding),
            productItemUiStates = productItemUiStates,
            onItemClick = { navHostController.navigate(NavigationItem.ProductDetail.route) },
            onFloatingButtonClick = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductsScreenPreview() {
    ProductsScreen(
        navHostController = rememberNavController(),
        productItemUiStates = StubProductItemUiStates,
    )
}
