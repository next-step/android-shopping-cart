package nextstep.shoppingcart.productList

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.data.Product

@Composable
fun ProductListScreen(
    onCartButtonClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val products = List(10) {
        Product(
            "상품이름",
            "https://images.mypetlife.co.kr/content/uploads/2023/03/30102633/AdobeStock_297354202-1024x683.jpeg",
            10_000
        )
    }

    Scaffold(
        containerColor = Color.White,
        topBar = {
            ProductListTopAppBar(onCartButtonClick = onCartButtonClick)
        }
    ) { innerPadding ->
        ProductList(
            products = products,
            modifier = modifier.padding(innerPadding)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductListScreenPreview() {
    ProductListScreen()
}