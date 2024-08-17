package nextstep.shoppingcart.ui.productDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.ui.data.Product
import nextstep.shoppingcart.ui.productDetail.component.ProductDetailTopBar
import nextstep.shoppingcart.ui.productDetail.component.ProductOverview
import nextstep.shoppingcart.ui.productDetail.component.ProductPrice
import nextstep.shoppingcart.ui.productList.component.ProductBottomBar

@Composable
fun ProductDetailScreen(modifier: Modifier, product: Product) {
    Scaffold(topBar = {
        ProductDetailTopBar(modifier)
    }, bottomBar = {
        ProductBottomBar()
    }) { paddingValue ->
        Column(
            modifier = modifier.padding(paddingValue)
        ) {
            ProductOverview(Modifier, product)

            Divider(
                modifier = Modifier.fillMaxWidth(), color = Color.Black, thickness = 1.dp
            )

            ProductPrice(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp), product = product
            )
        }
    }
}

@Preview
@Composable
private fun ProductDetailScreenPreview() {
    ProductDetailScreen(
        Modifier, Product(
            id = 9170,
            imgUrl = "https://duckduckgo.com/?q=constituto",
            name = "Ernie Santana",
            price = 1590
        )
    )
}