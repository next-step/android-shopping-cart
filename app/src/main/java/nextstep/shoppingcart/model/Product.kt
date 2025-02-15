package nextstep.shoppingcart.model

import java.util.Locale

data class Product(
    val imageUrl: String,
    val name: String,
    val price: Int
) {
    val formattedPrice: String
        get() = String.format(Locale.getDefault(), "%,d원", price)
}
