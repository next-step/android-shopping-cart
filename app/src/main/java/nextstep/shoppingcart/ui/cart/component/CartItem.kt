package nextstep.shoppingcart.ui.cart.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.designsystem.theme.Gray10
import nextstep.shoppingcart.designsystem.theme.ShoppingCartTheme
import nextstep.shoppingcart.model.Cart
import nextstep.shoppingcart.model.Product

@Composable
fun CartItem(
    item: Cart,
    modifier: Modifier = Modifier,
    onDelete: (Cart) -> Unit = {},
    onAdd: (Cart) -> Unit = {},
    onRemove: (Cart) -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
            .border(1.dp, Gray10, RoundedCornerShape(4.dp))
            .padding(18.dp)
    ) {
        CartTitle(item = item, onDelete = onDelete)
        CartContents(item = item, onAdd = onAdd, onRemove = onRemove)
    }
}


@Preview
@Composable
private fun CartItemPreview() {

    val cart = Cart(
        Product(1, "상품1상품1상품1상품1상품1상품1상품1상품1상품1상품1상품1", 1000, ""),
        4
    )

    ShoppingCartTheme {
        CartItem(cart)
    }

}