package nextstep.shoppingcart.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.component.CartItem
import nextstep.shoppingcart.component.topbar.ShoppingTopBarWithBack
import nextstep.shoppingcart.model.productList
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingCartScreen(
    onClickBack : () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            ShoppingTopBarWithBack(
                title = stringResource(id = R.string.shopping_cart_title),
                onClickBack = onClickBack
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding),
            contentPadding = PaddingValues(
                horizontal = 18.dp,
                vertical = 16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
            item {
                CartItem(
                    product = productList[1],
                    onClickPlus = {

                    },
                    onClickMinus = {

                    },
                    onClickClose = {

                    }
                )
            }
        }

    }
}

@Preview(name = "ShoppingCartScreen")
@Composable
private fun Preview1() {
    ShoppingCartTheme {
        ShoppingCartScreen(
            onClickBack = {}
        )
    }
}