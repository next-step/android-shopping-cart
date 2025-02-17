package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.model.CartItem
import nextstep.shoppingcart.data.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
internal fun ProductCartContent(
    cartItems: List<CartItem>,
    totalPrice: Int,
    onRemoveClick: (Product) -> Unit,
    onIncreaseClick: (Product) -> Unit,
    onDecreaseClick: (Product) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f),
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
        TextButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            onClick = { },
            enabled = totalPrice > 0,
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2196F3),
                contentColor = Color.White
            )
        ) {
            Text(
                text = stringResource(R.string.cart_total_price_format, totalPrice),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    lineHeight = 23.44.sp,
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductCartContentPreview() {
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
        ProductCartContent(
            cartItems = items,
            totalPrice = items.sumOf { it.totalPrice },
            onRemoveClick = {},
            onIncreaseClick = {},
            onDecreaseClick = {}
        )
    }
}
