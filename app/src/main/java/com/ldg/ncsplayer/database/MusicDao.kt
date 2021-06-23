package com.ldg.ncsplayer.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface MusicDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShoppingItem(musicEntity: MusicEntity)

    @Query("Select * from musics")
    fun observeAllShoppingItem(): LiveData<List<MusicEntity>>
}