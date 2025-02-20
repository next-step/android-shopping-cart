package nextstep.shoppingcart.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.components.MainButton
import nextstep.shoppingcart.components.ProductImage
import nextstep.shoppingcart.components.topbar.StartTitleTopBar
import nextstep.shoppingcart.components.topbar.TopBarNavigationType
import nextstep.shoppingcart.data.FakeProductRepository
import nextstep.shoppingcart.domain.model.Product
import nextstep.shoppingcart.ui.theme.GrayAAAAAA
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.ui.theme.Typography

@Composable
internal fun ProductDetailScreen(
    product: Product,
    onAddCartClick: () -> Unit,
    onBackClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            StartTitleTopBar(
                title = stringResource(R.string.product_detail_top_bar_title),
                navigationType = TopBarNavigationType.BACK,
                onNavigationClick = onBackClick,
            )
        },
        containerColor = Color.White,
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        ProductDetail(
            product = product,
            onAddCartClick = onAddCartClick,
            addCartEnabled = product != Product.NotFound,
            modifier = Modifier.padding(paddingValues),
        )
    }
}

@Composable
internal fun ProductDetail(
    product: Product,
    onAddCartClick: () -> Unit,
    modifier: Modifier = Modifier,
    addCartEnabled: Boolean = true,
) {
    Column(modifier = modifier) {
        ProductImage(
            imageUrl = product.imageUrl,
            contentDescription = product.name,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(ratio = 1f)
        )
        ProductTitle(title = product.name)
        HorizontalDivider(color = GrayAAAAAA)
        ProductPrice(price = product.price.value)
        Spacer(Modifier.weight(1f))
        MainButton(
            text = stringResource(R.string.product_detail_add_cart),
            onClick = onAddCartClick,
            enabled = addCartEnabled,
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
        )
    }
}

@Composable
private fun ProductTitle(title: String) {
    Text(
        text = title,
        style = Typography.headlineSmall.copy(fontWeight = FontWeight.W700),
        modifier = Modifier.padding(18.dp),
    )
}

@Composable
private fun ProductPrice(price: Int) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp),
    ) {
        Text(
            text = stringResource(R.string.price),
            style = Typography.headlineSmall,
        )
        Text(
            text = stringResource(R.string.price_format, price),
            style = Typography.headlineSmall,
        )
    }
}

@Preview
@Composable
private fun ProductDetailScreenPreview() {
    ShoppingCartTheme {
        ProductDetailScreen(
            product = FakeProductRepository.getFirstProduct(),
            onAddCartClick = {},
            onBackClick = {},
        )
    }
}

@Preview
@Composable
private fun ProductDetailScreenWithProductNotFoundPreview() {
    ShoppingCartTheme {
        ProductDetailScreen(
            product = Product.NotFound,
            onAddCartClick = {},
            onBackClick = {},
        )
    }
}
