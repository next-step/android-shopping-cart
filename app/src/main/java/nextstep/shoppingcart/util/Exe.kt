package nextstep.shoppingcart.util

import android.content.Context
import android.content.Intent
import nextstep.shoppingcart.CartActivity
import nextstep.shoppingcart.ProductDetailActivity
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.util.Const.PRODUCT_ID
import nextstep.shoppingcart.util.Const.PRODUCT_IMAGE
import nextstep.shoppingcart.util.Const.PRODUCT_NAME
import nextstep.shoppingcart.util.Const.PRODUCT_PRICE

object Exe {
    fun productDetail(context: Context, product: Product) {
        context.startActivity(
            Intent(context, ProductDetailActivity::class.java).apply {
                putExtra(PRODUCT_ID, product.id)
                putExtra(PRODUCT_NAME, product.name)
                putExtra(PRODUCT_PRICE, product.price)
                putExtra(PRODUCT_IMAGE, product.imageUrl)
            }
        )
    }

    fun cart(context: Context) {
        context.startActivity(Intent(context, CartActivity::class.java))
    }
}