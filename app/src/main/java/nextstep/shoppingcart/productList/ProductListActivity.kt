package nextstep.shoppingcart.productList

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.cart.CartActivity
import nextstep.shoppingcart.data.Cart
import nextstep.shoppingcart.data.CartItem
import nextstep.shoppingcart.data.DummyProduct
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.productDetail.ProductDetailActivity
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class ProductListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val products = DummyProduct.productDummyList

        setContent {
            ShoppingCartTheme {
                ProductListScreen(
                    products = products,
                    onItemClick = { product ->
                        ProductDetailActivity.start(this, product)
                    },
                    onCartButtonClick = {
                        CartActivity.start(this)
                    },
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductListActivityPreview() {
    val products = DummyProduct.productDummyList

    ShoppingCartTheme {
        ProductListScreen(
            products = products,
            onItemClick = {},
            onCartButtonClick = {},
        )
    }
}
