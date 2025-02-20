package nextstep.shoppingcart.ui.screen.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R

@Composable
fun QuantityAdjustContainer(
    count: Int,
    modifier: Modifier = Modifier,
    onMinusCartItemClick: () -> Unit,
    onPlusCartItemClick: () -> Unit,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        QuantityAdjusButton(
            buttonTitle = stringResource(id = R.string.cart_minus_item_button),
            onClick = onMinusCartItemClick,
        )
        Text(
            text = count.toString(),
            fontSize = 22.sp,
            fontWeight = FontWeight.W400,
        )
        QuantityAdjusButton(
            buttonTitle = stringResource(id = R.string.cart_plus_item_button),
            onClick = onPlusCartItemClick,
        )
    }
}

@Composable
private fun QuantityAdjusButton(
    buttonTitle: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    IconButton(
        modifier = modifier
            .clip(RoundedCornerShape(4.dp))
            .padding(4.dp),
        onClick = onClick
    ) {
        Text(
            text = buttonTitle,
            fontSize = 16.sp,
            fontWeight = FontWeight.W700,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CartQuantitySectorPreview() {
    QuantityAdjustContainer(
        count = 2,
        onMinusCartItemClick = {

        },
        onPlusCartItemClick = {

        },
    )
}

@Preview(showBackground = true)
@Composable
private fun QuantityAdjusButtonPreview() {
    QuantityAdjusButton(
        buttonTitle = "+",
        onClick = {

        },
    )
}