package nextstep.shoppingcart.cart.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.ProductsTestData
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun CartContent(cartItem: List<CartItem>, modifier: Modifier = Modifier) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp), modifier = modifier) {
        items(cartItem) {
            CartProduct(
                cartItem = it,
                onAddOneToCart = {},
                onRemoveOneFromCart = {},
                onClearCartItem = {},
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 18.dp)
                    .aspectRatio(324f / 150f)
                    .border(
                        shape = RoundedCornerShape(4.dp),
                        width = 1.dp,
                        color = Color.Gray.copy(alpha = 0.1f)
                    )
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun CartContentPreview() {
    ShoppingCartTheme {
        CartContent(cartItem = ProductsTestData.productTestDataList.map { CartItem(it, 1) })
    }
}
