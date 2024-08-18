package nextstep.shoppingcart.ui.shoppinglist.model

import androidx.compose.runtime.Stable

@Stable
data class Product(
    val id: Long,
    val name: String,
    val imageUrl: String,
    val price: Long,
)

val dummyProducts: List<Product> = listOf(
    Product(
        id = 0,
        name = "iPhone 15 Pro Max",
        imageUrl = "https://img.danawa.com/prod_img/500000/334/189/img/28189334_1.jpg",
        price = 1_900_000,
    ),
    Product(
        id = 1,
        name = "iPhone 15 Pro",
        imageUrl = "https://img.danawa.com/prod_img/500000/767/209/img/28209767_1.jpg",
        price = 1_550_000,
    ),
    Product(
        id = 2,
        name = "MacBook Pro 16 M3 Max",
        imageUrl = "https://img.danawa.com/prod_img/500000/507/654/img/29654507_1.jpg",
        price = 5_190_000,
    ),
    Product(
        id = 3,
        name = "MacBook Pro 14 M3 Max",
        imageUrl = "https://img.danawa.com/prod_img/500000/526/429/img/31429526_1.jpg",
        price = 4_790_000,
    ),
    Product(
        id = 4,
        name = "iPad Pro 11",
        imageUrl = "https://img.danawa.com/prod_img/500000/481/645/img/49645481_1.jpg",
        price = 1_499_000,
    ),
    Product(
        id = 5,
        name = "iPad Pro 13",
        imageUrl = "https://img.danawa.com/prod_img/500000/475/645/img/49645475_1.jpg",
        price = 1_999_000,
    ),
    Product(
        id = 6,
        name = "Apple Watch Ultra 2",
        imageUrl = "https://img.danawa.com/prod_img/500000/330/511/img/28511330_1.jpg",
        price = 1_149_000,
    ),
    Product(
        id = 7,
        name = "AirPods Max",
        imageUrl = "https://img.danawa.com/prod_img/500000/895/877/img/12877895_1.jpg",
        price = 769_000,
    )
)