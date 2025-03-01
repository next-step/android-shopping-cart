package nextstep.shoppingcart.utils

import java.util.Locale

fun Int.formatPrice(): String {
    return String.format(Locale.getDefault(), "%,d원", this)
}
