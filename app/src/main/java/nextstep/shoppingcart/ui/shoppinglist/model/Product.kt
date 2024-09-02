package nextstep.shoppingcart.ui.shoppinglist.model

import androidx.compose.runtime.Stable

@Stable
data class Product(
    val id: Long,
    val name: String,
    val imageUrl: String,
    val price: Long,
    val containedCount: Int = 0,
)
