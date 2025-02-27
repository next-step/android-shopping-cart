package nextstep.shoppingcart.util

import java.text.DecimalFormat

val numberMoneyFormat = DecimalFormat("#,###")

fun translateNumberMoneyFormat(price: Int): String {
    return numberMoneyFormat.format(price) + "원"
}
