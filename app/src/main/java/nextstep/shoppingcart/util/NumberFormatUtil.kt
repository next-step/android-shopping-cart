package nextstep.shoppingcart.util

import java.text.DecimalFormat

object NumberFormatUtil {

    fun Int.toPrice(): String = DecimalFormat("#,###").format(this) + "원"
}