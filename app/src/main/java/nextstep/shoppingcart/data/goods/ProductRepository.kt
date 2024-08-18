package nextstep.shoppingcart.data.goods

data class Product(
    val productId: Int,
    val imageUrl: String,
    val name: String,
    val price: Int
)

interface ProductRepository {
    fun getProducts(): List<Product>
    fun getProduct(productId: Int): Product?
}