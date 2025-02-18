package nextstep.shoppingcart.ext

import java.util.Locale



fun Int.getFormattedPrice(): String {
    return String.format(Locale.getDefault(), "%,d", this)
}
