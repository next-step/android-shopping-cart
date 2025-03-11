package nextstep.shoppingcart.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.component.CtaButton
import nextstep.shoppingcart.data.Cart
import nextstep.shoppingcart.data.CartItem
import nextstep.shoppingcart.data.DummyProduct

@Composable
fun CartScreen(
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val onBackButtonClick: () -> Unit = {
        if (context is CartActivity) {
            context.finish()
        }
    }
    val onDeleteButtonClick: (CartItem) -> Unit = { cartItem ->
        Cart.removeAll(cartItem.product)
    }

    val onMinusButtonClick: (CartItem) -> Unit = { cartItem ->
        Cart.removeOne(cartItem.product)
    }

    val onPlusButtonClick: (CartItem) -> Unit = { cartItem ->
        Cart.addOne(cartItem.product)
    }

    CartScreen(
        cartItems = Cart.items.toList(),
        totalPrice = Cart.totalPrice,
        onBackButtonClick = onBackButtonClick,
        onDeleteButtonClick = onDeleteButtonClick,
        onMinusButtonClick = onMinusButtonClick,
        onPlusButtonClick = onPlusButtonClick,
        modifier = modifier,
    )
}


@Composable
fun CartScreen(
    cartItems: List<CartItem>,
    totalPrice: Int,
    onBackButtonClick: () -> Unit,
    onDeleteButtonClick: (CartItem) -> Unit,
    onMinusButtonClick: (CartItem) -> Unit,
    onPlusButtonClick: (CartItem) -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            CartTopAppBar(onBackButtonClick = onBackButtonClick)
        },
        containerColor = Color.White,
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
        ) {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(),
                contentPadding = PaddingValues(horizontal = 18.dp, vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                items(
                    items = cartItems,
                    key = { it.product.id },
                ) {
                    CartProduct(
                        cartItem = it,
                        onDeleteButtonClick = onDeleteButtonClick,
                        onMinusButtonClick = onMinusButtonClick,
                        onPlusButtonClick = onPlusButtonClick,
                    )
                }
            }

            CtaButton(
                text = stringResource(R.string.order, totalPrice),
                onClick = { /* TODO 주문하기 */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp)
                    .testTag("orderButton"),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CartScreenPreview() {
    val cartItems = listOf(
        CartItem(DummyProduct.product1, 1),
        CartItem(DummyProduct.product2, 2),
        CartItem(DummyProduct.product3, 3),
    )

    val totalPrice = cartItems.sumOf { it.product.price * it.count }

    CartScreen(
        cartItems = cartItems,
        totalPrice = totalPrice,
        onBackButtonClick = {},
        onDeleteButtonClick = {},
        onMinusButtonClick = {},
        onPlusButtonClick = {},
    )
}