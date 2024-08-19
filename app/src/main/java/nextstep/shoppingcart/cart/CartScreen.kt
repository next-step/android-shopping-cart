package nextstep.shoppingcart.cart

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.component.NextStepTopAppBar
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.model.dummyProducts

@Composable
internal fun CartScreen(
    products: List<Product>,
    onBackClick: () -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            NextStepTopAppBar(
                title = stringResource(id = R.string.cart_screen_title),
                onBackClick = onBackClick
            )
        },
        content = { paddingValues ->
            CartContent(
                products = products,
                modifier = Modifier
                    .padding(paddingValues = paddingValues)
                    .fillMaxSize()
            )
        }
    )
}

@Composable
private fun CartContent(
    products: List<Product>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(
            items = products,
            key = { item -> item.id }
        ) {
            // TODO: Step2 구현 내용이 아님
        }
    }
}

@Preview
@Composable
private fun CartScreenPreview() {
    CartScreen(
        products = dummyProducts,
        onBackClick = {},
    )
}
