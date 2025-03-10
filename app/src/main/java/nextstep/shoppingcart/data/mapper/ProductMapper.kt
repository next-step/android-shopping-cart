package nextstep.shoppingcart.data.mapper

import nextstep.shoppingcart.data.model.ProductEntity
import nextstep.shoppingcart.data.model.ProductResponse

fun ProductResponse.toEntity(): ProductEntity {
    return ProductEntity(
        id = id,
        imageUrl = imageUrl,
        name = name,
        price = price,
    )
}
