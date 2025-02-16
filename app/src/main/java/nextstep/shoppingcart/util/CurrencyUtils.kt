package nextstep.shoppingcart.util

import java.text.NumberFormat
import java.util.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import nextstep.shoppingcart.R

@Composable
fun formatCurrency(amount: Int): String {
    val formattedAmount = NumberFormat.getNumberInstance(Locale.KOREA).format(amount)
    return "$formattedAmount ${stringResource(R.string.currency_unit)}"
}
