package nextstep.shoppingcart.productdetail

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import nextstep.shoppingcart.cart.CartActivity
import nextstep.shoppingcart.data.Cart
import nextstep.shoppingcart.data.ProductsTestData.productTestDataList
import nextstep.shoppingcart.productdetail.model.ProductDetailUiState
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class ProductDetailActivity : ComponentActivity() {
    private val productId: String by lazy {
        intent.getStringExtra("productId")
            ?: throw IllegalArgumentException("productId is required")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var product: ProductDetailUiState by remember { mutableStateOf(ProductDetailUiState.Loading) }

            LaunchedEffect(Unit) {
                product = getProductDetails(productId)
            }

            ShoppingCartTheme {
                ProductDetailScreen(
                    uiState = product,
                    navigateToCart = { id ->
                        Cart.addOne(productTestDataList.find { it.productId == id }!!)
                        navigateToCart()
                    },
                    onBackButtonClick = { onBackPressedDispatcher.onBackPressed() })
            }
        }
    }

    private fun navigateToCart() {
        val intent = Intent(this, CartActivity::class.java)
        startActivity(intent)
    }
}

fun getProductDetails(productId: String): ProductDetailUiState {
    return try {
        productTestDataList.find { it.productId == productId }?.let {
            ProductDetailUiState.ProductDetail(it)
        } ?: ProductDetailUiState.Empty
    } catch (t: Throwable) {
        ProductDetailUiState.Error
    }
}
