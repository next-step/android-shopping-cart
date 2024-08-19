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
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.data.SampleProductList
import nextstep.shoppingcart.data.cart.Cart
import nextstep.shoppingcart.ui.cart.component.CartCard
import nextstep.shoppingcart.ui.cart.component.CartTopBar

@Composable
fun CartScreen(modifier: Modifier) {
    val context = LocalContext.current
    var items by remember { mutableStateOf(Cart.items) }

    Scaffold(
        topBar = {
            CartTopBar(modifier, onClickBackIcon = { (context as? Activity)?.finish() })
        }
    ) { paddingValue ->
        LazyColumn(
            modifier = modifier.padding(paddingValue)
        ) {
            items(items) { item ->
                CartCard(
                    modifier,
                    item,
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