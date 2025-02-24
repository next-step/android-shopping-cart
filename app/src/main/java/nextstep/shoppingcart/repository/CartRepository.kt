package nextstep.shoppingcart.repository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import nextstep.shoppingcart.data.CartItem
import nextstep.shoppingcart.data.Product

object CartRepository {
    private val _items = MutableStateFlow<List<CartItem>>(emptyList()) // StateFlow 사용
    val items: StateFlow<List<CartItem>> = _items.asStateFlow() // 구독 가능하게 제공

    val totalPrice: Int get() = _items.value.sumOf { it.totalPrice }

    fun addOne(product: Product) {
        val currentItems = _items.value.toMutableList()
        val item = currentItems.find { it.product == product }
        if (item == null) {
            currentItems.add(CartItem(product, 1))
        } else {
            val index = currentItems.indexOf(item)
            currentItems[index] = item.copy(count = item.count + 1)
        }
        _items.value = currentItems // 값 갱신
    }

    fun removeOne(product: Product) {
        val currentItems = _items.value.toMutableList()
        currentItems.find { it.product == product }
            ?.let { item ->
                if (item.count > 1) {
                    val index = currentItems.indexOf(item)
                    currentItems[index] = item.copy(count = item.count - 1)
                } else {
                    currentItems.remove(item)
                }
            }
        _items.value = currentItems // 값 갱신
    }

    fun removeAll(product: Product) {
        _items.value = _items.value.filter { it.product != product }
    }

    fun getItemCount(product: Product, cartItems: List<CartItem>): Int {
        val count = cartItems.find { it.product == product }?.count
        return count ?: 0
    }

    fun clear() {
        _items.value = emptyList() // 전체 초기화
    }
}