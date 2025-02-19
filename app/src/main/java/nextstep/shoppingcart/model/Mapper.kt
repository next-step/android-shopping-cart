package nextstep.shoppingcart.model

fun List<ProductModel>.toProductWithCartCount() = this.map {
    it.toProductWithCartCount()
}

fun ProductModel.toProductWithCartCount() = CartProductModel(
    product = this,
    count = Cart.productCount(this),
)