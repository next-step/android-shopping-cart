package nextstep.shoppingcart.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import nextstep.shoppingcart.FakeProductsRepository
import nextstep.shoppingcart.model.Cart
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.productdetail.ProductDetailActivity
import nextstep.shoppingcart.ui.products.ProductsScreen
import nextstep.shoppingcart.ui.shoppingcart.ShoppingCartActivity
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                enableEdgeToEdge()
                ProductsScreen(
                    products = FakeProductsRepository.getProducts(),
                    onProductClick = { product -> handleProductClick(product) },
                    onShoppingCartActionClick = ::handleShoppingCartActionClick,
                    cartItems = Cart.items,
                    onProductAddClick = Cart::addOne,
                    onProductRemoveClick = Cart::removeOne
                )
            }
        }
    }

    private fun handleProductClick(product: Product) {
        startActivity(ProductDetailActivity.getIntent(this, product.id))
    }

    private fun handleShoppingCartActionClick() {
        startActivity(ShoppingCartActivity.getIntent(this))
    }
}
