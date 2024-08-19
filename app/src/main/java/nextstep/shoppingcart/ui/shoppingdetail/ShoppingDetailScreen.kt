package nextstep.shoppingcart.ui.shoppingdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.component.ShoppingProductImage
import nextstep.shoppingcart.ui.component.ShoppingTopBar
import nextstep.shoppingcart.ui.shoppinglist.model.dummyProducts
import nextstep.shoppingcart.ui.theme.RobotoBold

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
        Text(
            text = product.name,
            color = Color.Black,
            fontSize = 24.sp,
            fontFamily = RobotoBold,
            maxLines = 1,
            modifier = Modifier.padding(18.dp),
        )
        Divider(
            modifier = Modifier
                .height(2.dp)
                .background(Color.Gray),
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
        ) {
            Text(text = "금액")
            Text(text = product.price.toString())
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(0.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "장바구니 담기")
        }
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
