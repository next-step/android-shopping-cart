package nextstep.shoppingcart.ui.product.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.model.Products
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
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(158.dp),
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

class ProductCardPreviewProvider :
    CollectionPreviewParameterProvider<Product>(
        collection =
            Products
                .take(3)
                .mapIndexed { index, product ->
                    if (index == 2) {
                        product.copy(
                            name = "행운을 드립니다. 여러분께 드립니다. 삼태기로 퍼드립니다. 행운을 드립니다. 여러분께 드립니다. 삼태기로 퍼드립니다",
                        )
                    } else {
                        product
                    }
                },
    )
