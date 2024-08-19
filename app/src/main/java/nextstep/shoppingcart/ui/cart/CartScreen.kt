package nextstep.shoppingcart.ui.cart

import android.app.Activity
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
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
    Scaffold(
        topBar = {
            CartTopBar(modifier, onClickBackIcon = { (context as? Activity)?.finish() })
        }
    ) { paddingValue ->
        LazyColumn(
            modifier = modifier.padding(paddingValue)
        ) {
            items(Cart.items) { item ->
                CartCard(modifier, item.product)
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