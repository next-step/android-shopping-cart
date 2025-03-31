package nextstep.shoppingcart.ui.mapper

import nextstep.shoppingcart.data.model.ProductEntity
import nextstep.shoppingcart.data.model.ProductResponse
import nextstep.shoppingcart.ui.model.Product

fun ProductEntity.toUi(cartQuantity: Int): Product {
    return Product(
        id = id,
        imageUrl = imageUrl,
        name = name,
        category = category,
        price = price,
        cartQuantity = cartQuantity,
    )
}

fun Product.toEntity(): ProductEntity {
    return ProductEntity(
        id = id,
        imageUrl = imageUrl,
        name = name,
        category = category,
        price = price,
    )
}

fun ProductResponse.toUi(): Product {
    return Product(
        id = id,
        imageUrl = imageUrl,
        name = name,
        category = category,
        price = price,
        cartQuantity = 0,
    )
}
