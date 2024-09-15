package nextstep.shoppingcart.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Create Date: 2024. 8. 25.
 *
 * Description:
 *
 * 쇼핑 아이템 UI 모델 정의
 *
 * @author LeeDongHun
 *
 * @see
 * */
@Parcelize
data class ShoppingItemUiModel(
	val id:Int,
	val productTitle: String,
	val productThumbnail: String = "https://loremflickr.com/320/320/${productTitle}",
	val productPrice: Long,
) : Parcelable
