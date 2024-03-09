package nextstep.shoppingcart.ui.screen.cart

import nextstep.shoppingcart.model.Product

data class CartItem(
    val count: Int = 0,
    val product: Product
) {
    companion object {
        val fixture: List<CartItem> = listOf(
            CartItem(
                product = Product(
                    id = 1,
                    imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTzekEUjmuN9K6Sk21VuDTN03jkg5kyLCijYw&usqp=CAU",
                    name = "PET보틀-정사각형정사각형정사각형",
                    price = 10000
                )
            ),
            CartItem(
                product = Product(
                    id = 2,
                    imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSVFkYZENl-eDKg3S-tbrx8TkcHNc-R1LnQbg&usqp=CAU",
                    name = "PET보틀-밀크티밀크티밀크티밀크티밀크티밀크티",
                    price = 12000
                )
            ),
            CartItem(
                product = Product(
                    id = 3,
                    imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSSCapZ0dRYgnDbceI5nae88TxKVGWBaH9JXA&usqp=CAU",
                    name = "PET보틀-정사각형정사각형정사각형",
                    price = 10000
                )
            ),
            CartItem(
                product = Product(
                    id = 4,
                    imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQqrg4LXxZMnDMdy6pwEXkWl30OVb2TfPa9yA&usqp=CAU",
                    name = "PET보틀-납작(2222222222222222",
                    price = 12000
                )
            ),
            CartItem(
                product = Product(
                    id = 5,
                    imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS7UcCe5q9Bmd87tVhVHDItvQbDbX55tEbE2Q&usqp=CAU",
                    name = "PET보틀-정사각형정사각형",
                    price = 10000
                )
            ),
            CartItem(
                product = Product(
                    id = 6,
                    imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSlc7mCnHkisa_z-ek7fZlbe8t_M9AuVlhITw&usqp=CAU",
                    name = "PET보틀-납작(2222222222222222",
                    price = 12000
                )
            ),
            CartItem(
                product = Product(
                    id = 7,
                    imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTzekEUjmuN9K6Sk21VuDTN03jkg5kyLCijYw&usqp=CAU",
                    name = "PET보틀-정사각형정사각형정사각형",
                    price = 10000
                )
            ),
            CartItem(
                product = Product(
                    id = 8,
                    imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSVFkYZENl-eDKg3S-tbrx8TkcHNc-R1LnQbg&usqp=CAU",
                    name = "PET보틀-밀크티밀크티밀크티밀크티밀크티밀크티",
                    price = 12000
                )
            ),
            CartItem(
                product = Product(
                    id = 9,
                    imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSSCapZ0dRYgnDbceI5nae88TxKVGWBaH9JXA&usqp=CAU",
                    name = "PET보틀-정사각형정사각형정사각형",
                    price = 10000
                )
            ),
            CartItem(
                product = Product(
                    id = 10,
                    imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQqrg4LXxZMnDMdy6pwEXkWl30OVb2TfPa9yA&usqp=CAU",
                    name = "PET보틀-납작(2222222222222222",
                    price = 12000
                )
            ),
            CartItem(
                product = Product(
                    id = 11,
                    imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS7UcCe5q9Bmd87tVhVHDItvQbDbX55tEbE2Q&usqp=CAU",
                    name = "PET보틀-정사각형정사각형",
                    price = 10000
                )
            ),
            CartItem(
                product = Product(
                    id = 12,
                    imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSlc7mCnHkisa_z-ek7fZlbe8t_M9AuVlhITw&usqp=CAU",
                    name = "PET보틀-납작(2222222222222222",
                    price = 12000
                )
            )

        )
    }
}
