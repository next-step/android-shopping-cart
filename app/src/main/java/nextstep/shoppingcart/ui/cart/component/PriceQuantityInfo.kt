package nextstep.shoppingcart.ui.cart.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.data.cart.CartItem

@Composable
fun PriceQuantityInfo(
    modifier: Modifier = Modifier,
    cartItem: CartItem,
    onClickMinus: () -> Unit,
    onClickPlus: () -> Unit
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.End,
    ) {
        Spacer(modifier = modifier)

        Text(
            modifier = Modifier.padding(8.dp),
            text = stringResource(id = R.string.formatted_price, cartItem.product.price),
            textAlign = TextAlign.Center,
            fontSize = 22.sp,
        )
        InteractiveQuantity(
            cartItem = cartItem,
            onClickMinus = onClickMinus,
            onClickPlus = onClickPlus
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PriceQuantityInfoPreview() {
    PriceQuantityInfo(Modifier, CartItem(Product(1, "name", "1000", 10000), 3), {}, {})
}