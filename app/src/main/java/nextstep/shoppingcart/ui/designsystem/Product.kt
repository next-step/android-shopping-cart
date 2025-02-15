package nextstep.shoppingcart.ui.designsystem

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

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
            style = MaterialTheme.typography.titleMedium,
            maxLines = 1,
            modifier = Modifier
                .padding(top = 8.dp, start = 4.dp)
        )
        Text(
            text = stringResource(R.string.product_price_format, product.price),
            modifier = Modifier
                .padding(start = 4.dp)
        )
    }
}

@Composable
fun ProductDetailItem(
    product: Product,
    modifier: Modifier = Modifier
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
            style = MaterialTheme.typography.headlineMedium,
            maxLines = 1,
            modifier = Modifier
                .padding(18.dp)
        )
        HorizontalDivider()
        Row(
            modifier = Modifier
                .padding(18.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = stringResource(R.string.price),
            )
            Text(
                text = stringResource(R.string.product_price_format, product.price),
                modifier = Modifier.weight(1f), // 금액이 매우 길어지면 줄바꿈이 일어나도록 weight 설정
                textAlign = TextAlign.End,
            )
        }
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

@Preview(
    showBackground = true,
)
@Composable
private fun ProductDetailPreview() {
    ShoppingCartTheme {
        ProductDetailItem(
            product = Product(
                imageUrl = "",
                name = LoremIpsum(100).values.joinToString(""),
                price = 999_999_999,
            )
        )
    }
}
