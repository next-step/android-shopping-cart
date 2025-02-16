package nextstep.shoppingcart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import nextstep.shoppingcart.model.dummyCartProductList
import nextstep.shoppingcart.ui.ProductCartScreen
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class ProductCartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                ProductCartScreen(
                    model = dummyCartProductList,
                    onBackButtonClick = {
                        onBackPressedDispatcher.onBackPressed()
                    }
                )
            }
        }
    }
}
