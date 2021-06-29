package com.ldg.ncsplayer.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ldg.ncsplayer.database.MusicEntity
import com.ldg.ncsplayer.repository.MusicRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


class MusicListViewModel (private val repository: MusicRepository): ViewModel() {

    private val _musicEntities=MutableLiveData<List<MusicEntity>>()
    val musicEntities:LiveData<List<MusicEntity>>
          get() = _musicEntities

    /**
     * 1. network 리퀘스트 후 local storage에 저장
     * 2. 중복 item의 경우 무시
     **/

    init {
        requestMusicToServer()
    }

    fun requestMusicToServer(){
        _musicEntities.postValue(repository.requestMusicList())

    }


    fun insertMusicEntitiesIntoDB(musicEntities: List<MusicEntity>){


    }

    /**
     *
     *
     * */
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