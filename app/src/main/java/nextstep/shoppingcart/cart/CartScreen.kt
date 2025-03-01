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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.component.CtaButton
import nextstep.shoppingcart.data.Cart
import nextstep.shoppingcart.data.CartItem

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
                items(cartItems) {
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
                    .height(54.dp),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CartScreenPreview() {
    CartScreen(
        cartItems = Cart.items,
        totalPrice = Cart.totalPrice,
        onBackButtonClick = {},
        onDeleteButtonClick = {},
        onMinusButtonClick = {},
        onPlusButtonClick = {},
    )
}