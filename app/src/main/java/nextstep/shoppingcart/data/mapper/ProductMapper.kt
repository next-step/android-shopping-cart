package nextstep.shoppingcart.data.mapper

import nextstep.shoppingcart.data.model.ProductEntity
import nextstep.shoppingcart.model.Product

fun Product.toEntity(): ProductEntity {
    return ProductEntity(
        id = id,
        imageUrl = imageUrl,
        name = name,
        price = price
    )
}
