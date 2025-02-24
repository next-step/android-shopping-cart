package nextstep.shoppingcart.model

import java.text.DecimalFormat

data class Product(
    val name: String,
    val imageUrl: String,
    val price: Int,
    val productId: String
) {
    val formattedPrice: String
        get() = numberMoneyFormat.format(price) + "원"

}

private val numberMoneyFormat = DecimalFormat("#,###")
