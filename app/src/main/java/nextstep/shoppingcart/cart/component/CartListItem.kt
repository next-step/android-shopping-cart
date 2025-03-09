package nextstep.shoppingcart.cart.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.cart.model.CartItem
import nextstep.shoppingcart.common.component.ProductImage
import nextstep.shoppingcart.common.component.Stepper
import nextstep.shoppingcart.list.model.Product
import nextstep.shoppingcart.ui.theme.Gray10
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun CartListItem(
    cartItem: CartItem,
    onClickRemove: () -> Unit,
    onChangeCount: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(4.dp))
            .background(color = Color.White)
            .border(
                width = 1.dp,
                color = Gray10,
                shape = RoundedCornerShape(4.dp)
            )
            .padding(18.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CartItemTitleText(
                modifier = Modifier.weight(1f),
                title = cartItem.product.name
            )
            IconButton(
                modifier = Modifier.size(24.dp),
                onClick = onClickRemove,
            ) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = stringResource(R.string.remove)
                )
            }
        }
        Spacer(modifier = Modifier.height(6.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ProductImage(
                modifier = Modifier.size(width = 136.dp, height = 84.dp),
                imageUrl = cartItem.product.imageUrl,
                contentDescription = cartItem.product.name,
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.align(Alignment.Bottom),
                horizontalAlignment = Alignment.End
            ) {
                CartPriceText(
                    price = cartItem.product.price
                )
                Stepper(
                    count = cartItem.count,
                    onChangeCount = onChangeCount,
                    minimum = 0,
                    maximum = 999,
                )
            }
        }
    }
}

@Preview
@Composable
private fun CartListItemPreview() {
    ShoppingCartTheme {
        CartListItem(
            cartItem = CartItem(
                product = Product(
                    id = 1,
                    imageUrl = "https://picsum.photos/id/2/300/300",
                    name = "PET보틀-밀크티 어쩌구",
                    price = 12000
                ),
                count = 1
            ),
            onClickRemove = {},
            onChangeCount = {},
        )
    }
}
