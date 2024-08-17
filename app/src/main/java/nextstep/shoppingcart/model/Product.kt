package nextstep.shoppingcart.model

data class Product(
    val imageUrl: String,
    val name : String,
    val price : Int,
    val id : Int
)

val productList = listOf(
    Product(
        imageUrl = "https://picsum.photos/id/0/5000/3333",
        name = "신형 노트북",
        price = 2_000_000,
        id = 1
    ),
    Product(
        imageUrl = "https://picsum.photos/id/7/4728/3168",
        name = "갈색 빛깔의 가방",
        price = 32_500,
        id = 2
    ),
    Product(
        imageUrl = "https://picsum.photos/id/9/5000/3269",
        name = "맥북 에어",
        price = 1_690_000,
        id = 3
    ),
    Product(
        imageUrl = "https://picsum.photos/id/20/3670/2462",
        name = "서적 세트",
        price = 92_500,
        id = 4
    ),
    Product(
        imageUrl = "https://picsum.photos/id/21/3008/2008",
        name = "하얀 구두",
        price = 123_000,
        id = 5
    ),
    Product(
        imageUrl = "https://picsum.photos/id/22/4434/3729",
        name = "남자 정장 세트",
        price = 150_000,
        id = 6
    ),
    Product(
        imageUrl = "https://picsum.photos/id/23/3887/4899",
        name = "포트 세트",
        price = 6_000,
        id = 7
    ),
    Product(
        imageUrl = "https://picsum.photos/id/24/4855/1803",
        name = "문학 도서(양장본)",
        price = 23_000,
        id = 8
    ),
    Product(
        imageUrl = "https://picsum.photos/id/26/4209/2769",
        name = "출근 세트",
        price = 88_800,
        id = 9
    ),

)