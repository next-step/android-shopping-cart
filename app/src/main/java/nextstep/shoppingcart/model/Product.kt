package nextstep.shoppingcart.model

data class Product(
    val id: Long,
    val name: String,
    val price: Int,
    val imgUrl: String,
)

val Products =
    listOf(
        Product(
            id = 1,
            name = "M3 MacBook Air",
            price = 2000,
            imgUrl =
                "https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/mac-card-40-macbook-air-m2-m3-202402?wid=1400&hei=1000&fmt=p-jpg&qlt=95&.v=1707259317253",
        ),
        Product(
            id = 2,
            name = "MacBook Pro",
            price = 1000,
            imgUrl =
                "https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/mac-card-40-macbookpro-14-16-202310?wid=1200&hei=1000&fmt=p-jpg&qlt=95&.v=1699558878477",
        ),
        Product(
            id = 3,
            name = "iMac",
            price = 800,
            imgUrl =
                "https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/mac-card-40-imac-24-202310?wid=1200&hei=1000&fmt=jpeg&qlt=90&.v=1697229623322",
        ),
        Product(
            id = 4,
            name = "Mac mini",
            price = 400,
            imgUrl =
                "https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/mac-card-40-mac-mini-202301?wid=1200&hei=1000&fmt=p-jpg&qlt=95&.v=1670549737872",
        ),
        Product(
            id = 5,
            name = "Mac Studio",
            price = 200,
            imgUrl =
                "https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/mac-card-40-mac-studio-202306?wid=800&hei=1000&fmt=jpeg&qlt=90&.v=1683842370512",
        ),
        Product(
            id = 6,
            name = "Studio Display",
            price = 100,
            imgUrl =
                "https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/mac-card-40-studio-display-202203?wid=800&hei=1000&fmt=p-jpg&qlt=95&.v=1645558306366",
        ),
        Product(
            id = 7,
            name = "Mac Pro",
            price = 150,
            imgUrl =
                "https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/mac-card-40-mac-pro-202306?wid=645&hei=1000&fmt=p-jpg&qlt=95&.v=1683842370649",
        ),
        Product(
            id = 8,
            name = "Pro Display XDR",
            price = 2500,
            imgUrl =
                "https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/mac-card-40-mac-pro-display-202108?wid=800&hei=1000&fmt=jpeg&qlt=90&.v=1625864626000",
        ),
        Product(
            id = 9,
            name = "iPad Pro",
            price = 6000,
            imgUrl =
                "https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/mac-card-40-macbook-air-m2-m3-202402?wid=1400&hei=1000&fmt=p-jpg&qlt=95&.v=1707259317253",
        ),
        Product(
            id = 10,
            name = "iPad Air",
            price = 700,
            imgUrl =
                "https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/mac-card-40-macbookpro-14-16-202310?wid=1200&hei=1000&fmt=p-jpg&qlt=95&.v=1699558878477",
        ),
        Product(
            id = 11,
            name = "iPad",
            price = 300,
            imgUrl =
                "https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/mac-card-40-imac-24-202310?wid=1200&hei=1000&fmt=jpeg&qlt=90&.v=1697229623322",
        ),
        Product(
            id = 12,
            name = "iPad mini",
            price = 400,
            imgUrl =
                "https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/mac-card-40-mac-mini-202301?wid=1200&hei=1000&fmt=p-jpg&qlt=95&.v=1670549737872",
        ),
    )
