package nextstep.shoppingcart.catalog.component

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductAddCartButton(
    onClickButton: () -> Unit,
    modifier: Modifier = Modifier,
) {
    IconButton(
        onClick = onClickButton,
        modifier = modifier.background(color = Color.White, shape = CircleShape),
    ) {
        Icon(
            Icons.Filled.Add,
            contentDescription = Icons.Filled.Add.name,
        )
    }
}

@Preview
@Composable
private fun ProductAddCartButtonPreview() {
    ShoppingCartTheme {
        ProductAddCartButton({})
    }
}