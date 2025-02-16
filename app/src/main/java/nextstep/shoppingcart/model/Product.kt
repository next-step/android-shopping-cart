package nextstep.shoppingcart.model

import java.util.Locale

data class Product(
    val id: Int,
    val name: String,
    val price: Int,
    val imageUrl: String,
) {

    fun getFormattedPrice(): String {
        return String.format(Locale.getDefault(), "%,d", price)
    }

}
