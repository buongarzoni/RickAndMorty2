package com.rickAndMorty.list.feature.presentation

import androidx.compose.runtime.State
import com.rickAndMorty.list.feature.domain.CharacterUI

interface ListPresenter {
    val characters: State<List<CharacterUI>?>
}
