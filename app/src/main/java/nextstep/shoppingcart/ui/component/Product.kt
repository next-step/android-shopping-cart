package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.productlist.component.ProductQuantityControl
import nextstep.shoppingcart.util.translateNumberMoneyFormat

@Composable
fun Product(
    product: Product,
    navigateToProductDetail: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.clickable { navigateToProductDetail(product.productId) }) {
        Box(contentAlignment = Alignment.BottomCenter) {
            ProductImage(
                imageUrl = product.imageUrl,
                contentDescription = "${product.name} 이미지",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 6.dp),
            )
            ProductQuantityControl(
                item = product,
                quantity = 1,
                onDecreaseProductQuantity = {},
                onIncreaseProductQuantity = {},
                modifier = Modifier,
            )

        }

        Text(
            product.name,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(translateNumberMoneyFormat(product.price))
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductPreview() {
    Product(
        product = Product(
            name = "PET 보틀 - 정사각형 음료수,사각형 음료수",
            imageUrl = "https://cdn.digitaltoday.co.kr/news/photo/202502/553394_517550_359.jpg",
            price = 100000,
            productId = "상세로이동"
        ),
        navigateToProductDetail = {}
    )
}
