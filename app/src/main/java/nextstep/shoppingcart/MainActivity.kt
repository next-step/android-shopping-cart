package nextstep.shoppingcart

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import nextstep.shoppingcart.data.FakeProductRepository
import nextstep.shoppingcart.data.InMemoryCartRepository
import nextstep.shoppingcart.domain.model.Product
import nextstep.shoppingcart.domain.model.Products
import nextstep.shoppingcart.screens.MainScreen
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class MainActivity : ComponentActivity() {
    private val products: Products = FakeProductRepository.getAllProducts()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            enableEdgeToEdge()
            ShoppingCartTheme {
                MainScreen(
                    products = products,
                    cart = InMemoryCartRepository.cart.value,
                    onAddOneClick = InMemoryCartRepository::addOne,
                    onRemoveOneClick = InMemoryCartRepository::removeOne,
                    onActionCartClick = ::startCartActivity,
                    onProductClick = ::startProductDetailActivity,
                )
            }
        }
    }

    private fun startProductDetailActivity(it: Product) {
        val intent: Intent = ProductDetailActivity.getIntent(context = this, productId = it.id)
        startActivity(intent)
    }

    private fun startCartActivity() {
        val intent: Intent = CartActivity.getIntent(context = this)
        startActivity(intent)
    }
}
