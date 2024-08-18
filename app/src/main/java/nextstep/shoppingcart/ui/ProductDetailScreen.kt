package nextstep.shoppingcart.ui

import android.annotation.SuppressLint
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.Product
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.component.ProductDetail
import nextstep.shoppingcart.ui.component.ShoppingCartNavigationTopBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProductDetailScreen(
    product: Product,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            ShoppingCartNavigationTopBar(
                title = stringResource(id = R.string.title_activity_product_detail),
                onNavigationClick = {
                    (context as? ComponentActivity)?.finish()
                }
            )
        },
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        ProductDetail(
            product = product,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Preview
@Composable
private fun ProductDetailScreenPreview() {
    val product = Product(
        imageUrl = "https://image.msscdn.net/images/goods_img/20230425/3257548/3257548_16823548430020_500.jpg",
        name = "루바토 브이넥 반팔 티셔츠 네이비",
        price = 16371
    )
    ProductDetailScreen(product)
}