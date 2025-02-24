package nextstep.shoppingcart

import nextstep.shoppingcart.model.Product

object ProductsTestData {
    val productTestDataList = List(30) { i ->
        Product(
            name = "[${i}] PET 보틀 - 음료수,정사각형 음료수,정사각형 음료수,정사각형 음료수",
            imageUrl = "https://i.namu.wiki/i/rwoGbf-OhaV1A1I77FtQEWojKsa-i9J0HZ0E3tFfr4gdi7fCHRh7DwaqLkLzKdruftxpu_twLfkhwgMxc3QrvgY9HhwbwB7W_YPGbkjpCIxFO9abcyQSLgM8NVUkKJ6WPegKkT35ukb0NXXRHeMW1zGcxZz_9zx63o9Pnat6I3Q.webp",
            price = 10000 + i,
            productId = "id${i}"
        )
    }
}
