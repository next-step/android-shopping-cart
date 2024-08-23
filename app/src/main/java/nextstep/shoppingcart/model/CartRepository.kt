package nextstep.shoppingcart.model

interface CartRepository {
    fun addOne(product: Product): List<CartItem>
    fun removeOne(product: Product): List<CartItem>
    fun removeAll(product: Product): List<CartItem>
}