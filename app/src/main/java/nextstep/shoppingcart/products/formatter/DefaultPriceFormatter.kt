package nextstep.shoppingcart.products.formatter

import java.text.DecimalFormat
import java.text.NumberFormat

object DefaultPriceFormatter : PriceFormatter {
    private val formatter: NumberFormat = DecimalFormat("#,###")

    override fun format(price: Int): String {
        val formattedNumber: String = formatter.format(price)
        return "${formattedNumber}원"
    }
}
