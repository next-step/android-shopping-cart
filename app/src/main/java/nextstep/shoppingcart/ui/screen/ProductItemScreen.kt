package nextstep.shoppingcart.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import nextstep.shoppingcart.data.Product
import java.text.NumberFormat
import java.util.Locale

@Preview(showBackground = true)
@Composable
private fun ProductItemPreview() {
    val product = Product(
        imageUrl = "https://picsum.photos/156/158",
        name = "상품 이름을 테스트해보겠습니다 말줄입이 되나요",
        price = 1200000000
    )
    ProductItem(product)
}

@Composable
fun ProductItem(product: Product) {
    Column(
        modifier = Modifier
            .width(156.dp)
            .height(IntrinsicSize.Min)
    ) {
        AsyncImage(
            model = product.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .width(156.dp)
                .height(158.dp)
        )
        Column(
            modifier = Modifier
                .padding(top = 4.dp, start = 4.dp)
                .fillMaxSize()
        ) {
            Text(
                text = product.name,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color(0xFF333333),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "${formatPrice(product.price)}원",
                fontSize = 16.sp,
                color = Color(0xFF333333),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

fun formatPrice(price: Int): String {
    val format = NumberFormat.getNumberInstance(Locale.KOREA)
    format.maximumFractionDigits = 0  // 소수점 이하를 표시하지 않음
    return format.format(price)
}