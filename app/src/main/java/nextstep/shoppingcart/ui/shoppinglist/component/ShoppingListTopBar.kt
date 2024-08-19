package nextstep.shoppingcart.ui.shoppinglist.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.RobotoRegular

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingListTopBar(
    title: String,
    onShoppingCartClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val shoppingListTopBarIcon = stringResource(R.string.shopping_list_top_bar_icon)

    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                fontSize = 22.sp,
                fontFamily = RobotoRegular,
                modifier = Modifier.padding(vertical = 18.dp),
            )
        },
        actions = {
            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = shoppingListTopBarIcon,
                modifier = Modifier
                    .padding(14.dp)
                    .clickable { onShoppingCartClick() }
                    .semantics { contentDescription = shoppingListTopBarIcon },
            )
        },
        modifier = modifier,
    )
}

@Preview
@Composable
private fun ShoppingCartTopBarPreview() {
    ShoppingListTopBar(
        title = "상품 목록",
        onShoppingCartClick = {},
    )
}
