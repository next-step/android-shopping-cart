package nextstep.shoppingcart.util

import java.text.DecimalFormat

object NumberFormatUtil {
    fun Int.toCommaFormat(): String = DecimalFormat("#,###").format(this)
    fun Int.toPrice(): String = toCommaFormat() + "원"
}
