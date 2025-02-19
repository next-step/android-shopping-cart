package nextstep.shoppingcart.domain.model

@JvmInline
value class Count private constructor(val value: Int) {
    fun increase(): Count {
        return of(value + 1)
    }

    fun decrease(): Count {
        if (value == MINIMUM_COUNT) {
            return this
        }
        return of(value - 1)
    }

    companion object {
        private const val MINIMUM_COUNT = 1

        val ONE = Count(MINIMUM_COUNT)

        fun of(value: Int): Count {
            return Count(value.coerceAtLeast(MINIMUM_COUNT))
        }
    }
}
