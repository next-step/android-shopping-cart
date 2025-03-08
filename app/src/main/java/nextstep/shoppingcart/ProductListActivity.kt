package nextstep.shoppingcart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class ProductListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                ProductListScreen(
                    products = List(10) {
                        Product(
                            id = it,
                            imageUrl = "https://picsum.photos/id/1/300/300",
                            name = "PET보틀-정사각형 어쩌구",
                            price = 10000
                        )
                    }
                )
            }
        }
    }
}
