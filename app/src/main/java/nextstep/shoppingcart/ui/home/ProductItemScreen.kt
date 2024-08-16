package nextstep.shoppingcart.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.ui.ShoppingCartDestinations
import nextstep.shoppingcart.ui.theme.productTitleStyle
import java.text.NumberFormat
import java.util.Locale

@Composable
fun ProductItem(
    navController: NavController,
    product: Product
) {
    Column(
        modifier = Modifier.clickable {
            navController.navigate(ShoppingCartDestinations.DETAIL_ROUTE + "/${product.productId}")
        }
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

        ) {
            Text(
                text = product.name,
                style = productTitleStyle,
                color = MaterialTheme.colorScheme.secondary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "${formatPrice(product.price)}원",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.secondary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductItemPreview() {
    val product = Product(
        productId = 1,
        imageUrl = "https://picsum.photos/156/158",
        name = "상품 이름을 테스트해보겠습니다 말줄입이 되나요",
        price = 1200000000
    )
    ProductItem(rememberNavController(), product)
}

fun formatPrice(price: Int): String {
    val format = NumberFormat.getNumberInstance(Locale.KOREA)
    format.maximumFractionDigits = 0  // 소수점 이하를 표시하지 않음
    return format.format(price)
}