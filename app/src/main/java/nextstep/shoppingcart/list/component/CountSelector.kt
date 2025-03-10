package nextstep.shoppingcart.list.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.common.component.Stepper
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun CountSelector(
    count: Int,
    onChangeCount: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.CenterEnd
    ) {
        if (count == 0) {
            AddButton(
                onClick = { onChangeCount(1) },
                modifier = Modifier.size(42.dp)
            )
        } else {
            Stepper(
                count = count,
                onChangeCount = onChangeCount,
                minimum = 0,
                maximum = 999,
            )
        }
    }
}

@Composable
private fun AddButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(color = Color.White)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(R.string.add)
        )
    }
}


@Preview
@Composable
private fun QuantitySelectorPreview() {
    ShoppingCartTheme {
        val count = remember { mutableIntStateOf(0) }
        CountSelector(
            count = count.intValue,
            onChangeCount = { count.intValue = it }
        )
    }
}
