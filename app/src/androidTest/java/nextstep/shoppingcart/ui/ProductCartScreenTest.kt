package nextstep.shoppingcart.ui

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollToNode
import nextstep.shoppingcart.model.Cart
import nextstep.shoppingcart.model.ProductModel
import nextstep.shoppingcart.model.dummyProducts
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ProductCartScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val product = ProductModel(
        id = 1,
        name = "사이다",
        price = 2_000,
        imageUrl = "http://www.bing.com/search?q=nominavi",
    )

    private val addButton get() = composeTestRule.onNodeWithContentDescription("담기")
    private val removeButton get() = composeTestRule.onNodeWithContentDescription("제거")
    private val clearButton get() = composeTestRule.onNodeWithContentDescription("삭제")

    private var items by mutableStateOf(Cart.items)

    @Before
    fun setup() {
        Cart.init()
    }

    private fun setContentScreen() {
        composeTestRule.setContent {
            val updatedTime by remember { Cart.updateTime }
            LaunchedEffect(updatedTime) { items = Cart.items }

            ProductCartScreen(
                items = items,
                onBackButtonClick = {},
            )
        }
    }

    @Test
    fun 장바구니_목록에_모든_아이템_노출() {
        // given
        dummyProducts.forEach {
            Cart.addOne(it)
        }
        setContentScreen()

        // then
        val productList = composeTestRule
            .onNodeWithTag("productCartLazyColumn")

        items.forEach { item ->
            productList
                .performScrollToNode(hasText(item.name))
                .assertIsDisplayed()
        }
    }

    @Test
    fun 장바구니에_담긴_상품이_하나라도_있다면_장바구니담기_버튼_활성화_되고_총합이_노출() {
        // given
        Cart.addOne(product)
        setContentScreen()

        // then
        composeTestRule
            .onNodeWithText("주문하기(2,000원)")
            .assertIsDisplayed()
            .assertIsEnabled()
    }


    @Test
    fun 담긴_상품의_삭제_버튼_클릭시_목록에서_아이템_목록에서_미노출_되고_변경된_총합_노출() {
        // given
        Cart.addOne(product)
        setContentScreen()

        // when
        clearButton.performClick()

        // then
        composeTestRule
            .onNodeWithText("사이다")
            .assertIsNotDisplayed()
        composeTestRule
            .onNodeWithText("주문하기(0원)")
            .assertIsDisplayed()
            .assertIsNotEnabled()
    }

    @Test
    fun 담긴_상품의_수량이_2_이상일_경우_제거_버튼_클릭시_변경된_총합_노출() {
        // given
        repeat(3) { Cart.addOne(product) }
        setContentScreen()

        // when
        removeButton.performClick()

        // then
        composeTestRule
            .onNodeWithText("주문하기(4,000원)")
            .assertIsDisplayed()
            .assertIsEnabled()
    }

    @Test
    fun 담긴_상품의_갯수가_1_일_경우_제거_버튼_클릭시_아이템_목록에서_미노출_되고_변경된_총합_노출() {
        // given
        Cart.addOne(product)
        setContentScreen()

        // when
        removeButton.performClick()

        // then
        composeTestRule.onNodeWithText("사이다")
            .assertIsNotDisplayed()
        composeTestRule
            .onNodeWithText("주문하기(0원)")
            .assertIsDisplayed()
    }

    @Test
    fun 담긴_상품의_담기_버튼_클릭시_수량_1_증가되고_변경된_총합_노출() {
        // given
        Cart.addOne(product)
        setContentScreen()

        // when
        addButton.performClick()

        // then
        composeTestRule
            .onNodeWithText("주문하기(4,000원)")
            .assertIsDisplayed()
    }

    @Test
    fun 담긴상품이_하나도_없다면_장바구니담기_버튼_비활성화() {
        // given
        setContentScreen()

        // then
        composeTestRule
            .onNodeWithText("주문하기", substring = true)
            .assertIsNotEnabled()
    }
}