package nextstep.shoppingcart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.ui.screen.ProductDetailScreen
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.util.Const.PRODUCT_ID
import nextstep.shoppingcart.util.Const.PRODUCT_IMAGE
import nextstep.shoppingcart.util.Const.PRODUCT_NAME
import nextstep.shoppingcart.util.Const.PRODUCT_PRICE
import nextstep.shoppingcart.util.Exe

class ProductDetailActivity : ComponentActivity() {

    private val productId: Int by lazy {
        intent.getIntExtra(PRODUCT_ID, -1)
    }
    private val productName: String by lazy {
        intent.getStringExtra(PRODUCT_NAME)
            ?: throw IllegalArgumentException("productName is required")
    }
    private val productPrice: Int by lazy {
        intent.getIntExtra(PRODUCT_PRICE, -1)
    }
    private val productImage: String by lazy {
        intent.getStringExtra(PRODUCT_IMAGE)
            ?: throw IllegalArgumentException("productImage is required")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                ProductDetailScreen(
                    product = Product(
                        id = productId,
                        name = productName,
                        price = productPrice,
                        imageUrl = productImage,
                    ),
                    onAddCardClicked = { Exe.cart(this) },
                    onBackPressed = { finish() },
                )
            }
        }
    }
}

@Preview
@Composable
private fun ProductDetailActivityPreview() {
    ShoppingCartTheme {
        ProductDetailScreen(
            product = Product(
                id = 1,
                name = "Product 1",
                price = 1000,
                imageUrl = "https://www.example.com/image"
            ),
            onAddCardClicked = { },
            onBackPressed = { },
        )
    }
}