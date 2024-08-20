package nextstep.shoppingcart.ui.product.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.platform.app.InstrumentationRegistry
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.PRODUCT_LIST_MOCK_DATA
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ProductCardTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val context = InstrumentationRegistry.getInstrumentation().targetContext
    private var quantity by mutableIntStateOf(1)

    @Before
    fun setUp() {
        composeTestRule.setContent {
            val product = PRODUCT_LIST_MOCK_DATA.first()
            ProductCard(
                product = product,
                quantity = quantity,
                onCardClick = {},
                onAddToCartClick = {},
                onAddQuantityClick = {},
                onRemoveQuantityClick = {},
            )
        }
    }

    @Test
    fun 장바구니_담기_버튼으로_최초_상품_추가_후_상품_수량_조절기가_노출된다() {
        quantity = 1

        composeTestRule
            .onNodeWithTag(
                context.getString(R.string.test_tag_quantity_selector),
                useUnmergedTree = true,
            ).assertIsDisplayed()
    }

    @Test
    fun 상품_조절기를_통해서_상품_수량_추가_시_상품_수량이_증가된다() {
        // given
        quantity = 1

        // when
        quantity = 2

        composeTestRule
            .onNodeWithTag(
                context.getString(R.string.test_tag_quantity_selector_quantity),
                useUnmergedTree = true,
            ).assertTextEquals("2")
    }

    @Test
    fun 상품_조절기를_통해서_상품_수량_감소_시_상품_수량이_감소된다() {
        // gvien
        quantity = 2

        // when
        quantity = 1

        composeTestRule
            .onNodeWithTag(
                context.getString(R.string.test_tag_quantity_selector_quantity),
                useUnmergedTree = true,
            ).assertTextEquals("1")
    }

    @Test
    fun 상품이_수량이_없어지면_수량_조절기가_사라지고_장바구니_담기_버튼이_노출된다() {
        // given
        quantity = 1

        // when
        quantity = 0

        composeTestRule
            .onNodeWithTag(context.getString(R.string.test_tag_quantity_selector))
            .assertIsNotDisplayed()

        composeTestRule
            .onNodeWithContentDescription(context.getString(R.string.add))
            .assertIsDisplayed()
    }
}
