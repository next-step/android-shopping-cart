package nextstep.shoppingcart.ui.theme.shopping.model

import java.text.DecimalFormat

data class Product(
    val name: String,
    val imageUrl: String,
    val price: String,
    val link: String
) {
    val formattedPrice: String
        get() = numberMoneyFormat.format(price.toInt()) + "원"

}

val numberMoneyFormat = DecimalFormat("#,###")