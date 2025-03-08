package nextstep.shoppingcart.common

import nextstep.shoppingcart.list.model.Product

object Products {
    val items = listOf(
        Product(
            id = 0,
            imageUrl = "https://picsum.photos/id/1/300/300",
            name = "PET보틀-정사각형 어쩌구",
            price = 10000
        ),
        Product(
            id = 1,
            imageUrl = "https://picsum.photos/id/2/300/300",
            name = "PET보틀-밀크티 어쩌구",
            price = 12000
        ),
        Product(
            id = 2,
            imageUrl = "https://picsum.photos/id/3/300/300",
            name = "PET보틀-납작 어쩌구",
            price = 20000
        ),
        Product(
            id = 3,
            imageUrl = "https://picsum.photos/id/4/300/300",
            name = "PET보틀-정사각형 어쩌구",
            price = 50000
        ),
        Product(
            id = 4,
            imageUrl = "https://picsum.photos/id/5/300/300",
            name = "PET보틀-납작 어쩌구",
            price = 100000
        ),
    )
}
