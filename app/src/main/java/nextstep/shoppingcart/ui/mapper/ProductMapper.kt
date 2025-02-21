package nextstep.shoppingcart.ui.mapper

import nextstep.shoppingcart.data.model.ProductEntity
import nextstep.shoppingcart.ui.model.Product

fun ProductEntity.toUi(): Product {
    return Product(
        id = id,
        imageUrl = imageUrl,
        name = name,
        price = price,
    )
}

fun Product.toEntity(): ProductEntity {
    return ProductEntity(
        id = id,
        imageUrl = imageUrl,
        name = name,
        price = price
    )
}
