package nextstep.shoppingcart.ui.shopping.cart

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.dummyProducts
import nextstep.shoppingcart.ui.shopping.component.QuantitySelector
import nextstep.shoppingcart.ui.theme.Gray10


@Composable
fun CartItemCard(
    cartItem: CartItem,
    onClickAddItem: () -> Unit,
    onClickRemoveItem: () -> Unit,
    onClickRemoveAll: () -> Unit,
    modifier: Modifier = Modifier
) {
    val product = cartItem.product

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.Black
        ),
        border = BorderStroke(1.dp, Gray10)
    ) {
        Column(
            modifier = Modifier.padding(18.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = product.name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 24.sp
                )
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = stringResource(id = R.string.cart_item_remove_btn_description),
                    modifier = Modifier.clickable {
                        onClickRemoveAll.invoke()
                    }
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 6.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = product.imageUrl,
                    contentDescription = "",
                    modifier = Modifier
                        .width(136.dp)
                        .height(84.dp),
                    placeholder = painterResource(id = R.drawable.ic_launcher_background)
                )
                Column(
                    modifier.padding(top = 18.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.item_price_format, cartItem.totalPrice),
                        modifier = Modifier.align(Alignment.End),
                        style = MaterialTheme.typography.bodyLarge
                    )
                    QuantitySelector(
                        count = cartItem.count,
                        onClickRemoveCount = { onClickRemoveItem() },
                        onClickAddCount = { onClickAddItem() },
                        modifier = Modifier.height(42.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CartItemCardPrev(
    @PreviewParameter(CartItemPrevParamProvider::class) dummyCartItem: CartItem
) {
    Box(modifier = Modifier.padding(10.dp)) {
        CartItemCard(dummyCartItem, {}, {}, {})
    }
}

class CartItemPrevParamProvider : CollectionPreviewParameterProvider<CartItem>(
    listOf(
        CartItem(dummyProducts[0], 1),
        CartItem(dummyProducts[1], 2),
        CartItem(dummyProducts[2], 3)
    )
)
