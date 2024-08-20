package nextstep.shoppingcart.ui.shoppingdetail.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.ui.theme.RobotoRegular

@Composable
fun ShoppingDetailPriceText(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        fontSize = 20.sp,
        fontFamily = RobotoRegular,
        color = Color.Black,
        modifier = modifier,
    )
}

@Preview
@Composable
private fun ShoppingDetailPriceTextPreview() {
    ShoppingDetailPriceText("테스트")
}
