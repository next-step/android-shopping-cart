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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun CartProduct(
    cartItem: CartItem,
    onAddOneToCart: () -> Unit,
    onRemoveOneFromCart: () -> Unit,
    onClearCartItem: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Spacer(modifier = Modifier.size(18.dp))
        CartProductTitle(
            name = cartItem.product.name,
            onRemoveCart = { onClearCartItem() },
            modifier = Modifier.padding(horizontal = 18.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 6.dp)
        ) {
            AsyncImage(
                model = cartItem.product.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(136f / 84f)
                    .padding(start = 18.dp, bottom = 18.dp, top = 6.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text(
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(end = 18.dp)
                        .weight(1f, fill = true),
                    text = cartItem.product.formattedPrice,
                    fontSize = 16.sp
                )
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
                                onRemoveOneFromCart()
                            }, contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "-",
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
                                onAddOneToCart()
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
            modifier = Modifier.border(
                width = 1.dp,
                color = Color.Gray.copy(alpha = 0.1f)
            ), onClearCartItem = {}
        )
    }
}
