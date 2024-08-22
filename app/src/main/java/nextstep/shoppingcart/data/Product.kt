package nextstep.shoppingcart.data

import java.io.Serializable

val errorProduct = Product(
    id = 0,
    imageUrl = "https://velog.velcdn.com/images/angiekimm/post/14adf185-3605-451c-8fae-34651aa89479/image.jpeg",
    name = "Error",
    price = 999999999
)

data class Product(
    val id: Int,
    val imageUrl: String,
    val name: String,
    val price: Int,
): Serializable
