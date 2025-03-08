package nextstep.shoppingcart.cart

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.component.ProductImage
import nextstep.shoppingcart.component.ProductName
import nextstep.shoppingcart.component.ProductPrice
import nextstep.shoppingcart.component.QuantityController
import nextstep.shoppingcart.data.CartItem
import nextstep.shoppingcart.data.DummyProduct
import nextstep.shoppingcart.ui.theme.Gray40

@Composable
fun CartProduct(
    cartItem: CartItem,
    onDeleteButtonClick: (CartItem) -> Unit,
    onMinusButtonClick: (CartItem) -> Unit,
    onPlusButtonClick: (CartItem) -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(324 / 150f),
        shape = RoundedCornerShape(8.dp),
        color = Color.White,
        border = BorderStroke(width = 1.dp, color = Gray40),
    ) {
        Column(
            modifier = Modifier
                .padding(18.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                ProductName(
                    name = cartItem.product.name,
                    modifier = Modifier.weight(1f),
                    fontSize = 20.sp
                )
                IconButton(
                    onClick = { onDeleteButtonClick(cartItem) },
                    modifier = Modifier
                        .size(24.dp)
                        .testTag("delete_button"),
                ) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Close",
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                ProductImage(
                    imageUrl = cartItem.product.imageUrl,
                    ratio = 136 / 84f,
                    modifier = Modifier
                        .weight(1f)
                        .width(136.dp)
                )
                Spacer(modifier = Modifier.width(26.dp))
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.Bottom)
                ) {
                    ProductPrice(
                        price = (cartItem.product.price * cartItem.count),
                        modifier = Modifier
                            .align(Alignment.End),
                        fontSize = 16.sp,
                    )
                    QuantityController(
                        count = cartItem.count,
                        onMinusClick = { onMinusButtonClick(cartItem) },
                        onPlusClick = { onPlusButtonClick(cartItem) },
                        modifier = Modifier
                            .align(Alignment.End)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CartProductPreview() {
    val cartItem = CartItem(
        product = DummyProduct.product1,
        count = 1
    )

    CartProduct(
        cartItem = cartItem,
        onDeleteButtonClick = {},
        onMinusButtonClick = {},
        onPlusButtonClick = {},
    )
}