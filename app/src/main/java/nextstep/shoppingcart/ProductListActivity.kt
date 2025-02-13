package nextstep.shoppingcart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import nextstep.shoppingcart.model.ShoppingCartTopBarType
import nextstep.shoppingcart.model.dummyProducts
import nextstep.shoppingcart.ui.ProductScreen
import nextstep.shoppingcart.ui.component.ShoppingCartTopBar
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class ProductListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        ShoppingCartTopBar(
                            type = ShoppingCartTopBarType.PRODUCT_LIST
                        )
                    }
                ) { innerPadding ->
                    ProductScreen(
                        products = dummyProducts,
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}
