package nextstep.shoppingcart.data.util

// 참고자료 : https://bladecoder.medium.com/kotlin-singletons-with-argument-194ef06edd9e
open class SingletonHolder<out T : Any>(creator: () -> T) {
    private var creator: (() -> T)? = creator

    @Volatile
    private var instance: T? = null

    fun getInstance(): T {
        val existInstance = instance
        if (existInstance != null) {
            return existInstance
        }

        return synchronized(this) {
            val doubleCheckExistInstance = instance
            if (doubleCheckExistInstance != null) {
                doubleCheckExistInstance
            } else {
                val created = creator!!()
                instance = created
                creator = null
                created
            }
        }
    }
}
