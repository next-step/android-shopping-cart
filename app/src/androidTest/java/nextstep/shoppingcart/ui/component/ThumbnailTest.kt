package nextstep.shoppingcart.ui.component

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import org.junit.Rule
import org.junit.Test

class ThumbnailTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 이미지_노출() {
        // given
        val imageUrl =
            "https://fastly.picsum.photos/id/482/200/300.jpg?hmac=sZqH9D718kRNYORntdoWP-EehCC83NaK3M-KTWvABIg"
        val name = "나무"
        composeTestRule.setContent {
            Thumbnail(
                id = 0L,
                imageUrl = imageUrl,
                name = name,
            )
        }

        // then
        composeTestRule
            .onNodeWithContentDescription("나무 이미지")
            .assertIsDisplayed()
    }
}