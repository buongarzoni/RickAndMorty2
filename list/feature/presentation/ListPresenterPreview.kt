package com.rickAndMorty.list.feature.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.rickAndMorty.list.feature.domain.CharacterUI

class ListPresenterPreview(
    characters: List<CharacterUI>? = null,
): ListPresenter {
    override val characters: State<List<CharacterUI>?> = mutableStateOf(characters)
}
