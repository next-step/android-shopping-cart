package nextstep.shoppingcart.model

import java.util.Locale

data class Product(
    val imageUrl: String,
    val name: String,
    val price: Int
) {
    val formattedPrice: String
        get() = String.format(Locale.getDefault(), "%,d원", price)

    companion object {
        val mock = Product(
            imageUrl = "",
            name = "상품 이름입니다",
            price = 20000
        )
    }
}

val products: List<Product> = listOf(
    Product("https://picsum.photos/id/1/200/300", "아메리카노 (HOT)", 3000),
    Product("https://picsum.photos/id/2/200/300", "아메리카노 (ICE)", 3500),
    Product("https://picsum.photos/id/3/200/300", "카페라떼 (HOT)", 4000),
    Product("https://picsum.photos/id/4/200/300", "카페라떼 (ICE)", 4500),
    Product("https://picsum.photos/id/5/200/300", "카푸치노 (HOT)", 5000),
    Product("https://picsum.photos/id/6/200/300", "카푸치노 (ICE)", 5500),
    Product("https://picsum.photos/id/7/200/300", "카라멜 마끼아또 (HOT)", 5000),
    Product("https://picsum.photos/id/8/200/300", "카라멜 마끼아또 (ICE)", 5500),
    Product("https://picsum.photos/id/9/200/300", "바닐라 라떼 (HOT)", 5000),
    Product("https://picsum.photos/id/10/200/300", "바닐라 라떼 (ICE)", 5500),
    Product("https://picsum.photos/id/11/200/300", "초콜릿 라떼 (HOT)", 5000),
    Product("https://picsum.photos/id/12/200/300", "초콜릿 라떼 (ICE)", 5500),
    Product("https://picsum.photos/id/13/200/300", "딸기 요거트 스무디 (ICE)", 6500),
    Product("https://picsum.photos/id/14/200/300", "망고 스무디 (ICE)", 6500),
    Product("https://picsum.photos/id/15/200/300", "레몬 에이드 (ICE)", 6000),
    Product("https://picsum.photos/id/16/200/300", "자몽 에이드 (ICE)", 6000),
    Product("https://picsum.photos/id/17/200/300", "블루베리 에이드 (ICE)", 6000),
)