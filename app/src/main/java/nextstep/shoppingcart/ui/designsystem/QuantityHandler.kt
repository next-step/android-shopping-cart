package nextstep.shoppingcart.ui.designsystem

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun QuantityHandler(
    quantity: Int,
    onIncreaseQuantityClick: () -> Unit,
    onDecreaseQuantityClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(
            onClick = onIncreaseQuantityClick,
        ) {
            Image(
                painter = painterResource(R.drawable.baseline_remove_24),
                contentDescription = stringResource(R.string.quantity_handler_decrease),
            )
        }
        Text(
            text = quantity.toString(),
        )
        IconButton(
            onClick = onDecreaseQuantityClick,
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = stringResource(R.string.quantity_handler_increase),
            )
        }
    }
}

@Preview
@Composable
private fun QuantityHandlerPreview() {
    ShoppingCartTheme {
        QuantityHandler(
            quantity = 0,
            onIncreaseQuantityClick = { },
            onDecreaseQuantityClick = { },
        )
    }
}
