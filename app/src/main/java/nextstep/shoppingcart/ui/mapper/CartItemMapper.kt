package nextstep.shoppingcart.ui.mapper

import nextstep.shoppingcart.data.model.CartItemEntity
import nextstep.shoppingcart.ui.model.CartItem

fun CartItemEntity.toUi(): CartItem {
    return CartItem(
        product = product.toUi(),
        count = count,
    )
}
