package nextstep.shoppingcart.products.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import nextstep.shoppingcart.products.detail.component.ProductDetailScreenTopBar

@Composable
fun ProductDetailScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            ProductDetailScreenTopBar(navController)
        }
    ) { innerPadding ->
        Text(
            text = "ProductDetailScreen",
            modifier = Modifier.padding(innerPadding)
        )
    }
}
