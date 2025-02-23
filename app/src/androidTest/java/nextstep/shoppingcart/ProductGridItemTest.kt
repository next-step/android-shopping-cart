package nextstep.shoppingcart

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import nextstep.shoppingcart.catalog.component.ProductGridItem
import nextstep.shoppingcart.catalog.component.ProductQuantityAdjustImage
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.testdouble.FakeCartDataSourceImpl
import org.junit.Rule
import org.junit.Test

class ProductGridItemTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `가격이_형식에_맞게_출력되는지_테스트`() {
        // given
        val price = 50000

        // when
        composeTestRule.setContent {
            ProductGridItem(
                Product(
                    id = 1,
                    name = "",
                    price = price,
                    imageUrl = "",
                ),
                cartDataSource = FakeCartDataSourceImpl(),
                onClickItem = {},
            )
        }

        // then
        composeTestRule
            .onNodeWithText("50,000원")
            .assertExists()
    }

    @Test
    fun `isAdded_값이_false면_상품_담기_버튼이_표시된다`() {
        // given
        val isAdded = false

        // when
        composeTestRule.setContent {
            ProductQuantityAdjustImage(
                product = Product(
                    id = 1,
                    name = "",
                    price = 0,
                    imageUrl = ""
                ),
                count = 0,
                isAdded = isAdded,
                onClickAddCartButton = {},
                onClickIncreaseCountButton = {},
                onClickDecreaseCountButton = {}
            )
        }

        // then
        composeTestRule.onNodeWithTag("1AddButton")
            .assertExists()
    }

    @Test
    fun `isAdded_값이_true면_수량_조절_버튼이_표시된다`() {
        // given
        val isAdded = true

        // when
        composeTestRule.setContent {
            ProductQuantityAdjustImage(
                product = Product(
                    id = 1,
                    name = "",
                    price = 0,
                    imageUrl = ""
                ),
                count = 0,
                isAdded = isAdded,
                onClickAddCartButton = {},
                onClickIncreaseCountButton = {},
                onClickDecreaseCountButton = {}
            )
        }

        // then
        composeTestRule.onNodeWithTag("1AdjustButton")
            .assertExists()
    }
}
