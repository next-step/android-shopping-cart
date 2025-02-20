package nextstep.shoppingcart.features.productlist

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import nextstep.shoppingcart.data.FakeProductRepository
import nextstep.shoppingcart.data.InMemoryCartRepository
import nextstep.shoppingcart.domain.model.Cart
import nextstep.shoppingcart.domain.model.CartItem
import nextstep.shoppingcart.domain.model.Product
import nextstep.shoppingcart.domain.model.Products
import nextstep.shoppingcart.features.cart.CartActivity
import nextstep.shoppingcart.features.productdetail.ProductDetailActivity
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class ProductListActivity : ComponentActivity() {
    private val products: Products = FakeProductRepository.getAllProducts()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val cartState = remember { InMemoryCartRepository.cart }

            val items by remember(cartState.value) {
                derivedStateOf { mergeProductsWithCart(products, cartState.value) }
            }

            enableEdgeToEdge()
            ShoppingCartTheme {
                ProductListScreen(
                    items = items,
                    onAddOneClick = InMemoryCartRepository::addOne,
                    onRemoveOneClick = InMemoryCartRepository::removeOne,
                    onActionCartClick = ::startCartActivity,
                    onProductClick = ::startProductDetailActivity,
                )
            }
        }
    }

    private fun mergeProductsWithCart(products: Products, cart: Cart): Map<Product, CartItem?> {
        return products.value.associateWith { product ->
            cart.find(product)
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
