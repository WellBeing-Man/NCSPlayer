package com.ldg.ncsplayer.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ldg.ncsplayer.data.Genre
import com.ldg.ncsplayer.database.MusicEntity

interface MusicRepository {

    val observableMusicEntities : MutableLiveData<MutableList<MusicEntity>>
    val observablePageNumber:MutableLiveData<Int>
    fun getMusicList(genre: Genre)

    fun  requestNextMusicList(genre: Genre,pageNo:Int)
}