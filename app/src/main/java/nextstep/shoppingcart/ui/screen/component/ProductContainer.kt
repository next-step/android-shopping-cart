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

@Composable
fun ProductItemContainer(
    title: String,
    price: Int,
    imageUrl: String,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier,
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
        PriceText(price = price)
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