package nextstep.shoppingcart.model.product

import java.text.DecimalFormat

data class Product(
    val name: String,
    val imageUrl: String,
    val price: String,
    val productId: String
) {
    val formattedPrice: String
        get() = numberMoneyFormat.format(price.toInt()) + "원"

}

val numberMoneyFormat = DecimalFormat("#,###")
