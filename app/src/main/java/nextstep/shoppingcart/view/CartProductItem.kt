package nextstep.shoppingcart.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.utils.formatPrice

@Composable
fun CartProductItem(
    cartItem: CartItem,
    onClickRemoveAll: () -> Unit,
    onClickAddOne: () -> Unit,
    onClickRemoveOne: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = modifier.fillMaxWidth(),
        colors = CardColors(
            containerColor = Color.White,
            contentColor = Color.Black,
            disabledContainerColor = Color.White,
            disabledContentColor = Color.Black
        ),
        border = BorderStroke(1.dp, Color.Gray)
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CartProductName(
                    name = cartItem.product.name,
                    modifier = Modifier.weight(1f)
                )
                IconButton(
                    onClick = onClickRemoveAll,
                    modifier = Modifier.size(24.dp).testTag("remove")
                ) {
                    Icon(Icons.Filled.Close, null)
                }
            }

            Spacer(modifier = Modifier.size(6.dp))

            Box(modifier = Modifier.fillMaxWidth()) {
                CartProductImage(
                    imageUrl = cartItem.product.imageUrl,
                    modifier = Modifier.align(Alignment.TopStart)
                )
                CartProductPrice(
                    price = cartItem.product.price * cartItem.count,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = 18.dp)
                )
                ProductCount(
                    count = cartItem.count,
                    onClickAddOne = onClickAddOne,
                    onClickRemoveOne = onClickRemoveOne,
                    modifier = Modifier.align(Alignment.BottomEnd)
                )
            }
        }
    }
}

@Composable
private fun CartProductName(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = modifier
    )
}

@Composable
private fun CartProductImage(imageUrl: String, modifier: Modifier = Modifier) {
    AsyncImage(
        model = imageUrl,
        contentDescription = "product image",
        contentScale = ContentScale.Crop,
        modifier = modifier.size(width = 136.dp, height = 84.dp)
    )
}

@Composable
private fun CartProductPrice(price: Int, modifier: Modifier = Modifier) {
    Text(
        text = price.formatPrice(),
        fontSize = 16.sp,
        modifier = modifier.testTag("price")
    )
}

@Preview(showBackground = true)
@Composable
private fun CartProductItemPreview() {
    CartProductItem(
        cartItem = CartItem(
            product = nextstep.shoppingcart.model.Product.mock,
            count = 2
        ),
        onClickRemoveAll = { },
        onClickAddOne = { },
        onClickRemoveOne = { }
    )
}