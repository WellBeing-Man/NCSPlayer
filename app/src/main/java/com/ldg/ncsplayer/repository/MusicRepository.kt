package com.ldg.ncsplayer.repository

import androidx.lifecycle.LiveData
import com.ldg.ncsplayer.database.MusicEntity

interface MusicRepository {

    suspend fun insertMusicEntityDB(musicEntity: MusicEntity)

    suspend fun deleteMusicEntity(musicEntity: MusicEntity)

    fun observeMusicEntity():LiveData<List<MusicEntity>>

}