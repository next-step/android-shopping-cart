package nextstep.shoppingcart.ui.shoppingcart

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.data.Cart
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.BottomButton
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ShoppingCartScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    onItemAdd: (Product) -> Unit = {},
    onItemRemove: (Product) -> Unit = {},
    onDelete: (Product) -> Unit = {},
) {
    val products = Cart.items
    val totalPrice by remember { derivedStateOf { Cart.totalPrice } }

    Scaffold(
        modifier = modifier,
        topBar = {
            ShoppingCartTopAppBar(onBackClick = onBackClick)
        },
        bottomBar = {
            BottomButton(
                text = if (totalPrice > 0) "주문하기(${totalPrice}원)" else "주문하기"
            )
        }
    ) { paddingValues ->
        Surface(
            modifier = modifier.padding(paddingValues),
            color = Color.White
        ) {
            LazyColumn {
                items(items = products) { item ->
                    CartItem(
                        item = item,
                        onAdd = onItemAdd,
                        onRemove = onItemRemove,
                        onDelete = onDelete
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun ShoppingCartScreenPreview() {
    ShoppingCartTheme {
        ShoppingCartScreen()
    }
}