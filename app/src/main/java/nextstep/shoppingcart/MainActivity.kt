package nextstep.shoppingcart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import kotlinx.coroutines.delay
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.model.dummyProducts
import nextstep.shoppingcart.ui.product_list.ProductListScreen
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            ShoppingCartTheme {
                // 초기 아이템 로딩
                var products by remember {
                    mutableStateOf(emptyList<Product>())
                }
                var isLoading by remember {
                    mutableStateOf(true)
                }

                LaunchedEffect(Unit) {
                    delay(500L)
                    products = dummyProducts
                    isLoading = false
                }

                splashScreen.setKeepOnScreenCondition {
                    isLoading
                }
                if (!isLoading) {
                    ProductListScreen(products)
                }
            }
        }
    }
}
