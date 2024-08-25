package nextstep.shoppingcart.productlist

import nextstep.shoppingcart.common.model.Product

/*
* CartItem과 동알한 구조입니다.
* 그러나 CartItem을 그대로 사용하지 않도록 의도하였습니다.
* */
internal data class ProductListScreenItem(
    val product: Product,
    val count: Int,
)