@file:OptIn(ExperimentalMaterial3Api::class)

package nextstep.shoppingcart.ui.screen.cart

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ShoppingCartRoute(
    modifier: Modifier = Modifier
) {
    ShoppingCartScreen(modifier)
}

@Composable
private fun ShoppingCartScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "상품 목록",
                        style = MaterialTheme.typography.titleLarge
                    )
                }, actions = {
                    IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(48.dp)) {
                        Icon(
                            imageVector = Icons.Filled.ShoppingCart, contentDescription = "장바구니"
                        )
                    }
                }
            )
        }
    ) {
        Text(text = "sample", modifier = Modifier.padding(it))
    }
}

@Preview
@Composable
private fun ShoppingCartScreenPreview() {
    ShoppingCartTheme {
        ShoppingCartScreen()
    }
}
