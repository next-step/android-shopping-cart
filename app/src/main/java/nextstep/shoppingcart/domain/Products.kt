package nextstep.shoppingcart.domain

class Products(initialProducts: List<Product>) {
    private val _value: MutableList<Product> = initialProducts.toMutableList()
    val value: List<Product> get() = _value.toList()

    constructor(vararg initialProducts: Product): this(initialProducts.toList())
}
