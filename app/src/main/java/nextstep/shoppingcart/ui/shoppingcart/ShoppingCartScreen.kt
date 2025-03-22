package nextstep.shoppingcart.ui.shoppingcart

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import nextstep.shoppingcart.data.ShoppingCartPreviewParameterProvider
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.ui.BottomButton
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ShoppingCartScreen(
    modifier: Modifier = Modifier,
    products: List<CartItem> = emptyList(),
    totalPrice: Int = 0,
    onBackClick: () -> Unit = {},
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            ShoppingCartTopAppBar(onBackClick = onBackClick)
        },
        bottomBar = {
            BottomButton(
                text = if (totalPrice > 0) "주문하기(${totalPrice}원)" else "주문하기"
            )
        }
//        containerColor = Color.White
    ) { paddingValues ->
        Surface(
            modifier = modifier.padding(paddingValues),
            contentColor = Color.White
        ) {
            LazyColumn {
                items(items = products) { product ->
                    CartItem(
                        product = product,
                        quantity = 2,
                        onQuantityChange = {},
                        onRemove = {}
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun ShoppingCartScreenPreview(
    @PreviewParameter(ShoppingCartPreviewParameterProvider::class) items: List<CartItem>
) {
    ShoppingCartTheme {
        ShoppingCartScreen(
            products = products,
        )
    }
}