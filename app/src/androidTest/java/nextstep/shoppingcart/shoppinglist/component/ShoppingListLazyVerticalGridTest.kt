package nextstep.shoppingcart.shoppinglist.component

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import nextstep.shoppingcart.ui.shoppinglist.component.ShoppingListLazyVerticalGrid
import nextstep.shoppingcart.ui.shoppinglist.model.Product
import org.junit.Rule
import org.junit.Test

class ShoppingListLazyVerticalGridTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 쇼핑_목록은_2열로_구성되어있다() {
        // when:
        composeTestRule.apply {
            setContent {
                ShoppingListLazyVerticalGrid(
                    products = listOf(
                        Product(
                            id = 0L, name = "", imageUrl = "", price = 0L
                        ),
                        Product(
                            id = 1L, name = "", imageUrl = "", price = 0L
                        ),
                        Product(
                            id = 2L, name = "", imageUrl = "", price = 0L
                        ),
                        Product(
                            id = 3L, name = "", imageUrl = "", price = 0L
                        ),
                    )
                )
            }
        }

        // then:
        val shoppingListItems = composeTestRule
            .onAllNodesWithContentDescription("ShoppingListItem")
            .fetchSemanticsNodes()

        val shoppingListItemWidth = shoppingListItems.first().boundsInRoot.width.toLong()
        val firstRowWidth = shoppingListItems.take(2).sumOf { it.boundsInRoot.width.toLong() }
        val secondRowWidth = shoppingListItems.drop(2).sumOf { it.boundsInRoot.width.toLong() }

        assert(firstRowWidth == (shoppingListItemWidth * 2))
        assert(secondRowWidth == (shoppingListItemWidth * 2))
        assert(firstRowWidth == secondRowWidth)
    }

    @Test
    fun 아이템_4개를_추가하면_4개의_아이템이_출력된다() {
        // when:
        composeTestRule.apply {
            setContent {
                ShoppingListLazyVerticalGrid(
                    products = listOf(
                        Product(
                            id = 0L, name = "", imageUrl = "", price = 0L
                        ),
                        Product(
                            id = 1L, name = "", imageUrl = "", price = 0L
                        ),
                        Product(
                            id = 2L, name = "", imageUrl = "", price = 0L
                        ),
                        Product(
                            id = 3L, name = "", imageUrl = "", price = 0L
                        ),
                    )
                )
            }
        }

        // then:
        composeTestRule.onAllNodesWithContentDescription("ShoppingListItem").assertCountEquals(4)
    }
}
