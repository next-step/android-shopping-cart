package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ProductCounter(
    count: Int,
    onMinusClick: () -> Unit,
    onPlusClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End,
    ) {
        if (count > 0) {
            QuantitySelector(
                count = count,
                onMinusClick = onMinusClick,
                onPlusClick = onPlusClick
            )
        } else {
            AddToCartIcon(onPlusClick = onPlusClick)
        }
    }
}

@Preview
@Composable
private fun ProductCounterPreview() {
    ProductCounter(
        count = 0,
        onMinusClick = {},
        onPlusClick = {},
        modifier = Modifier
            .clip(CircleShape)
            .background(color = Color.White)
    )
}