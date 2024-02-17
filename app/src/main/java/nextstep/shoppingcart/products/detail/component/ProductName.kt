package nextstep.shoppingcart.products.detail.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun ProductName(
    productName: String,
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier
            .fillMaxWidth(),
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        text = productName,
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductDetailNamePreview() {
    ProductName("제품 이름이 요기잉네")
}
