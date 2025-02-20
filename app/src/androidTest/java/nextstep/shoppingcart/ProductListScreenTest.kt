package nextstep.shoppingcart

import androidx.compose.ui.test.filter
import androidx.compose.ui.test.hasParent
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.data.FakeData
import nextstep.shoppingcart.ui.screen.ProductApp
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class ProductListScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            ProductApp()
        }
    }

    @Test
    fun 플로팅_버튼_클릭시_해당_컴포넌트에서_사라진다() {
        val productTitle = FakeData.products[0].title

        // 플로팅 버튼 클릭
        composeTestRule.onAllNodesWithContentDescription(PLUS_FLOATING_BUTTON_DESCRIPTION)
            .filter(hasParent(hasText(productTitle)))
            .onFirst()
            .performClick()

        // 플로팅 버튼 클릭시 해당 버튼이 컴포넌트에서 사라지는지 확인
        composeTestRule.onAllNodesWithContentDescription(PLUS_FLOATING_BUTTON_DESCRIPTION)
            .filter(hasParent(hasText(productTitle)))
            .onFirst()
            .assertDoesNotExist()
    }

    @Test
    fun 플로팅_버튼_클릭시_상품_수량_조절_컴포넌트가_노출된다() {
        val productTitle = FakeData.products[0].title

        // 플로팅 버튼 클릭
        composeTestRule.onAllNodesWithContentDescription(PLUS_FLOATING_BUTTON_DESCRIPTION)
            .filter(hasParent(hasText(productTitle)))
            .onFirst()
            .performClick()

        // 수량조절 컴포넌트가 노출되었는지 확인
        composeTestRule.onAllNodesWithText(QUANTITY_ADJUST_CONTAINER_PLUS_BUTTON)
            .filter(hasParent(hasText(productTitle)))
            .onFirst()
            .assertExists()
    }

    @Test
    fun 플로팅_버튼_클릭시_상품_수량이_1개_이다() {
        val productTitle = FakeData.products[0].title

        // 플로팅 버튼 클릭
        composeTestRule.onAllNodesWithContentDescription(PLUS_FLOATING_BUTTON_DESCRIPTION)
            .filter(hasParent(hasText(productTitle)))
            .onFirst()
            .performClick()

        // 수량이 1개인지 확인
        composeTestRule.onAllNodesWithText(QUANTITY_ADJUST_CONTAINER_PLUS_BUTTON)
            .filter(hasParent(hasText(productTitle) and hasText("1")))
            .onFirst()
            .assertExists()
    }

    @Test
    fun 상품_수량_조절_플러스_버튼_클릭시_수량이_증가한다() {
        val productTitle = FakeData.products[0].title

        // 플로팅 버튼 클릭
        composeTestRule.onAllNodesWithContentDescription(PLUS_FLOATING_BUTTON_DESCRIPTION)
            .filter(hasParent(hasText(productTitle)))
            .onFirst()
            .performClick()

        // 수량조절 컴포넌트 +버튼 클릭
        composeTestRule.onAllNodesWithText(QUANTITY_ADJUST_CONTAINER_PLUS_BUTTON)
            .filter(hasParent(hasText(productTitle)))
            .onFirst()
            .performClick()

        // 수량이 증가했는지 확인
        composeTestRule.onAllNodesWithText(QUANTITY_ADJUST_CONTAINER_PLUS_BUTTON)
            .filter(hasParent(hasText(productTitle) and hasText("2")))
            .onFirst()
            .assertExists()
    }

    @Test
    fun 상품_수량_조절_마이너스_버튼_클릭시_수량이_감소한다() {
        val productTitle = FakeData.products[0].title

        composeTestRule.onAllNodesWithContentDescription(PLUS_FLOATING_BUTTON_DESCRIPTION)
            .filter(hasParent(hasText(productTitle)))
            .onFirst()
            .performClick()

        // + 버튼 클릭
        composeTestRule.onAllNodesWithText(QUANTITY_ADJUST_CONTAINER_PLUS_BUTTON)
            .filter(hasParent(hasText(productTitle)))
            .onFirst()
            .performClick()

        // - 버튼 클릭
        composeTestRule.onAllNodesWithText(QUANTITY_ADJUST_CONTAINER_MINUS_BUTTON)
            .filter(hasParent(hasText(productTitle)))
            .onFirst()
            .performClick()

        // 수량이 감소했는지 확인
        composeTestRule.onAllNodesWithText(QUANTITY_ADJUST_CONTAINER_PLUS_BUTTON)
            .filter(hasParent(hasText(productTitle) and hasText("1")))
            .onFirst()
            .assertExists()
    }

    @Test
    fun 상품_수량이_1개일때_마이너스_버튼_클릭시_수량조절_컴포넌트가_사라진다() {
        val productTitle = FakeData.products[0].title

        // 플로팅 버튼 클릭
        composeTestRule.onAllNodesWithContentDescription(PLUS_FLOATING_BUTTON_DESCRIPTION)
            .filter(hasParent(hasText(productTitle)))
            .onFirst()
            .performClick()

        // - 버튼 클릭
        composeTestRule.onAllNodesWithText(QUANTITY_ADJUST_CONTAINER_MINUS_BUTTON)
            .filter(hasParent(hasText(productTitle)))
            .onFirst()
            .performClick()

        // 수량조절 컴포넌트가 사라졌는지 확인
        composeTestRule.onAllNodesWithText(QUANTITY_ADJUST_CONTAINER_PLUS_BUTTON)
            .filter(hasParent(hasText(productTitle)))
            .onFirst()
            .assertDoesNotExist()
    }

    @Test
    fun 상품_수량이_1개일때_마이너스_버튼_클릭시_플로팅_버튼이_다시_생성된다() {
        val productTitle = FakeData.products[0].title

        // 플로팅 버튼 클릭
        composeTestRule.onAllNodesWithContentDescription(PLUS_FLOATING_BUTTON_DESCRIPTION)
            .filter(hasParent(hasText(productTitle)))
            .onFirst()
            .performClick()

        // - 버튼 클릭
        composeTestRule.onAllNodesWithText(QUANTITY_ADJUST_CONTAINER_MINUS_BUTTON)
            .filter(hasParent(hasText(productTitle)))
            .onFirst()
            .performClick()

        // 플로팅 버튼이 다시 생성되었는지 확인
        composeTestRule.onAllNodesWithContentDescription(PLUS_FLOATING_BUTTON_DESCRIPTION)
            .filter(hasParent(hasText(productTitle)))
            .onFirst()
            .assertExists()
    }

    companion object {
        const val PLUS_FLOATING_BUTTON_DESCRIPTION = "Plus"

        const val QUANTITY_ADJUST_CONTAINER_PLUS_BUTTON = "+"
        const val QUANTITY_ADJUST_CONTAINER_MINUS_BUTTON = "-"
    }
}