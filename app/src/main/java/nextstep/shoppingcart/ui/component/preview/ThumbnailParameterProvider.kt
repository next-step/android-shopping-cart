package nextstep.shoppingcart.ui.component.preview

import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider

class ThumbnailParameterProvider : CollectionPreviewParameterProvider<Triple<Long, String, String>>(
    listOf(
        Triple(0L, "첫번째 이미지", "https://i.namu.wiki/i/LRVSZvt5xU7FGREgKOlOZcRYzYaPph-uC2OdgAkE6V_nSLv4ghlRFcurz-dMEf1n-G8VkJuUOsa5Q7Bxwi-LT8uPWHZ2sua7j5W2yTE4fL-i_b66zzl1KZwPSuCrzsFOjE32T955Ezlb_I74hB8XgA.webp"),
        Triple(1L, "에러 이미지", "empty"),
    )
)