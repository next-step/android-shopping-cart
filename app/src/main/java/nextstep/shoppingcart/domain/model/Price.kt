package nextstep.shoppingcart.domain.model

@JvmInline
value class Price private constructor(val value: Int) {
    companion object {
        private const val MINIMUM_VALUE = 0

        fun of(value: Int): Price {
            return Price(value.coerceAtLeast(MINIMUM_VALUE))
        }
    }
}
