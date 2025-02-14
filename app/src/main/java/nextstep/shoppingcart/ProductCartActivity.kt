package nextstep.shoppingcart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import nextstep.shoppingcart.ui.ProductCartScreen
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class ProductCartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) { innerPadding ->
                    ProductCartScreen(
                        modifier = Modifier.padding(innerPadding),
                        onBackButtonClick = {
                            onBackPressedDispatcher.onBackPressed()
                        }
                    )
                }
            }
        }
    }
}
