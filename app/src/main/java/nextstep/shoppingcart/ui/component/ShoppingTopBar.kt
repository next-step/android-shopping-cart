package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.RobotoRegular

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingTopBar(
    title: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val shoppingTopBarBackIcon = stringResource(R.string.shopping_top_bar_icon)

    TopAppBar(
        title = {
            Text(
                text = title,
                fontSize = 22.sp,
                fontFamily = RobotoRegular,
                modifier = Modifier.padding(vertical = 18.dp),
            )
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = shoppingTopBarBackIcon,
                modifier = Modifier
                    .padding(14.dp)
                    .clickable { onBackClick() }
                    .semantics { contentDescription = shoppingTopBarBackIcon },
            )
        },
        modifier = modifier,
    )
}
