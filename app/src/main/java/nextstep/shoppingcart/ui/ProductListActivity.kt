package nextstep.shoppingcart.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import nextstep.shoppingcart.data.repository.ProductRepository
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class ProductListActivity : ComponentActivity() {
    private val productList = ProductRepository.getProductList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShoppingCartTheme {
                ProductListScreen(
                    productList = productList,
                    onTopBarButtonClick = { ProductCartActivity.open(this) },
                    onItemClick = { ProductDetailActivity.open(this, it.id) }
                )
            }
        }
    }
}
