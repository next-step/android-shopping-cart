package nextstep.shoppingcart.ui.cart

import android.app.Activity
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.SampleProductList
import nextstep.shoppingcart.data.cart.Cart
import nextstep.shoppingcart.ui.cart.component.CartBottomBar
import nextstep.shoppingcart.ui.cart.component.CartCard
import nextstep.shoppingcart.ui.cart.component.CartTopBar

@Composable
fun CartScreen(modifier: Modifier) {
    val context = LocalContext.current

    var items by remember { mutableStateOf(Cart.items) }
    val totalPrice = remember(items) { Cart.totalPrice }

    Scaffold(
        topBar = {
            CartTopBar(
                modifier = modifier,
                onClickBackIcon = { (context as? Activity)?.finish() })
        },
        bottomBar = {
            CartBottomBar(
                modifier = modifier,
                totalPrice = totalPrice,
                onClickBottomBar = {})
        }
    ) { paddingValue ->
        LazyColumn(
            modifier = modifier
                .padding(paddingValue)
                .testTag(stringResource(id = R.string.test_tag_cart_lazy_column))
        ) {
            items(items) { item ->
                CartCard(
                    cartItem = item,
                    modifier = modifier,
                    onMinusClick = { product -> items = Cart.removeOne(product) },
                    onPlusClick = { product -> items = Cart.addOne(product) },
                    onRemoveClick = { cartItem -> items = Cart.removeAll(cartItem.product) }
                )
            }
        }
    }
}

@Preview
@Composable
private fun CardScreenPreview() {
    Cart.addOne(product = SampleProductList.sampleProductList[0])
    CartScreen(Modifier)
}