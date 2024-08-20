package nextstep.shoppingcart.ui.product.detail.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.Blue50

@Composable
fun ShoppingCartButton(
    modifier: Modifier = Modifier,
    onShowShoppingCart: () -> Unit,
) {
    Button(
        onClick = onShowShoppingCart,
        colors = ButtonDefaults.buttonColors(
            containerColor = Blue50,
            contentColor = Color.White,
        ),
        shape = RectangleShape,
        modifier = modifier
            .fillMaxWidth()
            .height(54.dp),
    ) {
        Text(
            text = stringResource(id = R.string.put_shopping_cart),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Preview
@Composable
private fun ShoppingCartButtonPreview() {
    ShoppingCartButton(onShowShoppingCart = {})
}
