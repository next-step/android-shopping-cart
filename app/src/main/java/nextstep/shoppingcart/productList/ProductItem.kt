package nextstep.shoppingcart.productList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.component.ProductImage
import nextstep.shoppingcart.data.Product


@Composable
fun ProductItem(
    product: Product,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        color = Color.White
    ) {
        Column {
            ProductImage(
                imageUrl = product.imageUrl,
                ratio = (156.0f / 158),
                modifier = Modifier
                    .fillMaxWidth()
            )
            Text(
                text = product.name,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                fontWeight = FontWeight.W700,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .padding(horizontal = 4.dp)
                    .fillMaxWidth()
            )
            Text(
                text = stringResource(R.string.price_comma, product.price),
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductItemPreview() {
    val product = Product(
        name = "상품이름",
        imageUrl = "",
        price = 10000
    )

    ProductItem(
        product = product
    )
}