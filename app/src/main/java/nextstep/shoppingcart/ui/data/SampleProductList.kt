package nextstep.shoppingcart.ui.data

object SampleProductList {
    val sampleProductList = mutableListOf<Product>().apply {
        add(
            Product(
                imgUrl = "https://picsum.photos/seed/1/200",
                name = "상품 1-이름이 너무 길다면 어떻게 할 것인가요?",
                price = 3000
            )
        )
        add(
            Product(
                imgUrl = "https://picsum.photos/seed/2/200",
                name = "상품 2",
                price = 100
            )
        )
        add(
            Product(
                imgUrl = "https://picsum.photos/seed/3/200",
                name = "상품 3",
                price = 4500
            )
        )
        add(
            Product(
                imgUrl = "https://picsum.photos/seed/4/200",
                name = "상품 4",
                price = 1234567890
            )
        )
        add(
            Product(
                imgUrl = "https://picsum.photos/seed/5/200",
                name = "상품 5",
                price = 50900
            )
        )
        add(
            Product(
                imgUrl = "https://picsum.photos/seed/6/200",
                name = "상품 6",
                price = 10000
            )
        )
        add(
            Product(
                imgUrl = "https://picsum.photos/seed/7/200",
                name = "상품 7",
                price = 10000
            )
        )
        add(
            Product(
                imgUrl = "https://picsum.photos/seed/8/200",
                name = "상품 8",
                price = 10000
            )
        )
        add(
            Product(
                imgUrl = "https://picsum.photos/seed/9/200",
                name = "상품 9",
                price = 10000
            )
        )
    }
}