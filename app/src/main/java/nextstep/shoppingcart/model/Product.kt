package nextstep.shoppingcart.model

import java.util.UUID

data class Product(
    val id: String,
    val imageUrl: String,
    val name: String,
    val price: Int
)

val products = listOf(
    Product(UUID.randomUUID().toString(),"https://picsum.photos/200", "매콤달콤 떡볶이!", 8500),
    Product(UUID.randomUUID().toString(),"https://picsum.photos/200", "바삭바삭 치킨🍗", 18900),
    Product(UUID.randomUUID().toString(),"https://picsum.photos/200", "얼큰한 김치찌개🍲", 7000),
    Product(UUID.randomUUID().toString(),"https://picsum.photos/200", "고소한 참기름 비빔밥", 9500),
    Product(UUID.randomUUID().toString(),"https://picsum.photos/200", "달콤짭짤 불고기덮밥", 12000),
    Product(UUID.randomUUID().toString(),"https://picsum.photos/200", "쫄깃쫄깃 순대볶음", 11000),
    Product(UUID.randomUUID().toString(),"https://picsum.photos/200", "얼큰시원 짬뽕🍜", 9000),
    Product(UUID.randomUUID().toString(),"https://picsum.photos/200", "쟁반 노래방 사이즈 쟁반사천짜장", 16500),
    Product(UUID.randomUUID().toString(),"https://picsum.photos/200", "매콤한 닭볶음탕!", 25000),
    Product(UUID.randomUUID().toString(),"https://picsum.photos/200", "바삭한 돈까스&카레", 13500),
    Product(UUID.randomUUID().toString(),"https://picsum.photos/200", "방금 잡아 싱싱한 회덮밥🐟", 15000),
    Product(UUID.randomUUID().toString(),"https://picsum.photos/200", "따끈따끈 잔치국수", 6000),
    Product(UUID.randomUUID().toString(),"https://picsum.photos/200", "시원한 평양물냉면🧊", 8000),
    Product(UUID.randomUUID().toString(),"https://picsum.photos/200", "한우 투쁠 갈비찜", 35000),
    Product(UUID.randomUUID().toString(),"https://picsum.photos/200", "해물듬뿍 해물파전!", 16000),
)

fun getProductById(id: String): Product {
    return products.find { it.id == id } ?: Product(UUID.randomUUID().toString(), "", "", 0)
}
