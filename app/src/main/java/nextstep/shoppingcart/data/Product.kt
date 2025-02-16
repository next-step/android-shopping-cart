package nextstep.shoppingcart.data

data class Product(
    val id: Int,
    val name: String,
    val price: Int,
    val imageUrl: String,
)

val products: List<Product> = listOf(
    Product(1,"Apple", 1000, "https://picsum.photos/200/300"),
    Product(2,"Banana", 2000, "https://picsum.photos/200/300"),
    Product(3,"Carrot", 3000, "https://picsum.photos/200/300"),
    Product(4,"Orange", 4000, "https://picsum.photos/200/300"),
    Product(5,"Grape", 5000, "https://picsum.photos/200/300"),
    Product(6,"Lemon", 6000, "https://picsum.photos/200/300"),
    Product(7,"Pineapple", 7000, "https://picsum.photos/200/300"),
    Product(8,"Onion", 8000, "https://picsum.photos/200/300"),
    Product(9,"Broccoli", 9000, "https://picsum.photos/200/300"),
)