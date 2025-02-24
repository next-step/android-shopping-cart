package nextstep.shoppingcart.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun CounterButton(
    quantity: Int,
    onPlusClick: () -> Unit,
    onMinusClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.background(color = Color.White, shape = RoundedCornerShape(4.dp))
    ) {
        Box(
            modifier = Modifier
                .size(42.dp)
                .clickable(onClick = onMinusClick)
                .testTag(stringResource(R.string.minus))
            ,
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.minus),
                style = MaterialTheme.typography.titleLarge
            )
        }

        Box(
            modifier = Modifier
                .size(42.dp)
                .testTag(stringResource(R.string.product_count)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = quantity.toString(),
                style = MaterialTheme.typography.titleLarge
            )
        }

        Box(
            modifier = Modifier
                .size(42.dp)
                .clickable(onClick = onPlusClick)
                .testTag(stringResource(R.string.plus)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.plus),
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}

@Preview
@Composable
private fun CounterButtonPreview() {
    ShoppingCartTheme {
        CounterButton(
            quantity = 1,
            onPlusClick = {},
            onMinusClick = {}
        )
    }
}