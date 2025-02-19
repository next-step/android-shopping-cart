package nextstep.shoppingcart.model

import android.content.Intent

data class Product(
    val id: Int,
    val name: String,
    val price: Int,
    val imageUrl: String,
)

const val PRODUCT_ID_KEY = "id"
const val PRODUCT_NAME_KEY = "name"
const val PRODUCT_PRICE_KEY = "price"
const val PRODUCT_IMAGE_URL_KEY = "imageUrl"

fun Intent.putProduct(product: Product) {
    putExtra(PRODUCT_ID_KEY, product.id)
    putExtra(PRODUCT_NAME_KEY, product.name)
    putExtra(PRODUCT_PRICE_KEY, product.price)
    putExtra(PRODUCT_IMAGE_URL_KEY, product.imageUrl)
}

fun Intent.getProduct(): Product? {
    val id = getIntExtra(PRODUCT_ID_KEY, -1)
    val name = getStringExtra(PRODUCT_NAME_KEY) ?: return null
    val price = getIntExtra(PRODUCT_PRICE_KEY, -1)
    val imageUrl = getStringExtra(PRODUCT_IMAGE_URL_KEY) ?: return null
    return Product(
        id = id,
        name = name,
        price = price,
        imageUrl = imageUrl,
    )
}
