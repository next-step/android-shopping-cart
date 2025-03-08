package nextstep.shoppingcart.productList

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.data.Cart
import nextstep.shoppingcart.data.DummyProduct
import nextstep.shoppingcart.data.Product

@Composable
fun ProductListScreen(
    productAndCountList: List<Pair<Product, Int>>,
    totalCount: Int,
    onCartButtonClick: () -> Unit,
    onItemClick: (Product) -> Unit,
    onPlushClick: (Product) -> Unit,
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
            productAndCountList = productAndCountList,
            onItemClick = onItemClick,
            onPlusClick = onPlushClick,
            onMinusClick = onMinusClick,
            modifier = modifier.padding(innerPadding),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductListScreenPreview() {
    val productAndCountList = DummyProduct.productDummyList.map {
        it to (Cart.getCartCount(it))
    }

    ProductListScreen(
        productAndCountList = productAndCountList,
        totalCount = 0,
        onCartButtonClick = {},
        onItemClick = {},
        onPlushClick = {},
        onMinusClick = {},
    )
}