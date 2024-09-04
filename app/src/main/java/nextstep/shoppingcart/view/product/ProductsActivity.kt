package nextstep.shoppingcart.view.product

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import nextstep.shoppingcart.model.Cart
import nextstep.shoppingcart.model.CountState
import nextstep.shoppingcart.view.product.detail.ProductDetailActivity
import nextstep.shoppingcart.view.resource.ShoppingCartTheme

class ProductsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                val countState = CountState.uiState.collectAsState()

                ProductsScreen(
                    onItemClick = { product ->
                        val intent = Intent(this, ProductDetailActivity::class.java).apply {
                            putExtra("product_name", product.name)
                            putExtra("product_image_url", product.imageUrl)
                            putExtra("product_price", product.price)
                        }
                        startActivity(intent)
                    },
                    onItemButtonClick = { product ->
                        CountState.setUiState(!countState.value)
                        Cart.addOne(product)
                    },
                    onAddClicked = { product ->
                        CountState.setUiState(!countState.value)
                        Cart.addOne(product)
                    },
                    onRemoveClicked = { product ->
                        CountState.setUiState(!countState.value)
                        Cart.removeOne(product)
                    },
                    buttonClickState = countState.value,
                    setButtonClickState = { state ->
                        CountState.setUiState(state)
                    }
                )
            }
        }
    }
}
