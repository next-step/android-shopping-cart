package nextstep.shoppingcart.ui.cart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import nextstep.shoppingcart.ui.component.ShoppingTopBar

@Composable
fun ShoppingCart(navController: NavHostController) {
    Scaffold(
        topBar = {
            ShoppingTopBar(
                navController,
                title = "장바구니"
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {

        }
    }
}

@Preview
@Composable
private fun ShoppingCartPreview() {
    ShoppingCart(navController = rememberNavController())
}