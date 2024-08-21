package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.utils.ThemePreviews


@Composable
fun ShoppingCartItemCounter(
    count: Int,
    onMinusClick: () -> Unit,
    onPlusClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(14.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CounterTextButton(modifier = Modifier.testTag("장바구니 수량 감소 버튼"), onClick = onMinusClick, text = "-")
        Text(modifier = Modifier.testTag("장바구니 담긴 수량"), text = count.toString(), style = MaterialTheme.typography.titleLarge)
        CounterTextButton(modifier = Modifier.testTag("장바구니 수량 증가 버튼"), onClick = onPlusClick, text = "+")
    }
}

@Composable
private fun CounterTextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .size(42.dp)
            .clickable { onClick() }, contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleLarge,
        )
    }
}

@ThemePreviews
@Composable
private fun ShoppingCartItemCounterPreview() {
    ShoppingCartTheme {
        ShoppingCartItemCounter(
            count = 200,
            onMinusClick = {},
            onPlusClick = {}
        )
    }
}
