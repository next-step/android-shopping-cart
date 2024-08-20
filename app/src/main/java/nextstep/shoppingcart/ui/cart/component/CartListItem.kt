package nextstep.shoppingcart.ui.cart.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.common.component.Image
import nextstep.shoppingcart.ui.theme.Black10
import nextstep.shoppingcart.ui.theme.Gray10

const val CART_LIST_ITEM_CLOSE_TEST_TAG = "cartListItemClose"

@Composable
fun CartListItem(
    modifier: Modifier = Modifier,
    item: CartItem,
    onClickIncrease: () -> Unit,
    onClickDecrease: () -> Unit,
    onClickCancel: () -> Unit,
) {
    Card(
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(1.dp, Gray10),
        modifier = modifier,
    ) {
        Column(modifier = Modifier.background(Color.White)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = item.product.name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(start = 18.dp)
                        .weight(1f),
                )

                IconButton(
                    onClick = onClickCancel,
                    modifier = Modifier.testTag(CART_LIST_ITEM_CLOSE_TEST_TAG),
                ) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "close",
                        tint = Black10,
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 18.dp)
                    .padding(bottom = 18.dp)
                    .height(84.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(url = item.product.imageUrl, modifier = Modifier.width(136.dp))

                Column(modifier = Modifier) {
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = stringResource(id = R.string.price_format, item.product.price),
                        fontSize = 16.sp,
                        color = Color.Black,
                        modifier = Modifier.align(Alignment.End),
                    )
                    CartItemCounter(
                        count = item.count,
                        onClickIncrease = onClickIncrease,
                        onClickDecrease = onClickDecrease,
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun CartListItemPreview() {
    val product = Product(
        name = "iPhone 15 Pro Max / iPhone 16 Pro Max / iPhone 17 Pro Max",
        imageUrl = "https://img.danawa.com/prod_img/500000/334/189/img/28189334_1.jpg",
        price = 1_900_000,
    )
    val cartItem = CartItem(product, 2)
    CartListItem(item = cartItem, onClickIncrease = { }, onClickDecrease = { }, onClickCancel = { })
}
