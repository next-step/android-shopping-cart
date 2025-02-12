package nextstep.shoppingcart.model

import androidx.annotation.StringRes
import nextstep.shoppingcart.R

enum class ShoppingCartTopBarType(
    @StringRes val titleResId: Int,
    val isCenter: Boolean,
    val showCartIcon: Boolean,
    val showBackButton: Boolean,
) {
    PRODUCT_LIST(
        titleResId = R.string.product_list,
        isCenter = true,
        showCartIcon = true,
        showBackButton = false
    ),
}