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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(
    onProductClick: () -> Unit,
    onCartClick: () -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "상품 목록") },
                actions = {
                    IconButton(onClick = { onCartClick() }) {
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
            onClick = { onProductClick() },
            content = {
                Text(text = "ProductDetailScreen")
            }
        )
    }
}
