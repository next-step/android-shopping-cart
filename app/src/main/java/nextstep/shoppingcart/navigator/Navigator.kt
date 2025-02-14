package nextstep.shoppingcart.navigator

import android.content.Context
import android.content.Intent
import nextstep.shoppingcart.ProductDetailActivity
import nextstep.shoppingcart.model.ProductModel

fun Context.toProductDetail(model: ProductModel) {
    startActivity(
        Intent(this, ProductDetailActivity::class.java).apply {
            putExtra(PARAM_ID, model.id)
            putExtra(PARAM_NAME, model.name)
            putExtra(PARAM_PRICE, model.price)
            putExtra(PARAM_IMAGE_URL, model.imageUrl)
        }
    )
}

const val PARAM_ID = "ID"
const val PARAM_NAME = "NAME"
const val PARAM_PRICE = "PRICE"
const val PARAM_IMAGE_URL = "IMAGE_URL"

fun Intent.getProductModel() = ProductModel(
    id = getLongExtra(PARAM_ID, 0L),
    imageUrl = getStringExtra(PARAM_IMAGE_URL).orEmpty(),
    name = getStringExtra(PARAM_NAME).orEmpty(),
    price = getIntExtra(PARAM_PRICE, 0),
)