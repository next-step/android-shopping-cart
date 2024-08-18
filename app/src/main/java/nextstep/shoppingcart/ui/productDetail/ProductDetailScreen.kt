package nextstep.shoppingcart.ui.productDetail

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.ui.data.Product
import nextstep.shoppingcart.ui.productDetail.component.ProductDetailTopBar
import nextstep.shoppingcart.ui.productDetail.component.ProductOverview
import nextstep.shoppingcart.ui.productDetail.component.ProductPrice
import nextstep.shoppingcart.ui.productList.component.ProductBottomBar
import nextstep.shoppingcart.ui.shoppingCart.ShoppingCartActivity

@Composable
fun ProductDetailScreen(modifier: Modifier, product: Product) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            ProductDetailTopBar(
                modifier,
                onClickBackIcon = { (context as? Activity)?.finish() }
            )
        },
        bottomBar = {
            ProductBottomBar(
                onClickBottomBar = {
                    val intent = Intent(context, ShoppingCartActivity::class.java)
                    context.startActivity(intent)
                }
            )
        }
    ) { paddingValue ->
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