package nextstep.shoppingcart.data

data class CartItem(
    val product: Product,
    val count: Int,
) {
    val totalPrice: Int get() = product.price * count
}

object Cart {
    private val _items: MutableList<CartItem> = mutableListOf()
    val items: List<CartItem> get() = _items.toList()
    
    val totalPrice: Int get() = _items.sumOf { it.totalPrice }

    fun addOne(product: Product): List<CartItem> {
        val item = _items.find { it.product == product }
        if (item == null) {
            _items.add(CartItem(product, 1))
        } else {
            val index = _items.indexOf(item)
            _items[index] = item.copy(count = item.count + 1)
        }
        return items
    }

    fun removeOne(product: Product): List<CartItem> {
        _items.find { it.product == product }
            ?.let { item ->
                if (item.count > 1) {
                    val index = _items.indexOf(item)
                    _items[index] = item.copy(count = item.count - 1)
                } else {
                    _items.remove(item)
                }
            }
        return items
    }

    fun removeAll(product: Product): List<CartItem> {
        _items.removeAll { it.product == product }
        return items
    }

    val productItemDummyList = listOf(
        Product(
            name = "상품1",
            imageUrl = "https://images.mypetlife.co.kr/content/uploads/2023/03/30102633/AdobeStock_297354202-1024x683.jpeg",
            price = 10_000,
        ),
        Product(
            name = "상품2",
            imageUrl = "https://images.mypetlife.co.kr/content/uploads/2023/03/30102633/AdobeStock_297354202-1024x683.jpeg",
            price = 7_000,
        ),
        Product(
            name = "상품3",
            imageUrl = "https://images.mypetlife.co.kr/content/uploads/2023/03/30102633/AdobeStock_297354202-1024x683.jpeg",
            price = 15_000,
        ),
        Product(
            name = "상품4",
            imageUrl = "https://images.mypetlife.co.kr/content/uploads/2023/03/30102633/AdobeStock_297354202-1024x683.jpeg",
            price = 21_000,
        ),
        Product(
            name = "상품5",
            imageUrl = "https://images.mypetlife.co.kr/content/uploads/2023/03/30102633/AdobeStock_297354202-1024x683.jpeg",
            price = 4_500,
        ),
        Product(
            name = "상품6",
            imageUrl = "https://images.mypetlife.co.kr/content/uploads/2023/03/30102633/AdobeStock_297354202-1024x683.jpeg",
            price = 30_000,
        ),
        Product(
            name = "상품7",
            imageUrl = "https://images.mypetlife.co.kr/content/uploads/2023/03/30102633/AdobeStock_297354202-1024x683.jpeg",
            price = 2_000,
        ),
        Product(
            name = "상품8",
            imageUrl = "https://images.mypetlife.co.kr/content/uploads/2023/03/30102633/AdobeStock_297354202-1024x683.jpeg",
            price = 20_000,
        ),
        Product(
            name = "상품9",
            imageUrl = "https://images.mypetlife.co.kr/content/uploads/2023/03/30102633/AdobeStock_297354202-1024x683.jpeg",
            price = 50_000,
        ),
        Product(
            name = "상품10",
            imageUrl = "https://images.mypetlife.co.kr/content/uploads/2023/03/30102633/AdobeStock_297354202-1024x683.jpeg",
            price = 100_000,
        ),
    )
}
