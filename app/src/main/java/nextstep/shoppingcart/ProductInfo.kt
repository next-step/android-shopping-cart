package nextstep.shoppingcart

import java.text.NumberFormat
import java.util.Locale

data class Product(
    val imageUrl: String,
    val name: String,
    val price: Int,
) {
    val formattedPrice: String
        get() = NumberFormat.getNumberInstance(Locale.US).format(price) + "원"

}
