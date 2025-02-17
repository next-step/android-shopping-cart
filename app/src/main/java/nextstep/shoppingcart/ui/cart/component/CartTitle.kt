package nextstep.shoppingcart.ui.cart.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.designsystem.theme.ShoppingCartTheme
import nextstep.shoppingcart.model.Cart
import nextstep.shoppingcart.model.Product


@Composable
fun CartTitle(
    item: Cart,
    onDelete: (Cart) -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = item.product.name,
            modifier = Modifier
                .weight(1f, fill = false),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
        )
        IconButton(
            onClick = { onDelete(item) },
            modifier = Modifier.size(24.dp)
        ) {
            Icon(Icons.Default.Close, contentDescription = "${item.product.id}_delete_icon")
        }
    }
}


@Preview
@Composable
private fun CartTitlePreview() {
    val cart = Cart(
        Product(1, "상품1상품1상품1상품1상품1상품1상품1상품1상품1상품1상품1", 1000, ""),
        4
    )
    ShoppingCartTheme {
        CartTitle(cart)
    }

}