package nextstep.shoppingcart.ui.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.Cart
import nextstep.shoppingcart.ui.component.ShoppingCartNavigationTopBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProductDetailScreen(
    product: Product,
    onNavigationClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            ShoppingCartNavigationTopBar(
                title = stringResource(id = R.string.title_activity_product_detail),
                onNavigationClick = onNavigationClick
            )
        },
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        ProductDetail(
            product = product,
            onAddToCart = { Cart.addOne(product = product) },
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Preview
@Composable
private fun ProductDetailScreenPreview() {
    val product = Product(
        id = 1,
        imageUrl = "https://image.msscdn.net/images/goods_img/20230425/3257548/3257548_16823548430020_500.jpg",
        name = "루바토 브이넥 반팔 티셔츠 네이비",
        price = 16371
    )
    ProductDetailScreen(
        product = product,
        onNavigationClick = { }
    )
}