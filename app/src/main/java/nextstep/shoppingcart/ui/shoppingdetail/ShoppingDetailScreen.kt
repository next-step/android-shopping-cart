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
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.component.ShoppingProductImage
import nextstep.shoppingcart.ui.component.ShoppingTopBar
import nextstep.shoppingcart.ui.shoppingdetail.component.ShoppingDetailDivider
import nextstep.shoppingcart.ui.shoppingdetail.component.ShoppingDetailProductAddButton
import nextstep.shoppingcart.ui.shoppingdetail.component.ShoppingDetailProductPrice
import nextstep.shoppingcart.ui.shoppingdetail.component.ShoppingDetailProductTitle
import nextstep.shoppingcart.ui.shoppinglist.model.dummyProducts

@Composable
fun ShoppingDetailScreen(
    productId: Long,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.fillMaxSize()) {
        val product = dummyProducts.find { it.id == productId } ?: throw IllegalArgumentException()
        val screenTitle = stringResource(R.string.shopping_detail_title)

        ShoppingTopBar(
            title = screenTitle,
            onBackClick = onBackClick,
        )
        ShoppingProductImage(
            product = product,
            modifier = modifier
                .width(360.dp)
                .height(360.dp),
        )
        ShoppingDetailProductTitle(product = product)
        ShoppingDetailDivider()
        ShoppingDetailProductPrice(product = product)
        Spacer(modifier = Modifier.weight(1f))
        ShoppingDetailProductAddButton({})
    }
}


@Preview
@Composable
private fun ShoppingDetailScreenPreview() {
    ShoppingDetailScreen(
        productId = 0,
        onBackClick = {},
        modifier = Modifier.background(Color.White)
    )
}
