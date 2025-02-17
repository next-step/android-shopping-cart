package nextstep.shoppingcart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.ui.theme.shopping.ProductListScreen
import nextstep.shoppingcart.ui.theme.shopping.getProductsTestData
import nextstep.shoppingcart.ui.theme.shopping.model.ProductListUiState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val uiState = ProductListUiState.Products(getProductsTestData())
        setContent {
            ShoppingCartTheme {
                ProductListScreen(uiState)
            }
        }
    }
}