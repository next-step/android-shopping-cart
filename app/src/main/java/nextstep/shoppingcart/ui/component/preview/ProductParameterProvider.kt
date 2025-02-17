package nextstep.shoppingcart.ui.component.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import nextstep.shoppingcart.model.ProductModel

class ProductParameterProvider : PreviewParameterProvider<ProductModel> {
    override val values = sequenceOf(
        default,
        invalidImage,
        longName,
        smallPrice,
    )
}

private val default = ProductModel(
    id = 8599,
    imageUrl = "https://fastly.picsum.photos/id/903/200/200.jpg?hmac=lxHKyjlQqAkKyuVGkgUCO_jdWkg3osj3nTuULFHZxH8",
    name = "우유",
    price = 2_000,
)

private val invalidImage = default.copy(
    id = 1L,
    imageUrl = "",
    count = 1,
)
private val longName = default.copy(
    id = 2L,
    name = "이름이 엄청긴 상품을 테스트하는 중 입니다 이름이 엄청긴 상품을 테스트하는 중 입니다 이름이 엄청긴 상품을 테스트하는 중 입니다",
)
private val smallPrice = default.copy(
    id = 3L,
    price = 0,
)

