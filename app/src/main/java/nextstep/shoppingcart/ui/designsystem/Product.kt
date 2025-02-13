package nextstep.shoppingcart.ui.designsystem

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import coil3.compose.SubcomposeAsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import java.text.NumberFormat

private val priceFormat = NumberFormat.getNumberInstance()

@Composable
fun ProductListItem(
    product: Product,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        SubcomposeAsyncImage(
            modifier = Modifier.aspectRatio(1 / 1f),
            model = product.imageUrl,
            contentDescription = "${product.name} image",
            contentScale = ContentScale.Crop,
            error = {
                // 현재 preview 모드 인지 확인
                if (LocalInspectionMode.current) {
                    Image(
                        painter = painterResource(R.drawable.dummy),
                        contentScale = ContentScale.Crop,
                        contentDescription = null,
                    )
                } else {
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = null,
                        tint = Color.Red,
                    )
                }
            }
        )
        Text(
            text = product.name,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
        )
        Text(
            text = stringResource(R.string.product_price_format, priceFormat.format(product.price)),
            style = MaterialTheme.typography.titleMedium,
        )
    }
}

@Preview(
    showBackground = true,
)
@Composable
private fun ProductListItemPreview() {
    ShoppingCartTheme {
        ProductListItem(
            product = Product(
                imageUrl = "",
                name = LoremIpsum(100).values.joinToString(""),
                price = 999_999_999,
            )
        )
    }
}
