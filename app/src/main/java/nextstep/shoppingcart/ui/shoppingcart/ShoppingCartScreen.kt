package nextstep.shoppingcart.ui.shoppingcart

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.Cart
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.BottomButton
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import java.text.NumberFormat

@Composable
fun ShoppingCartScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    onItemAdd: (Product) -> Unit = {},
    onItemRemove: (Product) -> Unit = {},
    onDelete: (Product) -> Unit = {},
) {
    val products = Cart.items
    val totalPrice by remember { mutableStateOf(Cart.totalPrice) }

    ShoppingCardScreen(
        onBackClick = onBackClick,
        totalPrice = totalPrice,
        products = products,
        onItemAdd = onItemAdd,
        onItemRemove = onItemRemove,
        onDelete = onDelete,
        modifier = modifier
    )
}

@Composable
internal fun ShoppingCardScreen(
    onBackClick: () -> Unit,
    totalPrice: Int,
    products: List<CartItem>,
    onItemAdd: (Product) -> Unit,
    onItemRemove: (Product) -> Unit,
    onDelete: (Product) -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            ShoppingCartTopAppBar(onBackClick = onBackClick)
        },
        bottomBar = {
            BottomButton(
                text = if (totalPrice > 0) stringResource(
                    R.string.order_button_text_with_price,
                    NumberFormat.getNumberInstance().format(totalPrice)
                ) else stringResource(R.string.order_button_text)
            )
        },
        containerColor = Color.White
    ) { paddingValues ->
        LazyColumn(
            modifier = modifier.padding(paddingValues)
        ) {
            items(items = products) { item ->
                CartItemView(
                    item = item,
                    onAdd = onItemAdd,
                    onRemove = onItemRemove,
                    onDelete = onDelete
                )
            }
        }
    }
}

@Preview
@Composable
private fun ShoppingCartScreenPreview() {
    ShoppingCartTheme {
        ShoppingCardScreen(
            onBackClick = {},
            totalPrice = 10000,
            products = listOf(CartItem(Product("", "Product", 10000), 1)),
            onItemAdd = {},
            onItemRemove = {},
            onDelete = {}
        )
    }
}