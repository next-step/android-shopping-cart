package nextstep.shoppingcart.ui.product.detail

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.data.cart.Cart
import nextstep.shoppingcart.ui.cart.CartActivity
import nextstep.shoppingcart.ui.product.detail.component.ProductDetailTopBar
import nextstep.shoppingcart.ui.product.detail.component.ProductOverview
import nextstep.shoppingcart.ui.product.detail.component.ProductPrice
import nextstep.shoppingcart.ui.product.detail.component.ProductBottomBar

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
                    Cart.addOne(product)
                    val intent = Intent(context, CartActivity::class.java)
                    context.startActivity(intent)
                }
            )
        }
    ) { paddingValue ->
        Column(
            modifier = modifier.padding(paddingValue)
        ) {
            ProductOverview(Modifier, product)

            Divider()

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