package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.ui.theme.Typography

@Composable
fun CountControlButton(
    count: Int,
    countUpdate: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        val iconSize = 42.dp
        val iconPadding = 11.dp
        Icon(
            modifier = Modifier
                .size(iconSize)
                .clickable {
                    countUpdate(count.dec().coerceAtLeast(0))
                }
                .padding(iconPadding),
            painter = painterResource(R.drawable.ic_remove),
            contentDescription = stringResource(R.string.remove),
        )

        Text(
            modifier = Modifier.width(iconSize),
            text = count.toString(),
            style = Typography.bodyLarge,
            textAlign = TextAlign.Center,
        )

        Icon(
            modifier = Modifier
                .size(iconSize)
                .clickable {
                    countUpdate(count.inc())
                }
                .padding(iconPadding),
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(R.string.add),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CountControlButtonPreview() {
    ShoppingCartTheme {
        var count by remember { mutableIntStateOf(1) }
        CountControlButton(
            count = count,
            countUpdate = { count = it }
        )
    }
}