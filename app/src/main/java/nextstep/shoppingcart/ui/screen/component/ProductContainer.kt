package nextstep.shoppingcart.ui.screen.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.ui.utils.formatter.DefaultMoneyFormatter
import nextstep.shoppingcart.ui.utils.formatter.MoneyFormatter

@Composable
fun ProductItemContainer(
    title: String,
    price: Int,
    imageUrl: String,
    formatter: MoneyFormatter = DefaultMoneyFormatter,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start,
    ) {
        ProductImage(
            imageUrl = imageUrl,
            contentDescription = "Product Image",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(78f / 79f)
        )
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.W700,
        )
        Text(
            text = "${formatter.format(price)}원",
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductItemPreview() {
    ProductItemContainer(
        imageUrl = "https://www.picsum.photos/200",
        title = "상품 이름",
        price = 10000,
    )
}