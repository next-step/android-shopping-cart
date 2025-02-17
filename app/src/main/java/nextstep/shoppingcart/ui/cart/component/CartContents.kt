package nextstep.shoppingcart.ui.cart.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.designsystem.component.ProductImage
import nextstep.shoppingcart.designsystem.theme.ShoppingCartTheme
import nextstep.shoppingcart.ext.getFormattedPrice
import nextstep.shoppingcart.model.Cart
import nextstep.shoppingcart.model.Product


@Composable
fun CartContents(
    item: Cart,
    modifier: Modifier = Modifier,
    onAdd: (Cart) -> Unit = {},
    onRemove: (Cart) -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        ProductImage(
            item = item.product,
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f, fill = false),
            contentScale = ContentScale.Fit
        )
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.BottomEnd
            ) {
                Text(
                    text = stringResource(R.string.price, item.totalPrice.getFormattedPrice()),
                    fontSize = 16.sp,
                    color = Color.Black,
                )
            }
            CartAmount(
                item = item,
                modifier = modifier.weight(1f),
                onAdd = onAdd,
                onRemove = onRemove
            )
        }
    }
}


@Preview(heightDp = 150)
@Composable
private fun CartContentsPreview() {
    val cart = Cart(
        Product(1, "상품1상품1상품1상품1상품1상품1상품1상품1상품1상품1상품1", 1000, ""),
        4
    )
    ShoppingCartTheme {
        CartContents(cart)
    }

}