package nextstep.shoppingcart.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Cart
import nextstep.shoppingcart.model.CartProductModel
import nextstep.shoppingcart.model.dummyCartProductList
import nextstep.shoppingcart.ui.component.ActionButton
import nextstep.shoppingcart.ui.component.CartProduct
import nextstep.shoppingcart.ui.component.ShoppingCartTopBar
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductCartScreen(
    items: List<CartProductModel>,
    onBackButtonClick: () -> Unit,
) {
    val totalPrice by remember(items) { mutableIntStateOf(Cart.totalPrice) }
    val enableOrder by remember(items) { mutableStateOf(Cart.totalPrice > 0) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            ShoppingCartTopBar(
                titleResId = R.string.cart,
                isCenter = false,
                onClickBack = onBackButtonClick,
            )
        }
    ) { innerPadding ->


        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .testTag("productCartLazyColumn"),
                contentPadding = PaddingValues(18.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(
                    items = items,
                    key = { model -> model.id }
                ) { model ->
                    CartProduct(
                        model = model,
                    )
                }
            }


            ActionButton(
                text = stringResource(
                    R.string.order_with_total_price,
                    stringResource(R.string.korean_price_format, totalPrice)
                ),
                enabled = enableOrder,
                onClick = {},
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ProductListScreenPreview() {
    ShoppingCartTheme {
        ProductCartScreen(
            items = dummyCartProductList,
            onBackButtonClick = {},
        )
    }
}