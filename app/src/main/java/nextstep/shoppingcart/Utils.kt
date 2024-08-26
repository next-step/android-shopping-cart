package nextstep.shoppingcart

import java.text.NumberFormat
import java.util.Locale

object Utils {
    fun formatPrice(price: Long): String {
        return NumberFormat.getCurrencyInstance(Locale.KOREA).format(price)
    }
}
