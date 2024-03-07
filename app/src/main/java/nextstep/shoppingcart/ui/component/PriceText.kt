package nextstep.shoppingcart.ui.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.TextUnit
import nextstep.shoppingcart.R

@Composable
fun PriceText(
    modifier: Modifier = Modifier,
    price: Int,
    fontSize: TextUnit
) {
    Text(
        modifier = modifier,
        text = stringResource(id = R.string.price_format, price),
        fontSize = fontSize
    )
}
