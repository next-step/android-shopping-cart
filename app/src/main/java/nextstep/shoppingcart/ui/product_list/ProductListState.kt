package nextstep.shoppingcart.ui.product_list

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import nextstep.shoppingcart.ui.model.Product

@Parcelize
data class ProductListState(
    val isInitialLoading: Boolean = true,
    val isLoadingShow: Boolean = false,
    val products: List<Product> = emptyList(),
    val selectedItemCount: Int = 0,
): Parcelable
