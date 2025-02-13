package nextstep.shoppingcart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import nextstep.shoppingcart.data.repository.ProductRepositoryImpl
import nextstep.shoppingcart.ui.component.ProductListScreen
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class MainActivity : ComponentActivity() {
    private val productList = ProductRepositoryImpl.getProductList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                ProductListScreen(
                    productList = productList,
                    onTopBarButtonClick = { }
                )
            }
        }
    }
}
