package nextstep.shoppingcart.component

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.data.model.Product
import nextstep.shoppingcart.data.repository.CartRepository
import nextstep.shoppingcart.ui.ProductCartScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ProductCartScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val orderButtonNode
        get() = composeTestRule
            .onNodeWithText("주문하기", substring = true)

    private val cartItemNode
        get() = composeTestRule
            .onNodeWithTag("ProductCartItem")

    private val decreaseButtonNode
        get() = composeTestRule
            .onNodeWithTag("상품1_decrease_button")

    private val product =
        Product(
            id = 1,
            imageUrl = "",
            name = "상품1",
            price = 2000,
        )

    @Before
    fun setUp() {
        CartRepository.reset()
    }

    @Test
    fun `담긴_상품_가격의_총합이_노출된다`() {
        CartRepository.addOne(product)
        CartRepository.addOne(product)

        composeTestRule
            .setContent {
                ProductCartScreen(
                    onBackButtonClick = { }
                )
            }

        composeTestRule
            .onNodeWithText("주문하기(4,000원)")
            .assertIsDisplayed()
    }

    @Test
    fun `담긴_상품을_제거할_수_있다`() {
        CartRepository.addOne(product)

        composeTestRule
            .setContent {
                ProductCartScreen(
                    onBackButtonClick = { }
                )
            }

        composeTestRule
            .onNodeWithTag("상품1_remove_button")
            .performClick()

        cartItemNode
            .assertIsNotDisplayed()
    }

    @Test
    fun `담긴_상품의_수량을_증가시키면_상품_가격에_반영된다`() {
        CartRepository.addOne(product)

        composeTestRule
            .setContent {
                ProductCartScreen(
                    onBackButtonClick = { }
                )
            }

        composeTestRule
            .onNodeWithTag("상품1_increase_button")
            .performClick()
            .performClick()

        composeTestRule
            .onNodeWithText("주문하기(6,000원)")
            .assertIsDisplayed()
    }

    @Test
    fun `담긴_상품의_수량을_감소시키면_상품_가격에_반영된다`() {
        CartRepository.addOne(product)
        CartRepository.addOne(product)

        composeTestRule
            .setContent {
                ProductCartScreen(
                    onBackButtonClick = { }
                )
            }

        decreaseButtonNode
            .performClick()

        composeTestRule
            .onNodeWithText("주문하기(2,000원)")
            .assertIsDisplayed()
    }

    @Test
    fun `담긴_상품의_수량을_1보다_적게_하면_상품이_삭제된다`() {
        CartRepository.addOne(product)

        composeTestRule
            .setContent {
                ProductCartScreen(
                    onBackButtonClick = { }
                )
            }

        decreaseButtonNode
            .performClick()

        cartItemNode
            .assertIsNotDisplayed()
    }

    @Test
    fun `상품의_종류별로_항목이_생긴다`() {
        CartRepository.addOne(Product(id = 1, "", "상품1", 1000))
        CartRepository.addOne(Product(id = 2, "", "상품2", 1000))
        CartRepository.addOne(Product(id = 3, "", "상품3", 1000))

        composeTestRule
            .setContent {
                ProductCartScreen(
                    onBackButtonClick = { }
                )
            }

        composeTestRule
            .onAllNodesWithTag("ProductCartItem")
            .assertCountEquals(3)
    }

    @Test
    fun `담겨진_상품이_없으면_주문하기_버튼이_비활성화_된다`() {
        composeTestRule
            .setContent {
                ProductCartScreen(
                    onBackButtonClick = { }
                )
            }

        orderButtonNode
            .assertIsNotEnabled()
    }

    @Test
    fun `담겨진_상품이_있으면_주문하기_버튼이_활성화_된다`() {
        CartRepository.addOne(product)

        composeTestRule
            .setContent {
                ProductCartScreen(
                    onBackButtonClick = { }
                )
            }

        orderButtonNode
            .assertIsEnabled()
    }
}
