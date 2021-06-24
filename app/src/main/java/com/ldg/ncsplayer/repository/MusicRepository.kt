package com.ldg.ncsplayer.repository

import androidx.lifecycle.LiveData
import com.ldg.ncsplayer.database.MusicEntity

interface MusicRepository {



    suspend fun insertMusicEntitiesDB(musicEntity: List<MusicEntity>)

    fun getMusicList():List<MusicEntity>

    fun  requestMusicList():List<MusicEntity>
}