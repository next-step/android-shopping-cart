package nextstep.shoppingcart.ui.screen.utils.formatter

import java.text.NumberFormat
import java.util.Locale

object DefaultMoneyFormatter : MoneyFormatter {
    override fun format(number: Int): String {
        val formatter = NumberFormat.getNumberInstance(Locale.PRC)
        return formatter.format(number)
    }
}