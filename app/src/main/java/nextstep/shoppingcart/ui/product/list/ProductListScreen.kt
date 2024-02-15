package nextstep.shoppingcart.ui.product.list

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import nextstep.shoppingcart.navigation.Navigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ProductListScreen(navHostController: NavHostController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "상품 목록") },
                actions = {
                    IconButton(onClick = { navHostController.navigate(Navigation.Cart.route) }) {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "장바구니",
                        )
                    }
                },
            )
        },
        content = { innerPadding ->
            Text("상품 목록", modifier = Modifier.padding(innerPadding))
        },
    )
}

@Preview
@Composable
private fun ProductListScreenPreview() {
    MaterialTheme {
        ProductListScreen(navHostController = rememberNavController())
    }
}
