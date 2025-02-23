package nextstep.shoppingcart.catalog.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.ui.theme.TypoTokens.Normal22

@Composable
fun ProductCountAdjustButton(
    count: Int,
    onClickIncreaseCountButton: () -> Unit,
    onClickDecreaseCountButton: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.background(color = Color.White, shape = RoundedCornerShape(4.dp))
    ) {
        IconButton(onClick = onClickDecreaseCountButton,) {
            Icon(
                Icons.Filled.Delete,
                contentDescription = Icons.Filled.Delete.name,
            )
        }
        Text(
            text = count.toString(),
            style = Normal22,
        )
        IconButton(onClick = onClickIncreaseCountButton) {
            Icon(
                Icons.Filled.Add,
                contentDescription = Icons.Filled.Add.name,
            )
        }
    }
}

@Preview
@Composable
private fun ProductCountAdjustButtonPreview() {
    ShoppingCartTheme {
        ProductCountAdjustButton(
            count = 0,
            onClickIncreaseCountButton = {},
            onClickDecreaseCountButton = {},
        )
    }
}