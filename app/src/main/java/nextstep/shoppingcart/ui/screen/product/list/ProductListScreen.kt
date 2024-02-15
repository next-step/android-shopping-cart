package nextstep.shoppingcart.ui.screen.product.list

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
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ProductListScreen(onClickCart: () -> Unit = {}) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "상품 목록") },
                actions = {
                    IconButton(onClick = { onClickCart() }) {
                        Icon(
                            imageVector = Icons.Filled.ShoppingCart,
                            contentDescription = "장바구니"
                        )
                    }
                },
            )
        }
    ) { innerPadding ->
        Text(
            text = "상품 목록",
            modifier = Modifier.padding(innerPadding)
        )
    }
}
