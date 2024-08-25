package nextstep.shoppingcart.model

data class Product(
    val name: String,
    val imageUrl: String,
    val price: Int,
)

val dummyProducts: List<Product> = listOf(
    Product(
        name = "[최고심] 빅허그인형",
        imageUrl = "https://insideobject.com/web/product/big/202305/9f67d565d93d7d08a7d04ba16415ba93.jpg",
        price = 43_000,
    ),
    Product(
        name = "[최고심] 고심이칭구들 - 최곰돌",
        imageUrl = "https://insideobject.com/web/product/big/202407/65d587f8c720ae3aa531b71f0715e1fb.png",
        price = 18_000,
    ),
    Product(
        name = "[최고심] 고심이칭구들 - 흰곰돌",
        imageUrl = "https://insideobject.com/web/product/big/202407/c618d16949db3971545169fbc2d61e7b.png",
        price = 18_000,
    ),
    Product(
        name = "[최고심] 조그만고심이칭구들 - 강쥐고심",
        imageUrl = "https://insideobject.com/web/product/big/202405/2da76a466947707489282974e67609c4.jpg",
        price = 16_000,
    ),
    Product(
        name = "[최고심] 조그만고심이칭구들 - 흰곰돌",
        imageUrl = "https://insideobject.com/web/product/big/202405/6fb148280f5c1539916c9090c5599dd6.jpg",
        price = 16_000,
    ),
    Product(
        name = "[최고심] 행운의 편지 마우스패드",
        imageUrl = "https://insideobject.com/web/product/big/202403/d2ac7ac376377d921abb89469c38b4bf.jpg",
        price = 5_000,
    ),
    Product(
        name = "[최고심] 부적 100종 세트",
        imageUrl = "https://insideobject.com/web/product/big/202304/fc98623508c8a3b23daa3759d76d4000.png",
        price = 48_000,
    ),
    Product(
        name = "[노플라스틱선데이 x 최고심] 캐릭터 마그넷 2종 (색상 랜덤)",
        imageUrl = "https://insideobject.com/web/product/big/202305/2dc8662784ce438ca328be212bbc2a4e.jpg",
        price = 9_000,
    ),
    Product(
        name = "[최고심] 빅스티커 6종 1pcs",
        imageUrl = "https://insideobject.com/web/product/big/202303/19ed1f6b411e3d892c95ec396a566680.jpg",
        price = 2_500,
    ),
    Product(
        name = "[최고심] 피로회복제 텀블러",
        imageUrl = "https://insideobject.com/web/product/big/202303/e95b14672fe69a2d9ca1fe8ee56f4fea.jpg",
        price = 18_000,
    ),
    Product(
        name = "[최고심] 멋진사람 다이어리",
        imageUrl = "https://insideobject.com/web/product/big/202301/975df3499671748e274417a5aeee4448.jpg",
        price = 10_000,
    ),
    Product(
        name = "[최고심] 울지말고 강해져라 렌티큘러 카드",
        imageUrl = "https://insideobject.com/web/product/big/202209/99013e01296d6ad65dd44e3e439c3d57.png",
        price = 5_000,
    ),
    Product(
        name = "[최고심] 당신 멋져 패브릭 포스터",
        imageUrl = "https://insideobject.com/web/product/big/202209/3cdaa18df14413144d95921c89a158e4.png",
        price = 16_000,
    ),
    Product(
        name = "최고심] 안되면 되는거 해라 패브릭 포스터",
        imageUrl = "https://insideobject.com/web/product/big/202209/4195df06ef98a19c306460ba79dfc596.png",
        price = 16_000,
    ),
)
