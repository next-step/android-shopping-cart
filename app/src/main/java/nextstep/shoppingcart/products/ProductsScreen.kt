package nextstep.shoppingcart.products

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import nextstep.shoppingcart.NavigationItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsScreen(navHostController: NavHostController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "상품 목록") },
                actions = {
                    IconButton(
                        onClick = {
                            navHostController.navigate(NavigationItem.Cart.route)
                        },
                    ) {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "뒤로가기",
                        )
                    }
                })
        }
    ) { innerPadding ->
        Text(
            modifier = Modifier.padding(innerPadding),
            text = "Products",
        )
    }
}
