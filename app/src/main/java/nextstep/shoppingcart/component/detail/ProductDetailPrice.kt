package nextstep.shoppingcart.component.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import java.text.NumberFormat
import java.util.Locale

@Composable
fun ProductDetailPrice(
    price: Long,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(18.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(R.string.product_detail_price),
            style = MaterialTheme.typography.titleLarge,
        )
        Text(
            text = NumberFormat.getNumberInstance(Locale.KOREA).format(price) + "원",
            style = MaterialTheme.typography.titleLarge,
        )
    }
}

@Preview
@Composable
private fun ProductDetailPricePreview() {
    ProductDetailPrice(price = 1_900_000)
}