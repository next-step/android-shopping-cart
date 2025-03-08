package nextstep.shoppingcart.detail.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductTitleText(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        modifier = modifier,
        style = TextStyle(
            fontWeight = FontWeight.W700,
            fontSize = 24.sp,
            lineHeight = 28.sp,
            letterSpacing = 0.5.sp
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductTitleTextPreview() {
    ShoppingCartTheme {
        ProductTitleText(
            title = "테스트테스트",
        )
    }
}
