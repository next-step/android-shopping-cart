package nextstep.shoppingcart.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.model.products
import nextstep.shoppingcart.view.ProductsList

@Composable
fun ProductsScreen(
    onClickCart: () -> Unit,
    onClickProductItem: (Product) -> Unit
) {
    Scaffold(
        topBar = {
            ProductsTopBar(
                onClickCart = onClickCart
            )
        }
    ) { innerPadding ->
        ProductsList(
            products = products,
            onClickProductItem = onClickProductItem,
            modifier = Modifier
                .padding(innerPadding)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ProductsTopBar(
    onClickCart: () -> Unit,
    modifier: Modifier = Modifier,
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.products_top_bar_title),
                fontSize = 22.sp,
                textAlign = TextAlign.Center,
            )
        },
        actions = {
            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "shooping cart",
                modifier = Modifier
                    .clickable {
                        onClickCart()
                    }
            )
        },
        modifier = modifier
            .padding(horizontal = 16.dp)
    )
}