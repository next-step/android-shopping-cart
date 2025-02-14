package nextstep.shoppingcart.domain.model

class Products(initialProducts: List<Product>) {
    private val _value: MutableList<Product> = initialProducts.toMutableList()
    val value: List<Product> get() = _value.toList()

    constructor(vararg initialProducts: Product): this(initialProducts.toList())

    fun getProductByIdOrNull(id: Int): Product? {
        return _value.firstOrNull { it.id == id }
    }
}
