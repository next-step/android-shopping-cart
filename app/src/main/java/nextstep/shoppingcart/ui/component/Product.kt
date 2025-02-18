package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import nextstep.shoppingcart.model.product.Product

@Composable
fun Product(
    product: Product,
    navigateToProductDetail: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.clickable { navigateToProductDetail(product.productId) }) {
        AsyncImage(
            model = product.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 6.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            product.name,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(product.formattedPrice)
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductPreview() {
    Product(
        product = Product(
            name = "PET 보틀 - 정사각형 음료수,사각형 음료수",
            imageUrl = "https://i.namu.wiki/i/rwoGbf-OhaV1A1I77FtQEWojKsa-i9J0HZ0E3tFfr4gdi7fCHRh7DwaqLkLzKdruftxpu_twLfkhwgMxc3QrvgY9HhwbwB7W_YPGbkjpCIxFO9abcyQSLgM8NVUkKJ6WPegKkT35ukb0NXXRHeMW1zGcxZz_9zx63o9Pnat6I3Q.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",
            price = "10000",
            productId = "상세로이동"
        ),
        navigateToProductDetail = {}
    )
}
