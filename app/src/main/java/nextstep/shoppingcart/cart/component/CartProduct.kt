package nextstep.shoppingcart.cart.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.component.ProductImage
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.util.translateNumberMoneyFormat

@Composable
fun CartProduct(
    cartItem: CartItem,
    onAddOneToCart: (Product) -> Unit,
    onRemoveOneFromCart: (Product) -> Unit,
    onClearCartItem: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Spacer(modifier = Modifier.size(18.dp))
        CartProductTopArea(
            name = cartItem.product.name,
            onRemoveCart = { onClearCartItem(cartItem.product) },
            rightIcon = Icons.Filled.Clear,
            rightIconContentDescription = "${cartItem.product.name} 삭제버튼",
            modifier = Modifier.padding(horizontal = 18.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 6.dp, start = 18.dp, end = 18.dp, bottom = 18.dp)
        ) {
            ProductImage(
                imageUrl = cartItem.product.imageUrl,
                contentDescription = "${cartItem.product.name} 이미지",
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(136f / 84f)
            )
            CartProductPrice(cartItem, onRemoveOneFromCart, onAddOneToCart)
        }
    }
}

@Composable
private fun CartProductPrice(
    cartItem: CartItem,
    onRemoveOneFromCart: (Product) -> Unit,
    onAddOneToCart: (Product) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .weight(1f, fill = true)
                .align(Alignment.End),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text(
                text = translateNumberMoneyFormat(cartItem.totalPrice),
                fontSize = 16.sp,
            )
        }

        Row(
            modifier = Modifier
                .width(126.dp)
                .align(Alignment.End)
                .weight(1f, fill = true),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .clickable {
                        onRemoveOneFromCart(cartItem.product)
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "−",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Text(
                text = cartItem.count.toString(),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .clickable {
                        onAddOneToCart(cartItem.product)
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "+",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CartProductPreview() {
    ShoppingCartTheme {
        CartProduct(
            cartItem = CartItem(
                product = Product(
                    name = "[든든] 동원 스위트콘",
                    imageUrl = "https://duckduckgo.com/?q=cursus",
                    price = 2563,
                    productId = "homero"
                ), count = 3173
            ),
            {},
            {},
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 18.dp)
                .aspectRatio(324f / 150f)
                .border(
                    shape = RoundedCornerShape(4.dp),
                    width = 1.dp,
                    color = Color.Gray.copy(alpha = 0.1f)
                ), onClearCartItem = {}
        )
    }
}
