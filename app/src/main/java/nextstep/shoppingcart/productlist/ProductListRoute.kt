package nextstep.shoppingcart.productlist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.serialization.Serializable
import nextstep.shoppingcart.common.model.Cart
import nextstep.shoppingcart.common.model.Product
import nextstep.shoppingcart.common.model.dummyProducts

@Serializable
internal object ProductListRoute {

    /*
    * 이 내용들은 실제로는 뷰모델에서 이뤄져야 한다고 생각합니다.
    * */
    @Composable
    operator fun invoke(
        onProductClick: (Product) -> Unit,
        onCartClick: () -> Unit,
    ) {
        var products by remember {
            mutableStateOf(
                dummyProducts.map { product ->
                    val cartItem = Cart.items.find { it.product == product }
                    ProductListScreenItem(
                        product = product,
                        count = cartItem?.count ?: 0 // Cart에 동일한 제품이 있으면 그 수량을, 없으면 0을 사용
                    )
                }
            )
        }

        val onCountAddClick: (ProductListScreenItem) -> Unit = { productItem ->
            Cart.addOne(productItem.product)
            products = products.map { item ->
                if (item.product == productItem.product) {
                    item.copy(count = item.count + 1)
                } else {
                    item
                }
            }
        }

        val onCountMinusClick: (ProductListScreenItem) -> Unit = { productItem ->
            Cart.removeOne(productItem.product)
            products = products.map { item ->
                if (item.product == productItem.product) {
                    item.copy(count = (item.count - 1).coerceAtLeast(0))
                } else {
                    item
                }
            }
        }

        ProductListScreen(
            products = products,
            onProductClick = { onProductClick(it.product) },
            onCartClick = onCartClick,
            onCountAddClick = onCountAddClick,
            onCountMinusClick = onCountMinusClick,
        )
    }
}