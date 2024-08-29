package nextstep.shoppingcart.ui.cart.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.data.cart.CartItem

@Composable
fun CartCard(
    cartItem: CartItem,
    modifier: Modifier = Modifier,
    onMinusClick: (Product) -> Unit,
    onPlusClick: (Product) -> Unit,
    onRemoveClick: (CartItem) -> Unit
) {
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        CartCardTopBar(
            modifier = modifier.testTag(stringResource(id = R.string.test_tag_cart_card)),
            product = cartItem.product,
            onClickCloseIcon = { onRemoveClick(cartItem) }
        )
        Row(
            modifier = modifier
                .fillMaxWidth()
        ) {
            AsyncImage(
                modifier = modifier.weight(1f),
                model = cartItem.product.imgUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                placeholder = ColorPainter(Color.Black)
            )

            PriceQuantityInfo(
                modifier = Modifier.weight(1f),
                cartItem = cartItem,
                onClickMinus = { onMinusClick(cartItem.product) },
                onClickPlus = { onPlusClick(cartItem.product) }
            )
        }
    }
}

@Preview(
    showBackground = true,
    heightDp = 200
)
@Composable
private fun CartCardPreview() {
    CartCard(
        cartItem = CartItem(
            product = Product(
                id = 1,
                imgUrl = "https://picsum.photos/seed/1/200",
                name = "상품 1-이름이 너무 길다면 어떻게 할 것인가요?",
                price = 3000
            ),
            count = 1
        ),
        modifier = Modifier,
        onMinusClick = {},
        onPlusClick = {},
        onRemoveClick = {}
    )
}

