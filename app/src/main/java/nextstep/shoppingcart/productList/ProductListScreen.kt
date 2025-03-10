package nextstep.shoppingcart.productList

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.cart.CartActivity
import nextstep.shoppingcart.data.DummyProduct
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.productDetail.ProductDetailActivity

@Composable
fun ProductListScreen(
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current

    val productDummyList = DummyProduct.productDummyList

    val products =
        remember { mutableStateListOf<Product>().apply { this.addAll(productDummyList) } }
    val totalCount = products.sumOf { it.count }

    val onItemClick: (Product) -> Unit = { product ->
        ProductDetailActivity.start(context, product)
    }

    val onCartButtonClick: () -> Unit = {
        CartActivity.start(context)
    }

    val onPlusClick: (Product) -> Unit = { product ->
        val index = products.indexOf(product)
        products[index] = product.copy(count = product.count + 1)
    }

    val onMinusClick: (Product) -> Unit = { product ->
        val index = products.indexOf(product)
        products[index] = product.copy(count = product.count - 1)
    }

    ProductListScreen(
        products = products,
        totalCount = totalCount,
        onItemClick = onItemClick,
        onCartButtonClick = onCartButtonClick,
        onPlusClick = onPlusClick,
        onMinusClick = onMinusClick,
        modifier = modifier,
    )
}

@Composable
fun ProductListScreen(
    products: List<Product>,
    totalCount: Int,
    onCartButtonClick: () -> Unit,
    onItemClick: (Product) -> Unit,
    onPlusClick: (Product) -> Unit,
    onMinusClick: (Product) -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        containerColor = Color.White,
        topBar = {
            ProductListTopAppBar(
                count = totalCount,
                onCartButtonClick = onCartButtonClick
            )
        },
    ) { innerPadding ->
        ProductList(
            products = products,
            onItemClick = onItemClick,
            onPlusClick = onPlusClick,
            onMinusClick = onMinusClick,
            modifier = modifier.padding(innerPadding),
        )
    }
}

@Preview(showBackground = true, name = "totalCount 가 0 일 때")
@Composable
private fun P1() {
    val products = DummyProduct.productDummyList

    ProductListScreen(
        products = products,
        totalCount = 0,
        onCartButtonClick = {},
        onItemClick = {},
        onPlusClick = {},
        onMinusClick = {},
    )
}

@Preview(showBackground = true, name = "totalCount 가 2 일 때")
@Composable
private fun P2() {
    val products = DummyProduct.productDummyList

    products[0].count++
    products[1].count++

    ProductListScreen(
        products = products,
        totalCount = products.sumOf { it.count },
        onCartButtonClick = {},
        onItemClick = {},
        onPlusClick = {},
        onMinusClick = {},
    )
}