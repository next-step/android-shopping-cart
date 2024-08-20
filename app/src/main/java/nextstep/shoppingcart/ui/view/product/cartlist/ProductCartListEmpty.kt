package nextstep.shoppingcart.ui.view.product.cartlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R

@Composable
fun ProductCartListEmpty(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(48.dp),
            imageVector = Icons.Filled.ShoppingCart,
            contentDescription = stringResource(R.string.product_cart_list_empty_icon)
        )
        Spacer(modifier = Modifier.size(16.dp))
        Text(text = stringResource(R.string.product_cart_list_empty_message))
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductCartListEmptyPreview() {
    ProductCartListEmpty()
}
