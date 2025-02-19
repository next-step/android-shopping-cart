package nextstep.shoppingcart.ui.cart

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.designsystem.theme.ShoppingCartTheme
import nextstep.shoppingcart.designsystem.theme.TopBarTextColor
import nextstep.shoppingcart.util.CartUtil

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(
    modifier: Modifier = Modifier,
    onBack: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.cart_title),
                        fontSize = 22.sp,
                        color = TopBarTextColor,
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "back_icon"
                        )
                    }
                }
            )
        },
        modifier = modifier.fillMaxSize()
    ) { contentPadding ->
        CartListScreen(
            items = CartUtil.items,
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize(),
            onDelete = { item ->
                CartUtil.removeAll(item.product)
            },
            onAdd = { item ->
                CartUtil.addOne(item.product)
            },
            onRemove = { item ->
                CartUtil.removeOne(item.product)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CartScreenPreview() {
    ShoppingCartTheme {
        CartScreen()
    }
}