package nextstep.shoppingcart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.component.cart.CartCounterTextButton
import nextstep.shoppingcart.component.cart.CartProductItem
import nextstep.shoppingcart.component.cart.CartTopBar
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product
import java.text.NumberFormat
import java.util.Locale

@Composable
fun ShoppingCartScreen(
    cartItem: List<CartItem>,
    onItemCloseClick: (Product) -> Unit,
    onItemMinusClick: (Product) -> Unit,
    onItemPlusClick: (Product) -> Unit,
    onOrderClick: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    ) {
    Scaffold(
        modifier = modifier,
        topBar = {
            CartTopBar(
                onBackClick = onBackClick
            )
        },
        bottomBar = {
            CartCounterTextButton(
                text = "주문하기(${
                    NumberFormat.getNumberInstance(Locale.KOREA)
                        .format(cartItem.sumOf { it.totalPrice })
                }원)",
                onClick = onOrderClick
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .fillMaxSize()
                .semantics {
                    contentDescription = "shoppingCartList"
                },
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
            items(
                items = cartItem,
            ){
                CartProductItem(
                    cartItem = it,
                    onCloseClick = { onItemCloseClick(it.product) },
                    onPlusClick = { onItemPlusClick(it.product) },
                    onMinusClick = { onItemMinusClick(it.product) }
                )
            }
        }

    }
}


@Preview
@Composable
private fun ShoppingCartScreenPreview() {
    ShoppingCartScreen(cartItem = listOf(
        CartItem(
            product = Product(
                name = "iPhone 15 Pro Max",
                imageUrl = "https://img.danawa.com/prod_img/500000/334/189/img/28189334_1.jpg",
                price = 1_900_000
            ),
            count = 1
        ),
        CartItem(
            product = Product(
                name = "iPhone 15 Pro Max",
                imageUrl = "https://img.danawa.com/prod_img/500000/334/189/img/28189334_1.jpg",
                price = 1_900_000
            ),
            count = 2
        ),
        CartItem(
            product = Product(
                name = "iPhone 15 Pro Max",
                imageUrl = "https://img.danawa.com/prod_img/500000/334/189/img/28189334_1.jpg",
                price = 1_900_000
            ),
            count = 3
        )
    ),
        onItemCloseClick = {},
        onItemMinusClick = {},
        onItemPlusClick = {},
        onOrderClick = {},
        onBackClick = {},
        )
}