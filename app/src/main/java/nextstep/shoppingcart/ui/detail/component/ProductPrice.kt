package nextstep.shoppingcart.ui.detail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.designsystem.theme.TextColor
import nextstep.shoppingcart.ext.getFormattedPrice
import nextstep.shoppingcart.model.Product


@Composable
fun ProductPrice(
    item: Product,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(18.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(R.string.price_content),
            fontSize = 20.sp,
            color = TextColor
        )

        Text(
            text = stringResource(R.string.price, item.price.getFormattedPrice()),
            fontSize = 20.sp,
            color = TextColor
        )
    }
}