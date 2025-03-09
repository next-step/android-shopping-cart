package nextstep.shoppingcart.cart.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun CartItemTitleText(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = title,
        style = TextStyle(
            fontWeight = FontWeight.W700,
            fontSize = 20.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.5.sp
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun CartItemTitlePreview() {
    ShoppingCartTheme {
        CartItemTitleText(
            title = "PET보틀-밀크티 어쩌구"
        )
    }
}
