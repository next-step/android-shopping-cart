package nextstep.shoppingcart.ui.composable

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun DinoCenterTopAppBar(
    text: String,
    modifier: Modifier = Modifier,
    navigationBack: Boolean = false,
    actions: @Composable (RowScope.() -> Unit) = {},
) {
    val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    CenterAlignedTopAppBar(
        modifier = modifier.padding(vertical = 4.dp),
        navigationIcon = {
            if (navigationBack) {
                Image(
                    modifier = Modifier
                        .size(48.dp)
                        .clickable { onBackPressedDispatcher?.onBackPressed() }
                        .padding(10.dp),
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.navigation_back)
                )
            }
        },
        title = {
            Text(text = text)
        },
        actions = actions,
    )
}
