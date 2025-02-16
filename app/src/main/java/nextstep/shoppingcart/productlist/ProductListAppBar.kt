package nextstep.shoppingcart.productlist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductListAppBar(
    modifier: Modifier = Modifier,
    onCartClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(64.dp)
            .background(color = Color.White)
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = stringResource(R.string.product_list),
            style = MaterialTheme.typography.titleLarge
        )
        Box(
            modifier = Modifier
                .padding(end = 8.dp)
                .size(48.dp)
                .align(Alignment.CenterEnd)
                .clickable(onClick = onCartClick),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = stringResource(R.string.shopping_cart)
            )
        }
    }
}

@Preview
@Composable
private fun ProductListAppBarPreview() {
    ShoppingCartTheme {
        ProductListAppBar()
    }
}

