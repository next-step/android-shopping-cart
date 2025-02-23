package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductInfoTowText(
    leftText: String,
    rightText: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = leftText,
            textAlign = TextAlign.Start,
            fontSize = 20.sp,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = rightText,
            textAlign = TextAlign.End,
            fontSize = 20.sp,
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductInfoTowTextPreview() {
    ShoppingCartTheme {
        ProductInfoTowText("금액 금액금액금액금액금액 금액금액", "42,20000000000000000000000원 ")
    }
}
