package nextstep.shoppingcart.model


data class CartProductModel(
    val product: ProductModel,
    val count: Int,
) {
    val id = product.id
    val name = product.name
    val totalPrice = product.price * count
}

val dummyCartProductList = listOf(
    CartProductModel(
        product = ProductModel(
            id = 3,
            imageUrl = "https://fastly.picsum.photos/id/903/200/200.jpg?hmac=lxHKyjlQqAkKyuVGkgUCO_jdWkg3osj3nTuULFHZxH8",
            name = "우유",
            price = 1000
        ),
        count = 1
    ),
    CartProductModel(
        product = ProductModel(
            id = 2,
            imageUrl = "https://i.namu.wiki/i/QRHEugeivDhbNPuCzDMfraDC5Rd4chhuWLF7JTrQHzN-t5-Fxi4R2iqpaKIk0Hm_SCWC_oD76kz_SIwkaQQrcQ.webp",
            name = "초코우유",
            price = 2000
        ),
        count = 4
    ),
    CartProductModel(
        product = ProductModel(
            id = 1,
            imageUrl = "https://i.namu.wiki/i/Gj5s8EAX_AiQRQIeOK7MYO9WDI9jv2VxIoG4fsfOL9JNYbZLGrWYmR3YX-8RFQ45_rElsB1AJ6oXc6AHiP-VcnMDzD0i39q10gcbK4rkkcTZcBxp9eDuCyw6xz6pgeLMy48xKcFniW2FshY48NV4Wg.webp",
            name = "커피우유",
            price = 2500
        ),
        count = 2
    ),
    CartProductModel(
        product = ProductModel(
            id = 4,
            imageUrl = "https://i.namu.wiki/i/Gj5s8EAX_AiQRQIeOK7MYO9WDI9jv2VxIoG4fsfOL9JNYbZLGrWYmR3YX-8RFQ45_rElsB1AJ6oXc6AHiP-VcnMDzD0i39q10gcbK4rkkcTZcBxp9eDuCyw6xz6pgeLMy48xKcFniW2FshY48NV4Wg.webp",
            name = "딸기우유",
            price = 1500
        ),
        count = 1
    ),
    CartProductModel(
        product = ProductModel(
            id = 5,
            imageUrl = "https://i.namu.wiki/i/Gj5s8EAX_AiQRQIeOK7MYO9WDI9jv2VxIoG4fsfOL9JNYbZLGrWYmR3YX-8RFQ45_rElsB1AJ6oXc6AHiP-VcnMDzD0i39q10gcbK4rkkcTZcBxp9eDuCyw6xz6pgeLMy48xKcFniW2FshY48NV4Wg.webp",
            name = "이름이 엄청긴 바나나 바나난 바나나우유",
            price = 4000
        ),
        count = 1
    ),
    CartProductModel(
        product = ProductModel(
            id = 6,
            imageUrl = "https://i.namu.wiki/i/Gj5s8EAX_AiQRQIeOK7MYO9WDI9jv2VxIoG4fsfOL9JNYbZLGrWYmR3YX-8RFQ45_rElsB1AJ6oXc6AHiP-VcnMDzD0i39q10gcbK4rkkcTZcBxp9eDuCyw6xz6pgeLMy48xKcFniW2FshY48NV4Wg.webp",
            name = "콜라",
            price = 1705
        ),
        count = 7
    ),
    CartProductModel(
        product = ProductModel(
            id = 7,
            imageUrl = "https://i.namu.wiki/i/Gj5s8EAX_AiQRQIeOK7MYO9WDI9jv2VxIoG4fsfOL9JNYbZLGrWYmR3YX-8RFQ45_rElsB1AJ6oXc6AHiP-VcnMDzD0i39q10gcbK4rkkcTZcBxp9eDuCyw6xz6pgeLMy48xKcFniW2FshY48NV4Wg.webp",
            name = "자전거",
            price = 1000000
        ),
        count = 10
    ),

    )