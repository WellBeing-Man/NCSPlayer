package com.ldg.ncsplayer.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ldg.ncsplayer.database.MusicEntity

class FakeMusicRepository:MusicRepository {

    private val musicEntities= mutableListOf<MusicEntity>()

    private val _observableMusicEntities = MutableLiveData<List<MusicEntity>>(musicEntities)
    val observableMusicEntities : LiveData<List<MusicEntity>>
            get()=_observableMusicEntities


    init {
        musicEntities.addAll(requestMusicList())
        refreshLiveData()

    }
    override suspend fun insertMusicEntitiesDB(entities: List<MusicEntity>) {
        for (entity in entities) {
            if(musicEntities.contains(entity).not())
                musicEntities.add(entity)
        }
        refreshLiveData()
    }

    override fun getMusicList(): List<MusicEntity> {
        return musicEntities
    }


    override fun requestMusicList():List<MusicEntity> {
        val musicRequestResponses= mutableListOf<MusicEntity>()
        musicRequestResponses.add(MusicEntity(1L,"Song1","surl1","artist1","curl1","bass","fear","21 jan 2020"))
        musicRequestResponses.add(MusicEntity(2L,"Song2","surl2","artist2","curl2","chill","gloomy","31 jan 2020"))
        musicRequestResponses.add(MusicEntity(3L,"Song3","surl3","artist3","curl3","trap","energetic","21 feb 2020"))
        musicRequestResponses.add(MusicEntity(4L,"Song4","surl4","artist4","curl4","bass","cool","11 may 2020"))
        musicRequestResponses.add(MusicEntity(5L,"Song5","surl5","artist5","curl5","chill","calm","13 jan 2021"))

       return musicRequestResponses
    }

    private fun refreshLiveData(){
        _observableMusicEntities.postValue(musicEntities)
    }
}