package nextstep.shoppingcart.ui.shoppinglist.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.RobotoRegular

@Composable
fun ShoppingListTopBar(
    title: String,
    modifier: Modifier = Modifier,
) {
    val shoppingListTopBarDescription = stringResource(R.string.shopping_list_top_bar_description)

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .semantics { contentDescription = shoppingListTopBarDescription },
    ) {
        Spacer(modifier = Modifier.weight(1.5f))
        Text(
            text = title,
            fontSize = 22.sp,
            fontFamily = RobotoRegular,
            modifier = Modifier.padding(vertical = 18.dp),
        )
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.Filled.ShoppingCart,
            contentDescription = stringResource(R.string.shopping_list_top_bar_icon),
            modifier = Modifier
                .padding(14.dp)
                .clickable {
                    // navigateToShoppingCart
                },
        )
        Spacer(modifier = Modifier.width(4.dp))
    }
}

@Preview
@Composable
private fun ShoppingCartTopBarPreview() {
    ShoppingListTopBar(title = "상품 목록")
}
