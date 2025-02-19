package nextstep.shoppingcart

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.data.FakeData
import nextstep.shoppingcart.ui.screen.ProductApp
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ProductScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            ProductApp()
        }
    }

    @Test
    fun 상품_클릭시_상세화면으로_이동한다() {
        // given
        val fakeData = FakeData.products
        val clickItem = fakeData[0]

        // ProductScreen에서 특정 상품 클릭
        composeTestRule.onNodeWithText(clickItem.title).performClick()

        // ProductDetailScreen으로 이동했는지 확인
        composeTestRule.onNodeWithText(PRODUCT_DETAIL_TITLE).assertIsDisplayed()
    }

    @Test
    fun 앱바_쇼핑카트_아이콘_클릭시_장바구니_화면으로_이동한다() {
        // 앱바의 쇼핑카트 아이콘 클릭
        composeTestRule.onNodeWithContentDescription(SHOPPING_CART_ICON_DESCRIPTION).performClick()

        // ShoppingCartScreen으로 이동했는지 확인
        composeTestRule.onNodeWithText(SHOPPING_CART_TITLE).assertIsDisplayed()
    }

    @Test
    fun 상품상세_화면에서_장바구니_담기_버튼_클릭시_장바구니_화면으로_이동한다() {
        // given
        val fakeData = FakeData.products
        val clickItem = fakeData[0]

        // ProductScreen에서 특정 상품 클릭
        composeTestRule.onNodeWithText(clickItem.title).performClick()

        // ProductDetailScreen에서 장바구니 버튼 클릭
        composeTestRule.onNodeWithText(ADD_TO_CART_BUTTON).performClick()

        // ShoppingCartScreen으로 이동했는지 확인
        composeTestRule.onNodeWithText(SHOPPING_CART_TITLE).assertIsDisplayed()
    }

    @Test
    fun 상품상셰_화면에서_뒤로가기_클릭시_상품목록_화면으로_되돌아온다() {
        // given
        val fakeData = FakeData.products
        val clickItem = fakeData[0]

        // ProductScreen에서 특정 상품 클릭
        composeTestRule.onNodeWithText(clickItem.title).performClick()

        // ProductDetailScreen 앱바에서 뒤로가기 버튼 클릭
        composeTestRule.onNodeWithContentDescription(BACK_BUTTON_DESCRIPTION).performClick()

        // ProductScreen으로 이동했는지 확인
        composeTestRule.onNodeWithText(PRODUCT_LIST_TITLE).assertIsDisplayed()
    }

    @Test
    fun 장바구니_화면에서_뒤로가기_클릭시_상품목록_화면으로_되돌아온다() {
        // 앱바의 쇼핑카트 아이콘 클릭
        composeTestRule.onNodeWithContentDescription(SHOPPING_CART_ICON_DESCRIPTION).performClick()

        // ShoppingCartScreen 앱바에서 뒤로가기 버튼 클릭
        composeTestRule.onNodeWithContentDescription(BACK_BUTTON_DESCRIPTION).performClick()

        // ProductScreen으로 이동했는지 확인
        composeTestRule.onNodeWithText(PRODUCT_LIST_TITLE).assertIsDisplayed()
    }

    @Test
    fun 상품상세_화면에서_장바구니_화면_이동후_뒤로가기_클릭시_상품상세_화면으로_돌아온다() {
        // given
        val fakeData = FakeData.products
        val clickItem = fakeData[0]

        // ProductScreen에서 특정 상품 클릭
        composeTestRule.onNodeWithText(clickItem.title).performClick()

        // ProductDetailScreen에서 장바구니 버튼 클릭
        composeTestRule.onNodeWithText(ADD_TO_CART_BUTTON).performClick()

        // ShoppingCartScreen에서 뒤로가기 버튼 클릭
        composeTestRule.onNodeWithContentDescription(BACK_BUTTON_DESCRIPTION).performClick()

        // ProductDetailScreen으로 이동했는지 확인
        composeTestRule.onNodeWithText(PRODUCT_DETAIL_TITLE).assertIsDisplayed()
    }

    companion object {
        const val PRODUCT_LIST_TITLE = "상품 목록"
        const val PRODUCT_DETAIL_TITLE = "상품 상세"
        const val SHOPPING_CART_TITLE = "장바구니"

        const val SHOPPING_CART_ICON_DESCRIPTION = "Cart"
        const val BACK_BUTTON_DESCRIPTION = "Back Button"

        const val ADD_TO_CART_BUTTON = "장바구니 담기"
    }
}