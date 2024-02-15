package nextstep.shoppingcart.ui.feature

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import nextstep.shoppingcart.ui.navigation.Navigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "상품 목록") },
                actions = {
                    IconButton(onClick = { navController.navigate(Navigation.Cart.route) }) {
                        Icon(
                            imageVector = Icons.Filled.ShoppingCart,
                            contentDescription = "장바구니"
                        )
                    }
                },
            )
        }
    ) { innerPadding ->
        Button(
            modifier = Modifier.padding(innerPadding),
            onClick = { navController.navigate(Navigation.ProductDetail.route) },
            content = {
                Text(text = "ProductDetailScreen")
            }
        )
    }
}
