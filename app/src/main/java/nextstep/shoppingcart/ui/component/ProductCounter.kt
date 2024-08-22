package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R

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
        IconButton(
            onClick = onMinusClick,
            modifier = Modifier.size(42.dp)
        ) {
            Text(
                text = stringResource(id = R.string.minus),
                style = MaterialTheme.typography.titleLarge
            )
        }
        Text(
            text = count.toString(),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(horizontal = 14.dp)
        )
        IconButton(
            onClick = onPlusClick,
            modifier = Modifier.size(42.dp)
        ) {
            Text(
                text = stringResource(id = R.string.plus),
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}

@Preview
@Composable
private fun ProductCounterPreview() {
    ProductCounter(
        count = 1,
        onMinusClick = {},
        onPlusClick = {},
        modifier = Modifier.background(color = Color.White)
    )
}