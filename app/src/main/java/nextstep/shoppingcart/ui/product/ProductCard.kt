package nextstep.shoppingcart.ui.product

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
internal fun ProductCard(
    product: Product,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        AsyncImage(
            model = product.imgUrl,
            contentDescription =
                stringResource(
                    id = R.string.product_image_content_description,
                    product.name,
                ),
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(158.dp),
        )

        Text(
            text = product.name,
            overflow = TextOverflow.Ellipsis,
            style =
                MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                ),
            maxLines = 1,
            modifier =
                Modifier
                    .padding(
                        top = 8.dp,
                        bottom = 2.dp,
                        start = 4.dp,
                    ),
        )
        Text(
            text = stringResource(id = R.string.product_price, product.price),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(start = 4.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductCardPreview(
    @PreviewParameter(ProductCardPreviewProvider::class) product: Product,
) {
    ShoppingCartTheme {
        ProductCard(
            product = product,
        )
    }
}

class ProductCardPreviewProvider : PreviewParameterProvider<Product> {
    override val values: Sequence<Product> =
        sequenceOf(
            Product(
                id = 1,
                name = "M3 MacBook Air",
                price = 2000,
                imgUrl =
                    "https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/mac-card-40-macbook-air-m2-m3-202402?wid=1400&hei=1000&fmt=p-jpg&qlt=95&.v=1707259317253",
            ),
            Product(
                id = 2,
                name = "MacBook Pro",
                price = 1000,
                imgUrl =
                    "https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/mac-card-40-macbookpro-14-16-202310?wid=1200&hei=1000&fmt=p-jpg&qlt=95&.v=1699558878477",
            ),
            Product(
                id = 3,
                name = "행운을 드립니다. 여러분께 드립니다. 삼태기로 퍼드립니다.",
                price = 800,
                imgUrl =
                    "https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/mac-card-40-imac-24-202310?wid=1200&hei=1000&fmt=jpeg&qlt=90&.v=1697229623322",
            ),
        )
}
