package nextstep.shoppingcart.ui.cart.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R

@Composable
fun CartBottomBar(modifier: Modifier = Modifier, totalPrice: Int, onClickBottomBar: () -> Unit) {
    BottomAppBar(
        modifier
            .fillMaxWidth()
            .clickable(onClick = onClickBottomBar),
        containerColor = Color(0xFF2196F3)
    ) {
        Text(
            text = "${stringResource(id = R.string.text_shopping_cart_order)}(${
                stringResource(
                    id = R.string.formatted_price,
                    totalPrice
                )
            })",
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color.White,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
        )
    }
}


@Preview
@Composable
private fun CartBottomBarPreview() {
    CartBottomBar(Modifier, 1000 ,{})
}