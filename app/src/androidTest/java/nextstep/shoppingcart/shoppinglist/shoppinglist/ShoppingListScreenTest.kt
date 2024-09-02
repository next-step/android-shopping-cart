package nextstep.shoppingcart.shoppinglist.shoppinglist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.ui.shoppinglist.ShoppingListScreen
import nextstep.shoppingcart.ui.shoppinglist.model.Product
import org.junit.Rule
import org.junit.Test

class ShoppingListScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 상품의_담기_버튼을_누르면_수량조절_버튼이_노출된다() {
        // given:
        var products by mutableStateOf(
            listOf(
                Product(
                    id = 0L,
                    name = "테스트1",
                    imageUrl = "",
                    price = 110L,
                    containedCount = 0,
                )
            )
        )

        composeTestRule.apply {
            setContent {
                ShoppingListScreen(
                    products = products,
                    onShoppingCartClick = {},
                    onItemClick = {},
                    onPutClick = { selectedProductId ->
                        products = products.map { product ->
                            if (selectedProductId == product.id) product.copy(
                                containedCount = product.containedCount + 1
                            ) else product
                        }
                    },
                    onAddClick = {},
                    onSubtractClick = {},
                )
            }
        }

        // when:
        composeTestRule.onNodeWithContentDescription("shoppingProductAddButtonDescription")
            .performClick()

        // then:
        composeTestRule.onNodeWithContentDescription("shoppingCountBarDescription")
            .assertIsDisplayed()
    }

    @Test
    fun 담긴_상품의_수량이_1개_미만일_경우_수량조절_버튼이_사라지고_담기버튼이_노출된다() {
        // given:
        var products by mutableStateOf(
            listOf(
                Product(
                    id = 0L,
                    name = "테스트1",
                    imageUrl = "",
                    price = 110L,
                    containedCount = 1,
                )
            )
        )

        composeTestRule.apply {
            setContent {
                ShoppingListScreen(
                    products = products,
                    onShoppingCartClick = {},
                    onItemClick = {},
                    onPutClick = {},
                    onAddClick = {},
                    onSubtractClick = { selectedProductId ->
                        products = products.map { product ->
                            if (selectedProductId == product.id) product.copy(
                                containedCount = product.containedCount - 1
                            ) else product
                        }
                    },
                )
            }
        }

        // when:
        composeTestRule.onNodeWithContentDescription("ShoppingCountBarSubtractIcon").performClick()

        // then:
        composeTestRule.onNodeWithContentDescription("ShoppingProductAddButton")
            .assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("shoppingCountBarDescription")
            .assertIsNotDisplayed()
    }

    @Test
    fun 담긴_상품의_수량이_2개일_경우_추가담기_버튼을_누르면_3개가_된다() {
        // given:
        var products by mutableStateOf(
            listOf(
                Product(
                    id = 0L,
                    name = "테스트1",
                    imageUrl = "",
                    price = 110L,
                    containedCount = 2,
                )
            )
        )

        composeTestRule.apply {
            setContent {
                ShoppingListScreen(
                    products = products,
                    onShoppingCartClick = {},
                    onItemClick = {},
                    onPutClick = {},
                    onAddClick = { selectedProductId ->
                        products = products.map { product ->
                            if (selectedProductId == product.id) product.copy(
                                containedCount = product.containedCount + 1
                            ) else product
                        }
                    },
                    onSubtractClick = {},
                )
            }
        }

        // when:
        composeTestRule.onNodeWithContentDescription("ShoppingCountBarAddIcon").performClick()

        // then:
        composeTestRule.onNodeWithText("3").isDisplayed()
    }
}
