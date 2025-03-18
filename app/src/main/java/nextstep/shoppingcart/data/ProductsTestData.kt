package nextstep.shoppingcart.data

import nextstep.shoppingcart.model.Product

object ProductsTestData {
    val productTestDataList = List(30) { i ->
        Product(
            name = "[${i}] PET 보틀 - 음료수,정사각형 음료수,정사각형 음료수,정사각형 음료수",
            imageUrl = "https://cdn.digitaltoday.co.kr/news/photo/202502/553394_517550_359.jpg",
            price = 10000 + i,
            productId = "id${i}"
        )
    }
}
