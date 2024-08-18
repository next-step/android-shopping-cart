package nextstep.shoppingcart.ui.productList.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import nextstep.shoppingcart.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListTopBar(modifier: Modifier = Modifier, onClickCartIcon: () -> Unit) {
    TopAppBar(
        modifier = modifier
            .background(Color.White)
            .fillMaxWidth(),
        title = {
            Text(
                modifier = modifier.fillMaxWidth(),
                text = stringResource(id = R.string.text_product_list_title),
                textAlign = TextAlign.Center
            )
        },
        actions = {
            IconButton(onClick = onClickCartIcon) {
                Icon(
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = stringResource(id = R.string.text_shopping_cart_Icon_description)
                )
            }
        }
    )
}
