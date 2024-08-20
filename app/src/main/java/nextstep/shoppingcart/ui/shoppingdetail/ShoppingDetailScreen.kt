package nextstep.shoppingcart.ui.shoppingdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R.string.shopping_detail_add_button
import nextstep.shoppingcart.R.string.shopping_detail_title
import nextstep.shoppingcart.data.Cart.findProductById
import nextstep.shoppingcart.ui.component.ShoppingButton
import nextstep.shoppingcart.ui.component.ShoppingProductImage
import nextstep.shoppingcart.ui.component.ShoppingTopBar
import nextstep.shoppingcart.ui.shoppingdetail.component.ShoppingDetailDivider
import nextstep.shoppingcart.ui.shoppingdetail.component.ShoppingDetailProductPrice
import nextstep.shoppingcart.ui.shoppingdetail.component.ShoppingDetailProductTitle

@Composable
fun ShoppingDetailScreen(
    productId: Long,
    onBackClick: () -> Unit,
    onAddClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.fillMaxSize()) {
        val product = findProductById(productId)
        val screenTitle = stringResource(id = shopping_detail_title)

        ShoppingTopBar(
            title = screenTitle,
            onBackClick = onBackClick,
        )
        ShoppingProductImage(
            product = product,
            modifier = modifier
                .width(width = 360.dp)
                .height(height = 360.dp),
        )
        ShoppingDetailProductTitle(product = product)
        ShoppingDetailDivider()
        ShoppingDetailProductPrice(product = product)
        Spacer(modifier = Modifier.weight(weight = 1f))
        ShoppingButton(
            onClick = onAddClick,
            buttonTitle = stringResource(id = shopping_detail_add_button),
        )
    }
}

@Preview
@Composable
private fun ShoppingDetailScreenPreview() {
    ShoppingDetailScreen(
        productId = 0,
        onBackClick = {},
        onAddClick = {},
        modifier = Modifier.background(color = Color.White),
    )
}
