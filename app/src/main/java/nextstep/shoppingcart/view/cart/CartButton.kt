package nextstep.shoppingcart.view.cart

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.view.resource.Blue50
import nextstep.shoppingcart.view.resource.ShoppingCartTheme

@Composable
fun CartButton(onButtonClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onButtonClick,
        colors = ButtonDefaults.buttonColors(Blue50),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.product_detail_button_corner_radius)),
        modifier = modifier.height(dimensionResource(id = R.dimen.product_detail_button_height)),
    ) {
        Text(
            text = stringResource(id = R.string.cart_button, 10000),
            fontSize = dimensionResource(id = R.dimen.product_detail_button_text_size).value.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CartButtonPreview() {
    ShoppingCartTheme {
        CartButton(onButtonClick = {})
    }
}
