package nextstep.shoppingcart.view.cart

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.view.resource.Blue50
import nextstep.shoppingcart.view.resource.ShoppingCartTheme

@Composable
fun CartButton(
    onButtonClick: () -> Unit,
    text: String,
    fontSize: TextUnit,
    color: ButtonColors,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onButtonClick,
        colors = color,
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.product_detail_button_corner_radius)),
        modifier = modifier.height(dimensionResource(id = R.dimen.product_detail_button_height)),
    ) {
        Text(
            text = text,
            fontSize = fontSize,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CartButtonPreview() {
    ShoppingCartTheme {
        CartButton(
            onButtonClick = {},
            text = "주문하기(1,000원)",
            fontSize = 20.sp,
            color = ButtonDefaults.buttonColors(Blue50)
        )
    }
}
