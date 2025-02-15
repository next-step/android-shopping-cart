package nextstep.shoppingcart.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R

@Composable
fun ProductsScreen() {
    Scaffold(
        topBar = {
            ProductsTopBar()
        }
    ) { innerPadding ->
        ProductsList(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Preview
@Composable
private fun ProductsTopBar(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(64.dp)
            .padding(horizontal = 16.dp),
    ) {
        Text(
            text = stringResource(id = R.string.products_top_bar_title),
            fontSize = 22.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
        )
        Icon(
            imageVector = Icons.Filled.ShoppingCart,
            contentDescription = "shooping cart",
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .clickable { }
        )
    }
}

@Composable
private fun ProductsList(
    modifier: Modifier = Modifier
) {

}

@Composable
private fun ProductsItem() {

}