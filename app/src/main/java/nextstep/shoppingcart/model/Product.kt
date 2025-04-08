package nextstep.shoppingcart.model

import android.os.Parcel
import android.os.Parcelable
import java.text.NumberFormat

data class Product(
    val imageUrl: String,
    val name: String,
    val price: Int,
    val maxBuyCount: Int = 10,
) : Parcelable {

    constructor(parcel: Parcel) : this(
        imageUrl = parcel.readString() ?: "",
        name = parcel.readString() ?: "",
        price = parcel.readInt(),
        maxBuyCount = parcel.readInt()
    )

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(imageUrl)
        parcel.writeString(name)
        parcel.writeInt(price)
        parcel.writeInt(maxBuyCount)
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }

    fun getFormattedPrice(): String {
        return NumberFormat.getNumberInstance().format(price) + "원"
    }
}