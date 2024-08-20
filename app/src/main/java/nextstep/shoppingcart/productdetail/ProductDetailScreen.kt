package nextstep.shoppingcart.productdetail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.common.component.NextStepTopAppBar
import nextstep.shoppingcart.common.model.Product
import nextstep.shoppingcart.productdetail.component.ProductDetailBottomBar
import nextstep.shoppingcart.productdetail.component.ProductDetailContent
import java.util.UUID

@Composable
internal fun ProductDetailScreen(
    product: Product,
    onAddToCartClick: () -> Unit,
    onBackClick: () -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            NextStepTopAppBar(
                title = stringResource(R.string.product_details),
                onBackClick = onBackClick,
            )
        },
        content = { paddingValues ->
            ProductDetailContent(
                product = product,
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
            )
        },
        bottomBar = { ProductDetailBottomBar(onAddToCartClick = onAddToCartClick) }
    )
}

@Preview
@Composable
private fun ProductDetailScreenPreview() {
    ProductDetailScreen(
        product = Product(
            id = UUID.randomUUID().toString(),
            name = "PET보틀-원형(500ml)",
            price = 42_200,
            imageUrl = "https://picsum.photos/500",
        ),
        onAddToCartClick = {},
        onBackClick = {},
    )
}