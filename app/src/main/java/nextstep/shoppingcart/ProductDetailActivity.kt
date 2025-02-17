package nextstep.shoppingcart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.ui.screen.ProductDetailScreen
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class ProductDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                ProductDetailScreen(
                    product = Product(
                        id = 1,
                        name = "Product 1",
                        price = 1000,
                        imageUrl = "https://www.example.com/image"
                    ),
                    onAddCardClicked = { },
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