package nextstep.shoppingcart.ui.cart.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.designsystem.theme.ShoppingCartTheme
import nextstep.shoppingcart.ext.setContentDescription
import nextstep.shoppingcart.model.Cart
import nextstep.shoppingcart.model.Product

@Composable
fun CartAmount(
    item: Cart,
    modifier: Modifier = Modifier,
    onAdd: (Cart) -> Unit = {},
    onRemove: (Cart) -> Unit = {}
) {
    Row(
        modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        IconButton(onClick = { onRemove(item) }) {
            Icon(
                painterResource(R.drawable.ic_remove),
                contentDescription = "${item.product.id}_remove_icon"
            )
        }
        Text(
            text = item.count.toString(),
            modifier = Modifier
                .weight(1f, fill = false)
                .setContentDescription("${item.product.id}_cart_count"),
            textAlign = TextAlign.Center,
            fontSize = 22.sp,
            color = Color.Black,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        IconButton(onClick = { onAdd(item) }) {
            Icon(
                Icons.Default.Add,
                contentDescription = "${item.product.id}_add_icon"
            )
        }
    }
}

@Preview
@Composable
private fun CartAmountPreview() {
    val cart = Cart(
        Product(1, "상품1상품1상품1상품1상품1상품1상품1상품1상품1상품1상품1", 1000, ""),
        4
    )
    ShoppingCartTheme {
        CartAmount(cart)
    }
}