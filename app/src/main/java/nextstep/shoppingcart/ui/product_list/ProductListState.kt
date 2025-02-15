package nextstep.shoppingcart.ui.product_list

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import nextstep.shoppingcart.model.Product

@Parcelize
data class ProductListState(
    var isInitialLoading: Boolean = true,
    val products: List<Product> = emptyList(),
    val selectedItemCount: Int = 0,
): Parcelable
