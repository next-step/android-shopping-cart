package nextstep.shoppingcart.products.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.products.ProductItemUiState
import nextstep.shoppingcart.products.StubProductItemUiStates

@Composable
fun GridProductItems(
    productItemUiStates: List<ProductItemUiState>,
    onItemClick: (ProductItemUiState) -> Unit,
    onFloatingButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val pairsOfProductItemUiStates = productItemUiStates.chunked(2)

    LazyColumn(
        modifier = modifier
            .padding(horizontal = 18.dp)
            .padding(top = 13.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        items(pairsOfProductItemUiStates) {
            TwoProductItemInRow(
                productItemUiStates = it,
                onItemClick = onItemClick,
                onFloatingButtonClick = onFloatingButtonClick,
            )
        }
    }
}

@Composable
private fun TwoProductItemInRow(
    productItemUiStates: List<ProductItemUiState>,
    onItemClick: (ProductItemUiState) -> Unit,
    onFloatingButtonClick: () -> Unit,
) {
    if (productItemUiStates.isEmpty()) {
        return
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {

        ProductsItem(
            modifier = Modifier.weight(1f),
            productItemUiState = productItemUiStates[0],
            onItemClick = onItemClick,
            onFloatingButtonClick = onFloatingButtonClick,
        )

        if (productItemUiStates.size == 1) {
            Box(modifier = Modifier.weight(1f))
        }

        if (productItemUiStates.size == 2) {
            ProductsItem(
                modifier = Modifier.weight(1f),
                productItemUiState = productItemUiStates[1],
                onItemClick = onItemClick,
                onFloatingButtonClick = onFloatingButtonClick,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun GridProductItemsPreview() {
    GridProductItems(
        productItemUiStates = StubProductItemUiStates,
        onItemClick = {},
        onFloatingButtonClick = {},
    )
}
