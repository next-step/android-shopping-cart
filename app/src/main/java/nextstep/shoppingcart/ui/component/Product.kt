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
import nextstep.shoppingcart.productlist.model.ProductWithCartInfo
import nextstep.shoppingcart.util.translateNumberMoneyFormat

@Composable
fun Product(
    product: ProductWithCartInfo,
    navigateToProductDetail: (String) -> Unit,
    onDecreaseProductQuantity: (Product) -> Unit,
    onIncreaseProductQuantity: (Product) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.clickable { navigateToProductDetail(product.product.productId) }) {
        Box(contentAlignment = Alignment.BottomCenter) {
            ProductImage(
                imageUrl = product.product.imageUrl,
                contentDescription = "${product.product.name} 이미지",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 6.dp),
            )
            ProductQuantityControl(
                item = product,
                onDecreaseProductQuantity = onDecreaseProductQuantity,
                onIncreaseProductQuantity = onIncreaseProductQuantity,
                modifier = Modifier,
            )

        }

        Text(
            product.product.name,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(translateNumberMoneyFormat(product.product.price))
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductPreview() {
    Product(
        product = ProductWithCartInfo(
            product = Product(
                name = "Dan Kelley",
                imageUrl = "https://search.yahoo.com/search?p=morbi",
                price = 8509,
                productId = "mea"
            ), cartCount = 6170
        ),
        navigateToProductDetail = {},
        onDecreaseProductQuantity = {},
        onIncreaseProductQuantity = {},
    )
}
