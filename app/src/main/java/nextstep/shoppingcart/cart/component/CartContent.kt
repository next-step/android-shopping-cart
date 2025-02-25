package nextstep.shoppingcart.cart.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.ProductsTestData
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.component.ProductBottomButton
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.util.translateNumberMoneyFormat

@Composable
fun CartContent(
    cartItem: List<CartItem>,
    onAddOneToCart: (Product) -> Unit,
    onRemoveOneFromCart: (Product) -> Unit,
    onClearCartItem: (Product) -> Unit,
    onOrderButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
    totalPrice: Int
) {
    Box(modifier) {
        LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            items(cartItem, key = { it.product.productId }) { cartItem ->
                CartProduct(
                    cartItem = cartItem,
                    onAddOneToCart = { product -> onAddOneToCart(product) },
                    onRemoveOneFromCart = { product -> onRemoveOneFromCart(product) },
                    onClearCartItem = { product -> onClearCartItem(product) },
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
        ProductBottomButton(
            buttonText = "주문하기(${translateNumberMoneyFormat(totalPrice)})",
            onClick = { onOrderButtonClick() },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF2196F3))
                .aspectRatio(360f / 54f)
                .align(alignment = Alignment.BottomCenter)
        )
    }

}

@Preview(showSystemUi = true)
@Composable
private fun CartContentPreview() {
    ShoppingCartTheme {
        CartContent(
            cartItem = ProductsTestData.productTestDataList.map { CartItem(it, 1) },
            onAddOneToCart = {},
            onRemoveOneFromCart = {},
            onClearCartItem = {},
            totalPrice = 10, onOrderButtonClick = {},
        )
    }
}
