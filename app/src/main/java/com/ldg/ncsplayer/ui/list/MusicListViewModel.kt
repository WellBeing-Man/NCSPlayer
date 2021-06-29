package com.ldg.ncsplayer.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ldg.ncsplayer.data.Genre
import com.ldg.ncsplayer.database.MusicEntity
import com.ldg.ncsplayer.repository.MusicRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


class MusicListViewModel (private val repository: MusicRepository): ViewModel() {

    val musicEntities:LiveData<MutableList<MusicEntity>>
          get() = repository.observableMusicEntities

    val musicPageNumber:LiveData<Int>
        get() = repository.observablePageNumber

    private val currentGenre=MutableLiveData<Genre>().apply { postValue(Genre.BASS) }


    /**
     * 1. network 리퀘스트 후 local storage에 저장
     * 2. 중복 item의 경우 무시
     **/

    init {
        requestMusicToServer()
    }

    /**
     * primary list have 20 items
     * */
    fun requestMusicToServer(){
        currentGenre.value?:return
        repository.getMusicList(currentGenre.value!!)
    }


    fun insertMusicEntitiesIntoDB(musicEntities: List<MusicEntity>){


    }


    fun refresh() {
        TODO("Not yet implemented")
    }

    /**
     *
     * */
    fun requestNextMusic() {
        TODO("Not yet implemented")
    }

    fun sortListByName() {
        TODO("Not yet implemented")
    }
}