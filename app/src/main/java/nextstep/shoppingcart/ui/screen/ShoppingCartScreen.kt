package nextstep.shoppingcart.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.CartItem
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.repository.CartRepository
import nextstep.shoppingcart.ui.screen.component.BlueRectangleButton
import nextstep.shoppingcart.ui.screen.component.CartItemContainer
import nextstep.shoppingcart.ui.utils.formatter.DefaultMoneyFormatter
import nextstep.shoppingcart.ui.utils.formatter.MoneyFormatter

@Composable
fun ShoppingCartScreen(
    modifier: Modifier = Modifier,
    cartItemList: List<CartItem>,
    onMinusCartItem: (CartItem) -> Unit,
    onPlusCartItem: (CartItem) -> Unit,
    onCartItemDelete: (CartItem) -> Unit,
) {
    Column(
        modifier = modifier,
    ) {
        CartItemProductList(
            cartItemList = cartItemList,
            onMinusCartItem = onMinusCartItem,
            onPlusCartItem = onPlusCartItem,
            onCartItemDelete = onCartItemDelete,
            modifier = Modifier
                .padding(horizontal = 18.dp)
                .weight(1f),
        )
        OrderButton(
            totalMoney = CartRepository.totalPrice,
            onClick = { },
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Composable
private fun CartItemProductList(
    cartItemList: List<CartItem>,
    onMinusCartItem: (CartItem) -> Unit,
    onPlusCartItem: (CartItem) -> Unit,
    onCartItemDelete: (CartItem) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 16.dp),
    ) {
        items(cartItemList) { cartItem ->
            CartItemContainer(
                cartItem = cartItem,
                onMinusCartItem = { onMinusCartItem(cartItem) },
                onPlusCartItem = { onPlusCartItem(cartItem) },
                onCartItemDelete = { onCartItemDelete(cartItem) },
            )
        }
    }
}

@Composable
private fun OrderButton(
    totalMoney: Int,
    onClick: () -> Unit,
    formatter: MoneyFormatter = DefaultMoneyFormatter,
    modifier: Modifier = Modifier,
) {
    BlueRectangleButton(
        buttonTitle = "${stringResource(id = R.string.cart_order_button)}(${
            formatter.format(
                totalMoney
            )
        }원)",
        onClick = onClick,
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun CartItemProductListPreview() {
    CartItemProductList(
        cartItemList = listOf(
            CartItem(
                product = Product(
                    imageUrl = "https://picsum.photos/200/300",
                    title = "개꿀아이템1",
                    price = 10000,
                ),
                count = 2,
            ),
            CartItem(
                product = Product(
                    imageUrl = "https://picsum.photos/200/300",
                    title = "개꿀아이템2",
                    price = 20000,
                ),
                count = 1,
            ),
        ),
        onMinusCartItem = { },
        onPlusCartItem = { },
        onCartItemDelete = { },
    )
}

@Preview(showBackground = true)
@Composable
fun OrderButtonPreview() {
    OrderButton(
        totalMoney = 35000,
        onClick = { },
    )
}

@Preview(showBackground = true)
@Composable
fun ShoppingCartScreenPreview() {
    ShoppingCartScreen(
        cartItemList = listOf(
            CartItem(
                product = Product(
                    imageUrl = "https://picsum.photos/200/300",
                    title = "개꿀아이템1",
                    price = 10000,
                ),
                count = 2,
            ),
            CartItem(
                product = Product(
                    imageUrl = "https://picsum.photos/200/300",
                    title = "개꿀아이템2",
                    price = 20000,
                ),
                count = 1,
            ),
        ),
        onMinusCartItem = { },
        onPlusCartItem = { },
        onCartItemDelete = { },
    )
}