package nextstep.shoppingcart.features.productdetail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.components.topbars.StartTitleTopBar
import nextstep.shoppingcart.components.topbars.TopBarNavigationType
import nextstep.shoppingcart.data.FakeProductRepository
import nextstep.shoppingcart.domain.model.Product
import nextstep.shoppingcart.features.productdetail.components.ProductDetail
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

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

