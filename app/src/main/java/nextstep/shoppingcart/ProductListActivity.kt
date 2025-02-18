package nextstep.shoppingcart

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import nextstep.shoppingcart.model.product.ProductListUiState
import nextstep.shoppingcart.ui.ProductListScreen
import nextstep.shoppingcart.ui.getProductsTestData
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class ProductListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val uiState = ProductListUiState.Products(getProductsTestData())
        setContent {
            ShoppingCartTheme {
                ProductListScreen(
                    listUiState = uiState,
                    navigateToProductDetail = { id -> navigateToProductDetail(id) },
                    navigateToCart = { navigateToCart() },
                )
            }
        }
    }

    private fun navigateToProductDetail(productId: String) {
        val intent = Intent(this, ProductDetailActivity::class.java)
        intent.putExtra("productId", productId)
        startActivity(intent)
    }

    private fun navigateToCart() {
        val intent = Intent(this, CartActivity::class.java)
        startActivity(intent)
    }
}
