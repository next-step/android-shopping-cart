package nextstep.shoppingcart.ui.view.product.detail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.composable.DinoTopAppBar
import nextstep.shoppingcart.ui.composable.InvalidAccessItem
import nextstep.shoppingcart.ui.model.Cart
import nextstep.shoppingcart.ui.model.Product
import nextstep.shoppingcart.ui.view.product.cartlist.ProductCartListActivity

@Composable
fun ProductDetailScreen(
    product: Product?,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            DinoTopAppBar(
                text = stringResource(R.string.product_detail_title),
                navigationBack = true
            )
        }
    ) { paddingValues ->
        if (product == null) {
            InvalidAccessItem(modifier = Modifier.padding(paddingValues))
        } else {
            ProductDetailSuccess(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                product = product,
                onBottomCtaClick = {
                    Cart.addOne(product)
                    context.startActivity(ProductCartListActivity.newIntent(context))
                }
            )
        }
    }
}

@Preview
@Composable
private fun ProductDetailScreenPreviewProductNull() {
    ProductDetailScreen(product = null)
}

@Preview
@Composable
private fun ProductDetailScreenPreview() {
    ProductDetailScreen(
        product = Product(
            name = "Product Name",
            price = 10000,
            imageUrl = "https://example.com/image.jpg"
        )
    )
}
