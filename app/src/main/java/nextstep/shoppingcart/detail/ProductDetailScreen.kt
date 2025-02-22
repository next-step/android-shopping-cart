package nextstep.shoppingcart.detail

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.common.ShoppingCartButton
import nextstep.shoppingcart.common.ProductImage
import nextstep.shoppingcart.common.ShoppingCartAppBar
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.Gray10
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductDetailScreen(
    product: Product,
    onButtonClick: (Product) -> Unit,
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
            ShoppingCartButton(
                text = stringResource(R.string.add_to_cart),
                onClick = { onButtonClick(product) }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            ProductImage(
                modifier = Modifier.aspectRatio(1f),
                imageUrl = product.imageUrl
            )

            Text(
                modifier = Modifier.padding(18.dp),
                text = product.name,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )

            HorizontalDivider(
                color = Gray10
            )

            ProductDetailField(
                modifier = Modifier.padding(18.dp),
                title = stringResource(R.string.price),
                content = stringResource(R.string.format_price_won, product.price)
            )
        }
    }
}

@Composable
private fun ProductDetailField(
    title: String,
    content: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = content,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductDetailScreenPreview() {
    ShoppingCartTheme {
        ProductDetailScreen(
            product = Product(
                id = "",
                imageUrl = "https://picsum.photos/200",
                name = "셀프 마라탕 (기본 12000원)",
                price = 85000000
            ),
            onButtonClick = {},
            onBackPressed = {}
        )
    }
}