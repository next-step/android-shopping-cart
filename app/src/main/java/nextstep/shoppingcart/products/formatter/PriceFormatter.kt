package nextstep.shoppingcart.products.formatter

fun interface PriceFormatter {
    fun format(price: Int): String
}
