package nextstep.shoppingcart.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.common.ShoppingCartAppBar
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.LightGray
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductDetailScreen(
    product: Product,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            ShoppingCartAppBar(
                title = stringResource(R.string.product_detail),
                onBackPressed = onBackPressed
            )
        },
        bottomBar = {
            ProductDetailBottomButton(onClick = {})
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            if (LocalInspectionMode.current) {
                Image(
                    modifier = Modifier.aspectRatio(1f),
                    painter = painterResource(R.drawable.ic_launcher_background),
                    contentDescription = null
                )
            } else {
                AsyncImage(
                    modifier = Modifier.aspectRatio(1f),
                    placeholder = ColorPainter(Color.LightGray),
                    model = product.imageUrl,
                    contentDescription = null
                )
            }

            Text(
                modifier = Modifier.padding(18.dp),
                text = product.name,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )

            HorizontalDivider(
                color = LightGray
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.price),
                    style = MaterialTheme.typography.bodyLarge
                )

                Text(
                    text = stringResource(R.string.format_price_won, product.price),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductDetailScreenPreview() {
    ShoppingCartTheme {
        ProductDetailScreen(
            product = Product(
                imageUrl = "https://picsum.photos/200",
                name = "셀프 마라탕 (기본 12000원)",
                price = 85000000
            ),
            onBackPressed = {}
        )
    }
}