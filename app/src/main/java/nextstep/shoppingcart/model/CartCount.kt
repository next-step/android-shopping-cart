package nextstep.shoppingcart.model

@JvmInline
value class CartCount(val value: Int) {
    init {
        require(value >= MIN_VALUE) { "담긴 상품 개수는 $MIN_VALUE 이상이어야 한다" }
    }

    operator fun inc() = CartCount(value + 1)
    operator fun dec() = if (value <= MIN_VALUE) CartCount(MIN_VALUE) else CartCount(value - 1)

    companion object {
        private const val MIN_VALUE = 1
        val INIT_COUNT get() = CartCount(MIN_VALUE)
    }
}
