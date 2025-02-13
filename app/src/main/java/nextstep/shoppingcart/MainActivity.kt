package nextstep.shoppingcart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import nextstep.shoppingcart.data.FakeProductRepository
import nextstep.shoppingcart.domain.Products
import nextstep.shoppingcart.screens.MainScreen
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class MainActivity : ComponentActivity() {
    private val products: Products = FakeProductRepository.getAllProducts()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            enableEdgeToEdge()
            ShoppingCartTheme {
                MainScreen(
                    products = products,
                    onActionClick = { /* TODO: 장바구니 이동 로직 구현(2단계 미션) */ }
                )
            }
        }
    }
}
