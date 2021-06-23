package com.ldg.ncsplayer.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ldg.ncsplayer.database.MusicEntity
import com.ldg.ncsplayer.repository.MusicRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


class MusicListViewModel (private val repository: MusicRepository): ViewModel() {

    val musicEntities=repository.observeMusicEntity()


    fun deleteShoppingItem(musicEntity: MusicEntity)= viewModelScope.launch {
        repository.deleteMusicEntity(musicEntity)
    }

    fun insetShoppingItemIntoDB(musicEntity: MusicEntity)= viewModelScope.launch {
        repository.insertMusicEntityDB(musicEntity)
    }


}