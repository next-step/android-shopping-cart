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
    cartItemList: List<CartItem>,
    onMinusCartItemClick: (CartItem) -> Unit,
    onPlusCartItemClick: (CartItem) -> Unit,
    onCartItemDeleteClick: (CartItem) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        CartItemProductList(
            cartItemList = cartItemList,
            modifier = Modifier
                .padding(horizontal = 18.dp)
                .weight(1f),
            onMinusCartItemClick = onMinusCartItemClick,
            onPlusCartItemClick = onPlusCartItemClick,
            onCartItemDeleteClick = onCartItemDeleteClick,
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
    onMinusCartItemClick: (CartItem) -> Unit,
    onPlusCartItemClick: (CartItem) -> Unit,
    onCartItemDeleteClick: (CartItem) -> Unit,
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
                onMinusCartItem = { onMinusCartItemClick(cartItem) },
                onPlusCartItem = { onPlusCartItemClick(cartItem) },
                onCartItemDelete = { onCartItemDeleteClick(cartItem) },
            )
        }
    }
}

@Composable
private fun OrderButton(
    totalMoney: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    formatter: MoneyFormatter = DefaultMoneyFormatter,
) {
    BlueRectangleButton(
        buttonTitle = "${stringResource(id = R.string.cart_order_button)}(${
            formatter.format(
                totalMoney
            )
        }원)",
        modifier = modifier,
        onClick = onClick,
    )
}

@Preview(showBackground = true)
@Composable
private fun CartItemProductListPreview() {
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
        onMinusCartItemClick = { },
        onPlusCartItemClick = { },
        onCartItemDeleteClick = { },
    )
}

@Preview(showBackground = true)
@Composable
private fun OrderButtonPreview() {
    OrderButton(
        totalMoney = 35000,
        onClick = { },
    )
}

@Preview(showBackground = true)
@Composable
private fun ShoppingCartScreenPreview() {
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
        onMinusCartItemClick = { },
        onPlusCartItemClick = { },
        onCartItemDeleteClick = { },
    )
}