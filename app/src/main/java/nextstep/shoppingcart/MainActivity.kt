package nextstep.shoppingcart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.ui.screen.ProductList
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class MainActivity : ComponentActivity() {
    val products: List<Product> = getProducts()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                // A surface container using the 'background' color from the theme
                ProductList(products)
            }
        }
    }
}

fun getProducts(): List<Product> {
    return listOf(
        Product(
            name = "PET보틀-정사각형",
            price = 10000,
            imageUrl = "https://picsum.photos/156/158"
        ),
        Product(
            name = "PET보틀-밀크티",
            price = 12000,
            imageUrl = "https://picsum.photos/156/158"
        ),
        Product(
            name = "PET보틀-정사각각형",
            price = 10000,
            imageUrl = "https://picsum.photos/156/158"
        ),
        Product(
            name = "PET보틀-납작(200ml)",
            price = 12000,
            imageUrl = "https://picsum.photos/156/158"
        ),
        Product(
            name = "PET보틀-정사각형",
            price = 10000,
            imageUrl = "https://picsum.photos/156/158"
        ),
        Product(
            name = "PET보틀-납작(200ml)",
            price = 12000,
            imageUrl = "https://picsum.photos/156/158"
        ),
        Product(
            name = "PET보틀-정사각형",
            price = 10000,
            imageUrl = "https://picsum.photos/156/158"
        ),
        Product(
            name = "PET보틀-납작(200ml)",
            price = 12000,
            imageUrl = "https://picsum.photos/156/158"
        )
    )
}