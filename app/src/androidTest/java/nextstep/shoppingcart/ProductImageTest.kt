package nextstep.shoppingcart

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.test.platform.app.InstrumentationRegistry
import coil3.ImageLoader
import coil3.asImage
import coil3.compose.AsyncImagePainter
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ErrorResult
import coil3.request.SuccessResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import nextstep.shoppingcart.designsystem.component.ProductImage
import nextstep.shoppingcart.model.Product
import org.junit.Rule
import org.junit.Test

class ProductImageTest {

    private val context = InstrumentationRegistry.getInstrumentation().context


    @get:Rule
    val composeTestRule = createComposeRule()


    @Test
    fun should_show_circle_progress_indicator_when_state_is_empty() {

        //given
        val mockProduct = Product(
            id = 1,
            name = "test",
            price = 10000,
            imageUrl = "test",
        )

        val asyncImagePainterStateFlow =
            MutableStateFlow<AsyncImagePainter.State>(AsyncImagePainter.State.Empty)


        //when
        composeTestRule.setContent {
            ProductImage(
                item = mockProduct,
                painter = rememberAsyncImagePainter(
                    model = "test",
                    transform = { AsyncImagePainter.State.Empty },
                    onState = { state ->
                        asyncImagePainterStateFlow.update { state }
                    }),
            )
        }
        composeTestRule.waitUntil {
            asyncImagePainterStateFlow.value is AsyncImagePainter.State.Empty
        }


        //then
        composeTestRule.onNodeWithTag("product_image_loading")
            .assertIsDisplayed()
    }

    @Test
    fun should_show_circle_progress_indicator_when_state_is_loading() {

        //given
        val mockProduct = Product(
            id = 2,
            name = "test2",
            price = 10000,
            imageUrl = "test42",
        )

        val asyncImagePainterStateFlow =
            MutableStateFlow<AsyncImagePainter.State>(AsyncImagePainter.State.Empty)


        //when
        composeTestRule.setContent {
            ProductImage(
                item = mockProduct,
                painter = rememberAsyncImagePainter(
                    model = "test42",
                    transform = { AsyncImagePainter.State.Loading(null) },
                    onState = { state ->
                        asyncImagePainterStateFlow.update { state }
                    }),
            )
        }
        composeTestRule.waitUntil {
            asyncImagePainterStateFlow.value is AsyncImagePainter.State.Loading
        }


        //then
        composeTestRule.onNodeWithTag("product_image_loading")
            .assertIsDisplayed()
    }

    @Test
    fun should_show_image_when_state_is_success() {

        //given
        val mockProduct = Product(
            id = 3,
            name = "test3",
            price = 10000,
            imageUrl = "test3",
        )

        val mockImageLoader = ImageLoader.Builder(context).components {
            add { chain ->
                val drawable = ColorDrawable(Color.BLUE)
                SuccessResult(
                    image = drawable.asImage(),
                    request = chain.request,
                )
            }
        }.build()

        val asyncImagePainterStateFlow =
            MutableStateFlow<AsyncImagePainter.State>(AsyncImagePainter.State.Empty)


        //when
        composeTestRule.setContent {
            ProductImage(
                item = mockProduct,
                painter = rememberAsyncImagePainter(
                    model = "test3",
                    imageLoader = mockImageLoader,
                    onState = { state ->
                        asyncImagePainterStateFlow.update { state }
                    }),
            )
        }
        composeTestRule.waitUntil {
            asyncImagePainterStateFlow.value is AsyncImagePainter.State.Success
        }


        //then
        composeTestRule.onNodeWithContentDescription("product_image")
            .assertIsDisplayed()
    }

    @Test
    fun should_show_error_text_indicator_when_state_is_error() {

        //given
        val mockProduct = Product(
            id = 4,
            name = "test4",
            price = 10000,
            imageUrl = "test4",
        )

        val mockImageLoader = ImageLoader.Builder(context).components {
            add { chain ->
                ErrorResult(
                    image = null,
                    request = chain.request,
                    throwable = Throwable()
                )
            }
        }.build()

        val asyncImagePainterStateFlow =
            MutableStateFlow<AsyncImagePainter.State>(AsyncImagePainter.State.Empty)

        //when
        composeTestRule.setContent {
            ProductImage(
                item = mockProduct,
                painter = rememberAsyncImagePainter(
                    model = "test4",
                    imageLoader = mockImageLoader,
                    onState = { state ->
                        asyncImagePainterStateFlow.update { state }
                    }),
            )
        }
        composeTestRule.waitUntil {
            asyncImagePainterStateFlow.value is AsyncImagePainter.State.Error
        }

        //then
        composeTestRule.onNodeWithText("product_image_error")
            .assertIsDisplayed()
    }
}