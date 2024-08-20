package nextstep.shoppingcart.ui.shoppingcart.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R.string.shopping_cart_item_sum
import nextstep.shoppingcart.R.string.shopping_item_price_format
import nextstep.shoppingcart.ui.theme.RobotoRegular

@Composable
fun ShoppingCartItemSumText(
    sum: Long,
    modifier: Modifier = Modifier,
) {
    val shoppingCartItemSum = stringResource(id = shopping_cart_item_sum)

    Text(
        text = stringResource(id = shopping_item_price_format, sum),
        fontSize = 16.sp,
        fontFamily = RobotoRegular,
        modifier = modifier.semantics { contentDescription = shoppingCartItemSum },
    )
}

@Preview
@Composable
private fun ShoppingCartItemSumTextPreview() {
    ShoppingCartItemSumText(sum = 500000)
}
