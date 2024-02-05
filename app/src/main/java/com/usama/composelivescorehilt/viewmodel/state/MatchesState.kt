package com.usama.composelivescorehilt.viewmodel.state

import com.usama.composelivescorehilt.data.models.Match

sealed class MatchesState {
    object Empty: MatchesState()
    object Loading: MatchesState()
    class Success(val data: List<Match>): MatchesState()
    class Error(val message: String): MatchesState()
}