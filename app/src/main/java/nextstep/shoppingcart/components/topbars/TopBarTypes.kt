package nextstep.shoppingcart.components.topbars

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import nextstep.shoppingcart.R

internal enum class TopBarActionType(
    val icon: ImageVector,
    @StringRes val contentDescription: Int,
) {
    CART(
        icon = Icons.Filled.ShoppingCart,
        contentDescription = R.string.product_list_top_bar_action_cart,
    ),
}

internal enum class TopBarNavigationType(
    val icon: ImageVector,
    @StringRes val contentDescription: Int,
) {
    BACK(
        icon = Icons.AutoMirrored.Filled.ArrowBack,
        contentDescription = R.string.navigate_back,
    ),
}
