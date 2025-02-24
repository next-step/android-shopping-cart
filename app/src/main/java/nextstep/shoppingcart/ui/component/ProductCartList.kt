package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.data.model.CartItem
import nextstep.shoppingcart.data.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
internal fun ProductCartList(
    cartItems: List<CartItem>,
    onRemoveClick: (Product) -> Unit,
    onIncreaseClick: (Product) -> Unit,
    onDecreaseClick: (Product) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(
            vertical = 16.dp,
            horizontal = 18.dp
        ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(
            items = cartItems,
            key = { it.productId },
        ) {
            ProductCartItem(
                cartItem = it,
                onRemoveClick = onRemoveClick,
                onIncreaseClick = onIncreaseClick,
                onDecreaseClick = onDecreaseClick,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductCartListPreview() {
    val items = listOf(
        CartItem(
            Product(
                id = 1,
                imageUrl = "https://www.themealdb.com/images/media/meals/g046bb1663960946.jpg",
                name = "날치알이 생각보다 많은 초밥",
                price = 20000,
            ),
            2
        ),
        CartItem(
            Product(
                id = 2,
                imageUrl = "https://www.themealdb.com/images/media/meals/d8f6qx1604182128.jpg",
                name = "기본 카츠동",
                price = 11000,
            ),
            4
        )
    )
    ShoppingCartTheme {
        ProductCartList(
            modifier = Modifier.fillMaxSize(),
            cartItems = items,
            onRemoveClick = {},
            onIncreaseClick = {},
            onDecreaseClick = {}
        )
    }
}
