package nextstep.shoppingcart.ui.shoppingdetail.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.ui.shoppinglist.model.Product
import nextstep.shoppingcart.ui.shoppinglist.model.dummyProducts
import nextstep.shoppingcart.ui.theme.RobotoBold

@Composable
fun ShoppingDetailProductTitle(product: Product) {
    Text(
        text = product.name,
        color = Color.Black,
        fontSize = 24.sp,
        fontFamily = RobotoBold,
        maxLines = 1,
        modifier = Modifier.padding(all = 18.dp),
    )
}

@Preview
@Composable
private fun ShoppingDetailProductTitlePreview() {
    ShoppingDetailProductTitle(product = dummyProducts[0])
}
