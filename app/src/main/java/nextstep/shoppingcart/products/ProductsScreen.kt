package nextstep.shoppingcart.products

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.grey10

@Composable
private fun ProductsTopAppBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
    ) {
        Spacer(
            modifier = Modifier
                .padding(12.dp)
                .size(24.dp)
        )
        Text(
            text = stringResource(R.string.products_top_bar_title),
            color = grey10,
            fontWeight = FontWeight.W400,
            style = MaterialTheme.typography.bodyLarge,
        )
        Icon(
            painter = painterResource(R.drawable.ic_shopping_cart),
            contentDescription = "장바구니",
            modifier = Modifier
                .clickable(onClick = {})
                .padding(12.dp)
                .size(24.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductsTopBarPreview() {
    MaterialTheme {
        ProductsTopAppBar()
    }
}
