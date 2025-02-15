package nextstep.shoppingcart.model

data class Product(
    val imageUrl: String,
    val name: String,
    val price: Int,
)

internal val dummyProducts = listOf(
    Product(
        imageUrl = "https://picsum.photos/200/300",
        name = "치즈버거",
        price = 5500
    ),
    Product(
        imageUrl = "https://picsum.photos/250/350",
        name = "페퍼로니 피자",
        price = 13900
    ),
    Product(
        imageUrl = "https://picsum.photos/180/280",
        name = "초콜릿 케이크",
        price = 8900
    ),
    Product(
        imageUrl = "https://picsum.photos/220/320",
        name = "아이스 아메리카노",
        price = 4100
    ),
    Product(
        imageUrl = "https://picsum.photos/240/360",
        name = "후라이드 치킨",
        price = 16900
    ),
    Product(
        imageUrl = "https://picsum.photos/190/290",
        name = "딸기 타르트",
        price = 7500
    ),
    Product(
        imageUrl = "https://picsum.photos/210/310",
        name = "크로와상",
        price = 3200
    ),
    Product(
        imageUrl = "https://picsum.photos/230/330",
        name = "연어 덮밥",
        price = 13500
    ),
    Product(
        imageUrl = "https://picsum.photos/200/250",
        name = "스테이크",
        price = 28900
    ),
    Product(
        imageUrl = "https://picsum.photos/260/360",
        name = "마카롱 세트",
        price = 9600
    ),
    Product(
        imageUrl = "https://picsum.photos/180/300",
        name = "초밥 모둠",
        price = 19800
    ),
    Product(
        imageUrl = "https://picsum.photos/240/340",
        name = "랍스터 요리",
        price = 49900
    ),
    Product(
        imageUrl = "https://picsum.photos/210/290",
        name = "모카 라떼",
        price = 4600
    ),
    Product(
        imageUrl = "https://picsum.photos/220/350",
        name = "불고기 덮밥",
        price = 12500
    ),
    Product(
        imageUrl = "https://picsum.photos/250/320",
        name = "망고 빙수",
        price = 11000
    ),
    Product(
        imageUrl = "https://picsum.photos/230/300",
        name = "치즈 케이크",
        price = 7200
    ),
    Product(
        imageUrl = "https://picsum.photos/200/280",
        name = "바베큐 폭립",
        price = 27800
    ),
    Product(
        imageUrl = "https://picsum.photos/260/340",
        name = "새우 파스타",
        price = 15800
    ),
    Product(
        imageUrl = "https://picsum.photos/190/310",
        name = "티라미수",
        price = 8800
    ),
    Product(
        imageUrl = "https://picsum.photos/220/300",
        name = "팝콘 치킨",
        price = 7200
    )
)
