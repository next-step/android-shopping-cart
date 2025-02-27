package nextstep.shoppingcart.productlist

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import nextstep.shoppingcart.cart.CartActivity
import nextstep.shoppingcart.data.ProductsTestData
import nextstep.shoppingcart.productdetail.ProductDetailActivity
import nextstep.shoppingcart.productlist.model.ProductListUiState
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class ProductListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val uiState = ProductListUiState.Success(ProductsTestData.productTestDataList)
        setContent {
            ShoppingCartTheme {
                ProductListScreen(
                    uiState = uiState,
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
