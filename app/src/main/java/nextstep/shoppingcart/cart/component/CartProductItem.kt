package nextstep.shoppingcart.cart.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.TypoTokens.Bold20
import nextstep.shoppingcart.ui.theme.TypoTokens.Normal16
import nextstep.shoppingcart.util.ImageUtil.getUrlIfNotPreview
import nextstep.shoppingcart.util.NumberFormatUtil.toPrice

@Composable
fun CartProductItem(
    cartItem: CartItem,
    onClickDeleteItemButton: () -> Unit,
    onClickIncreaseCountButton: () -> Unit,
    onClickDecreaseCountButton: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(5.dp))
            .border(1.dp, color = Color.Gray)
            .padding(18.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                cartItem.product.name,
                style = Bold20,
                modifier = Modifier.weight(1f)
            )
            IconButton(
                onClick = onClickDeleteItemButton,
                modifier = Modifier.size(24.dp)
            ) {
                Icon(
                    Icons.Filled.Close,
                    contentDescription = Icons.Filled.Close.name,
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 6.dp)
        ) {
            AsyncImage(
                model = getUrlIfNotPreview(cartItem.product.imageUrl),
                contentDescription = "${cartItem.product.name} image",
                contentScale = ContentScale.Crop,
                placeholder = painterResource(R.drawable.woori),
                modifier = Modifier.size(width = 136.dp, height = 84.dp),
            )
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    cartItem.totalPrice.toPrice(),
                    style = Normal16,
                )
                Row(
                    modifier = Modifier
                        .padding(top = 6.dp)
                        .width(126.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    IconButton(
                        onClick = onClickDecreaseCountButton,
                        modifier = Modifier.size(24.dp)
                    ) {
                        Icon(
                            Icons.Filled.Delete,
                            contentDescription = Icons.Filled.Delete.name,
                        )
                    }
                    Text(
                        cartItem.product.price.toPrice(),
                        style = Normal16,
                    )
                    IconButton(
                        onClick = onClickIncreaseCountButton,
                        modifier = Modifier.size(24.dp)
                    ) {
                        Icon(
                            Icons.Filled.Add,
                            contentDescription = Icons.Filled.Add.name,
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CartProductItemPreview() {
    CartProductItem(
        cartItem = CartItem(
            product = Product(
                id = 1,
                name = "상품",
                price = 5000000,
                imageUrl = "https://picsum.photos/id/30/1280/901",
            ),
            count = 1,
        ),
        onClickDeleteItemButton = {},
        onClickIncreaseCountButton = {},
        onClickDecreaseCountButton = {},
    )
}
