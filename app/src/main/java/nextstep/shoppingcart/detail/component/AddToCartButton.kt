package nextstep.shoppingcart.detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.ui.theme.Blue50
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun AddToCartButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TextButton(
        onClick = onClick,
        contentPadding = PaddingValues(vertical = 15.dp),
        modifier = modifier
            .fillMaxWidth()
            .background(color = Blue50)
    ) {
        Text(
            text = label,
            style = TextStyle(
                fontWeight = FontWeight.W700,
                fontSize = 20.sp
            ),
            color = Color.White
        )
    }
}

@Preview
@Composable
private fun AddToCartButtonPreview() {
    ShoppingCartTheme {
        AddToCartButton(
            label = "장바구니 담기",
            onClick = {}
        )
    }
}
