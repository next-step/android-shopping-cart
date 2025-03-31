package nextstep.shoppingcart.ui.product_list

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import nextstep.shoppingcart.ui.model.Product

@Parcelize
data class ProductListState(
    val isInitialLoading: Boolean = true,
    val isLoading: Boolean = false,
    val isLoadingShow: Boolean = false,
    val products: Map<String, List<Product>> = hashMapOf(),
    val selectedItemCount: Int = 0,
    val categories: List<String> = emptyList(),
    val selectedTabIndex: Int = TAB_NOT_SELECTED,
) : Parcelable {

    companion object {
        const val TAB_NOT_SELECTED = -1
    }
}
