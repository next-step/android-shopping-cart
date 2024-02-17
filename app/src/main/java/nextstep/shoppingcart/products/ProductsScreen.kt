package nextstep.shoppingcart.products

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import nextstep.shoppingcart.NavigationItem
import nextstep.shoppingcart.products.component.ProductsScreenTopBar

@Composable
fun ProductsScreen(navHostController: NavHostController) {
    Scaffold(
        topBar = {
            ProductsScreenTopBar(
                onCartIconClick = { navHostController.navigate(NavigationItem.Cart.route) }
            )
        }
    ) { innerPadding ->
        Text(
            modifier = Modifier.padding(innerPadding),
            text = "Products",
        )
    }
}
