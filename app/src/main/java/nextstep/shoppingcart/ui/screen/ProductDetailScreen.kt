package nextstep.shoppingcart.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.ui.component.BackNavigationTopBar
import nextstep.shoppingcart.ui.component.BottomFullWidthButton
import nextstep.shoppingcart.ui.component.ProductDetail

@Composable
fun ProductDetailScreen(
    product: Product,
    onBackPressed: () -> Unit,
    onAddCardClicked: () -> Unit,
) {
    Scaffold(
        topBar = {
            BackNavigationTopBar(
                title = stringResource(id = R.string.product_detail_title),
                onBackPressed = onBackPressed,
            )
        },
        modifier = Modifier.fillMaxSize(),
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            ProductDetail(
                product = product,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            )
            BottomFullWidthButton(
                label = stringResource(id = R.string.product_detail_add_to_cart),
                onClick = onAddCardClicked,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
            )
        }
    }
}

@Preview
@Composable
private fun ProductDetailScreenPreview() {
    ProductDetailScreen(
        product = Product(
            id = 1,
            name = "Apple",
            price = 1000,
            imageUrl = "https://www.example.com/image"
        ),
        onAddCardClicked = { },
        onBackPressed = { },
    )
}