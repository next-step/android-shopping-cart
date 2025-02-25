package nextstep.shoppingcart.productList

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.cart.CartActivity
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class ProductListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                ProductListScreen(
                    onCartButtonClick = {
                        CartActivity.start(this)
                    },
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductListActivityPreview() {
    ShoppingCartTheme {
        ProductListScreen()
    }
}
