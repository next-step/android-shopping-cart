package nextstep.shoppingcart.ui.component

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import nextstep.shoppingcart.model.ProductModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ProductTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val product = ProductModel(
        id = 6871,
        imageUrl = "http://www.bing.com/search?q=nominavi",
        name = "우유",
        price = 2_000
    )

    private val addProductButton get() = composeTestRule.onNodeWithContentDescription("상품 추가")
    private val countControlButton
        get() = composeTestRule.onNodeWithTag(
            "countControlButton",
            useUnmergedTree = true
        )

    private var count by mutableIntStateOf(0)

    @Before
    fun setup() {
        composeTestRule.setContent {
            Product(model = product, count = count)
        }
    }

    @Test
    fun 상품목록_아이템에_상품이미지_상품명_상품가가격_수량이_0일때_추가_버튼_노출_수량버튼_미노출() {
        // given
        count = 0

        // then
        composeTestRule
            .onNodeWithText("우유")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithText("2,000원")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithContentDescription("우유 이미지")
            .assertIsDisplayed()
        addProductButton
            .assertIsDisplayed()
        countControlButton
            .assertIsNotDisplayed()
    }

    @Test
    fun 수량이_1이상일때_추가_버튼_노출_수량버튼_노출() {
        // given
        count = 1

        // then
        addProductButton
            .assertIsNotDisplayed()
        countControlButton
            .assertIsDisplayed()
    }

    @Test
    fun 수량이_1일때_제거버튼_클릭하면_수량조절버튼_미노출_담기버튼_노출() {
        // given
        count = 1

        // when
        count = count.dec()

        // then
        countControlButton
            .assertIsNotDisplayed()
        addProductButton
            .assertIsDisplayed()
    }


    @Test
    fun 수량이_0일때_담기버튼_클릭하면_수량조절버튼_노출_담기버튼_미노출() {
        // given
        count = 0

        // when
        count = count.inc()

        // then
        countControlButton
            .assertIsDisplayed()
        addProductButton
            .assertIsNotDisplayed()
    }
}