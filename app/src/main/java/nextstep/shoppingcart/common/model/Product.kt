package nextstep.shoppingcart.common.model

import kotlinx.serialization.Serializable
import java.util.UUID
import kotlin.random.Random

@Serializable
internal data class Product(
    val id: String,
    val name: String,
    val price: Int,
    val imageUrl: String?,
)

internal val dummyProducts = List(20) {
    Product(
        id = UUID.randomUUID().toString(),
        name = listOf(
            "PET보틀 - 정사각형 모양",
            "[든든] 동원 스위트콘",
            "PET보틀 - 원형(500ml)",
            "유기농 사과 1kg",
            "오렌지 주스 1L",
            "홈메이드 쿠키 세트",
            "천연 꿀 500g",
            "수제 초콜릿 박스",
            "글루텐프리 빵",
            "건강한 아침 시리얼",
            "유기농 녹차 티백",
            "프리미엄 블랙커피",
            "신선한 딸기 500g",
            "무농약 블루베리 300g",
            "천연 과일잼 세트",
            "코코넛 워터 1L",
            "친환경 재사용 가방",
            "유기농 아보카도",
            "비건 초콜릿 바",
            "유기농 올리브 오일 500ml"
        ).let { it[Random.nextInt(0, it.size)] },
        price = Random.nextInt(5000, 50000),
        imageUrl = "https://picsum.photos/seed/${UUID.randomUUID()}/500"
    )
}.distinctBy { it.id }

