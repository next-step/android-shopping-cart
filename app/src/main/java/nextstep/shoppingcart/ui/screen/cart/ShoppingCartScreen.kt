@file:OptIn(ExperimentalMaterial3Api::class)

package nextstep.shoppingcart.ui.screen.cart

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList
import nextstep.shoppingcart.ui.screen.cart.component.CartItem
import nextstep.shoppingcart.ui.screen.cart.model.Product
import nextstep.shoppingcart.ui.screen.cart.model.dummyProducts
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ShoppingCartRoute(
    modifier: Modifier = Modifier
) {
    ShoppingCartScreen(
        cartItems = dummyProducts.toPersistentList(),
        modifier = modifier
    )
}

@Composable
private fun ShoppingCartScreen(
    cartItems: PersistentList<Product>,
    modifier: Modifier = Modifier
) {
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
        LazyVerticalGrid(
            modifier = Modifier.padding(it),
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(top = 13.dp)
        ) {
            items(cartItems) { item ->
                CartItem(
                    product = item,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun ShoppingCartScreenPreview() {
    ShoppingCartTheme {
        ShoppingCartScreen(
            cartItems = dummyProducts.toPersistentList(),
        )
    }
}
