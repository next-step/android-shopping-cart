package nextstep.shoppingcart.model

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

object CountState {
    private val _uiState = MutableStateFlow<Boolean>(false)
    val uiState: StateFlow<Boolean> = _uiState.asStateFlow()

    fun setUiState(state: Boolean) {
        _uiState.value = state
    }
}
