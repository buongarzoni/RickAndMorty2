package com.rickAndMorty.list.feature.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rickAndMorty.list.feature.domain.CharacterUI
import com.rickAndMorty.list.feature.presentation.ListPresenter
import com.rickAndMorty.list.feature.presentation.ListPresenterPreview

@Composable
fun CharactersList(
    presenter: ListPresenter,
) = LazyColumn {
    val characters = presenter.characters.value

    if(characters == null) {
        repeat(3) {
            item{ LoadingCard() }
        }
    } else {
        items(characters) {
            CharacterCard(it)
        }
    }
}
@Composable
private fun LoadingCard() = Surface(
    modifier = Modifier.fillMaxWidth(),
) {
    Column(
        modifier = Modifier.padding(8.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(Modifier.size(120.dp).background(MaterialTheme.colorScheme.primary))
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Box(Modifier.fillMaxWidth().height(16.dp).background(MaterialTheme.colorScheme.primary))
                Box(Modifier.fillMaxWidth(0.8f).height(16.dp).background(MaterialTheme.colorScheme.primary))
            }
        }
    }
}

@Composable
private fun CharacterCard(characterUI: CharacterUI) = Surface(
    modifier = Modifier.fillMaxWidth(),
) {
    Column(
        modifier = Modifier.padding(8.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(Modifier.size(120.dp).background(MaterialTheme.colorScheme.primary))
            Column {
                Text(characterUI.name)
                Text(characterUI.status)
            }
        }
    }
}

@Preview
@Composable
fun LoadingCharactersPreview() = CharactersList(ListPresenterPreview())

@Preview
@Composable
fun CharactersPreview() = CharactersList(
    ListPresenterPreview(
        characters = listOf(
            CharacterUI(
                name = "Pepe",
                status = "Alive",
                imageUrl = "www.google.com",
            ),
            CharacterUI(
                name = "Pepe 2",
                status = "dead",
                imageUrl = "www.google.com",
            ),
        )
    )
)
