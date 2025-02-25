package nextstep.shoppingcart.productList

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.cart.CartActivity
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.productDetail.ProductDetailActivity
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class ProductListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val products = List(10) {
            Product(
                "상품이름",
                "https://images.mypetlife.co.kr/content/uploads/2023/03/30102633/AdobeStock_297354202-1024x683.jpeg",
                10_000,
            )
        }

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
    val products = List(10) {
        Product(
            "상품이름",
            "",
            10_000,
        )
    }

    ShoppingCartTheme {
        ProductListScreen(products = products)
    }
}
