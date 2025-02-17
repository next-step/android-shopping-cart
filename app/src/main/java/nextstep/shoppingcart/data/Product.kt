package nextstep.shoppingcart.data

import java.util.Locale

data class Product(
    val imageUrl: String,
    val name: String,
    val price: Int,
) {
    val formattedPrice: String
        get() = String.format(Locale.KOREA, "%,d원", price)
}