package nextstep.shoppingcart.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import nextstep.shoppingcart.designsystem.theme.ShoppingCartTheme

abstract class BaseComponentActivity : ComponentActivity() {

    protected abstract val rootComponent: @Composable () -> Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                rootComponent()
            }
        }
    }

    protected fun onBack() {
        onBackPressedDispatcher.onBackPressed()
    }
}