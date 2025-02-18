package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
internal fun ProductItem(
    product: Product,
    onProductClick: (Product) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .clickable {
                onProductClick(product)
            }
    ) {
        ProductImage(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            url = product.imageUrl,
            contentScale = ContentScale.Crop,
        )
        Text(
            text = product.name,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                color = Color(0xFF333333),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                lineHeight = 14.sp,
                letterSpacing = 0.5.sp
            )
        )
        Text(
            text = stringResource(R.string.price_format, product.price),
            maxLines = 1,
            style = TextStyle(
                color = Color(0xFF333333),
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.5.sp
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun ProductItemPreview() {
    ShoppingCartTheme {
        ProductItem(
            product = Product(
                id = 2300,
                name = "Carmella Hardin",
                imageUrl = "https://picsum.photos/200",
                price = 6085
            ),
            onProductClick = {}
        )
    }
}
