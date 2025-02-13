package nextstep.shoppingcart.model

data class ProductModel(
    val id: Long,
    val imageUrl: String,
    val name: String,
    val price: Int,
)

val dummyProducts = listOf(
    ProductModel(
        id = 1,
        imageUrl = "https://fastly.picsum.photos/id/903/200/200.jpg?hmac=lxHKyjlQqAkKyuVGkgUCO_jdWkg3osj3nTuULFHZxH8",
        name = "우유",
        price = 1000
    ),
    ProductModel(
        id = 2,
        imageUrl = "https://i.namu.wiki/i/QRHEugeivDhbNPuCzDMfraDC5Rd4chhuWLF7JTrQHzN-t5-Fxi4R2iqpaKIk0Hm_SCWC_oD76kz_SIwkaQQrcQ.webp",
        name = "초코우유",
        price = 2000
    ),
    ProductModel(
        id = 3,
        imageUrl = "https://i.namu.wiki/i/Gj5s8EAX_AiQRQIeOK7MYO9WDI9jv2VxIoG4fsfOL9JNYbZLGrWYmR3YX-8RFQ45_rElsB1AJ6oXc6AHiP-VcnMDzD0i39q10gcbK4rkkcTZcBxp9eDuCyw6xz6pgeLMy48xKcFniW2FshY48NV4Wg.webp",
        name = "커피우유",
        price = 2500
    ),
    ProductModel(
        id = 4,
        imageUrl = "https://i.namu.wiki/i/Gj5s8EAX_AiQRQIeOK7MYO9WDI9jv2VxIoG4fsfOL9JNYbZLGrWYmR3YX-8RFQ45_rElsB1AJ6oXc6AHiP-VcnMDzD0i39q10gcbK4rkkcTZcBxp9eDuCyw6xz6pgeLMy48xKcFniW2FshY48NV4Wg.webp",
        name = "딸기우유",
        price = 1500
    ),
    ProductModel(
        id = 5,
        imageUrl = "https://i.namu.wiki/i/Gj5s8EAX_AiQRQIeOK7MYO9WDI9jv2VxIoG4fsfOL9JNYbZLGrWYmR3YX-8RFQ45_rElsB1AJ6oXc6AHiP-VcnMDzD0i39q10gcbK4rkkcTZcBxp9eDuCyw6xz6pgeLMy48xKcFniW2FshY48NV4Wg.webp",
        name = "이름이 엄청긴 바나나 바나난 바나나우유",
        price = 4000
    ),
    ProductModel(
        id = 6,
        imageUrl = "https://i.namu.wiki/i/Gj5s8EAX_AiQRQIeOK7MYO9WDI9jv2VxIoG4fsfOL9JNYbZLGrWYmR3YX-8RFQ45_rElsB1AJ6oXc6AHiP-VcnMDzD0i39q10gcbK4rkkcTZcBxp9eDuCyw6xz6pgeLMy48xKcFniW2FshY48NV4Wg.webp",
        name = "콜라",
        price = 1705
    ),
    ProductModel(
        id = 7,
        imageUrl = "https://i.namu.wiki/i/Gj5s8EAX_AiQRQIeOK7MYO9WDI9jv2VxIoG4fsfOL9JNYbZLGrWYmR3YX-8RFQ45_rElsB1AJ6oXc6AHiP-VcnMDzD0i39q10gcbK4rkkcTZcBxp9eDuCyw6xz6pgeLMy48xKcFniW2FshY48NV4Wg.webp",
        name = "자전거",
        price = 1000000
    ),
    ProductModel(
        id = 8,
        imageUrl = "https://i.namu.wiki/i/Gj5s8EAX_AiQRQIeOK7MYO9WDI9jv2VxIoG4fsfOL9JNYbZLGrWYmR3YX-8RFQ45_rElsB1AJ6oXc6AHiP-VcnMDzD0i39q10gcbK4rkkcTZcBxp9eDuCyw6xz6pgeLMy48xKcFniW2FshY48NV4Wg.webp",
        name = "기타",
        price = 120000
    ),
    ProductModel(
        id = 9,
        imageUrl = "https://i.namu.wiki/i/Gj5s8EAX_AiQRQIeOK7MYO9WDI9jv2VxIoG4fsfOL9JNYbZLGrWYmR3YX-8RFQ45_rElsB1AJ6oXc6AHiP-VcnMDzD0i39q10gcbK4rkkcTZcBxp9eDuCyw6xz6pgeLMy48xKcFniW2FshY48NV4Wg.webp",
        name = "사이다",
        price = 2000
    ),
    ProductModel(
        id = 10,
        imageUrl = "https://i.namu.wiki/i/Gj5s8EAX_AiQRQIeOK7MYO9WDI9jv2VxIoG4fsfOL9JNYbZLGrWYmR3YX-8RFQ45_rElsB1AJ6oXc6AHiP-VcnMDzD0i39q10gcbK4rkkcTZcBxp9eDuCyw6xz6pgeLMy48xKcFniW2FshY48NV4Wg.webp",
        name = "삼각김밥",
        price = 2000
    ),
    ProductModel(
        id = 11,
        imageUrl = "https://i.namu.wiki/i/Gj5s8EAX_AiQRQIeOK7MYO9WDI9jv2VxIoG4fsfOL9JNYbZLGrWYmR3YX-8RFQ45_rElsB1AJ6oXc6AHiP-VcnMDzD0i39q10gcbK4rkkcTZcBxp9eDuCyw6xz6pgeLMy48xKcFniW2FshY48NV4Wg.webp",
        name = "초콜렛",
        price = 2000
    ),
    ProductModel(
        id = 12,
        imageUrl = "https://i.namu.wiki/i/Gj5s8EAX_AiQRQIeOK7MYO9WDI9jv2VxIoG4fsfOL9JNYbZLGrWYmR3YX-8RFQ45_rElsB1AJ6oXc6AHiP-VcnMDzD0i39q10gcbK4rkkcTZcBxp9eDuCyw6xz6pgeLMy48xKcFniW2FshY48NV4Wg.webp",
        name = "사과",
        price = 2000
    ),
    ProductModel(
        id = 13,
        imageUrl = "https://i.namu.wiki/i/Gj5s8EAX_AiQRQIeOK7MYO9WDI9jv2VxIoG4fsfOL9JNYbZLGrWYmR3YX-8RFQ45_rElsB1AJ6oXc6AHiP-VcnMDzD0i39q10gcbK4rkkcTZcBxp9eDuCyw6xz6pgeLMy48xKcFniW2FshY48NV4Wg.webp",
        name = "포도",
        price = 2000
    ),
)
