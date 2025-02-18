package nextstep.shoppingcart.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.ui.theme.Typography

@Composable
internal fun ItemCounter(
    count: Int,
    onRemoveOneClick: () -> Unit,
    onAddOneClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = onRemoveOneClick,
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f)
        ) {
            Text(
                text = stringResource(R.string.cart_item_counter_minus),
                style = Typography.titleLarge.copy(fontWeight = FontWeight.W700),
            )
        }
        Text(
            text = count.toString(),
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f)
                .wrapContentSize(),
            style = Typography.titleLarge,
        )
        IconButton(
            onClick = onAddOneClick,
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f)
        ) {
            Text(
                text = stringResource(R.string.cart_item_counter_plus),
                style = Typography.titleLarge.copy(fontWeight = FontWeight.W700),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ItemCounterPreview() {
    ShoppingCartTheme {
        var count by remember { mutableIntStateOf(1) }
        ItemCounter(
            count = count,
            onRemoveOneClick = { count-- },
            onAddOneClick = { count++ },
        )
    }
}
