package nextstep.shoppingcart.screen

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.component.ShoppingTopBar

@Composable
fun ShoppingListScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            ShoppingTopBar(
                title = stringResource(id = R.string.shopping_list_title),
                onClickCart = {

                }
            )
        }
    ) { innerPadding ->

    }
}

@Preview(showBackground = true, name = "ShoppingListScreen")
@Composable
private fun Preview1() {
    ShoppingListScreen()
}