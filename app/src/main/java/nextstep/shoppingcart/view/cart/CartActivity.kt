package nextstep.shoppingcart.view.cart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import nextstep.shoppingcart.model.Cart
import nextstep.shoppingcart.model.CountState
import nextstep.shoppingcart.view.resource.ShoppingCartTheme

class CartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ShoppingCartTheme {
                val countState = CountState.uiState.collectAsState()
                CartScreen(
                    Cart.items,
                    onBack = { finish() },
                    onOrderClicked = {},
                    buttonClickState = countState.value,
                    setButtonClickState = { state ->
                        CountState.setUiState(state)
                    }
                )
            }
        }
    }
}
