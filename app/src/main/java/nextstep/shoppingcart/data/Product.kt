package nextstep.shoppingcart.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Product(
    val id: Int,
    val imgUrl: String,
    val name: String,
    val price: Int
) : Parcelable