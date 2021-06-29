package com.ldg.ncsplayer.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ldg.ncsplayer.data.Genre
import com.ldg.ncsplayer.database.MusicEntity

class FakeMusicRepository:MusicRepository {


    override val observableMusicEntities= MutableLiveData<MutableList<MusicEntity>>()



    override val observablePageNumber= MutableLiveData<Int>().apply { postValue(0) }



    override fun getMusicList(genre: Genre){

        observableMusicEntities.value?.clear()

        val newList= mutableListOf<MusicEntity>()
        newList.add(MusicEntity(1L,"Song1","surl1","artist1","curl1",genre.name,"fear","21 jan 2020"))
        newList.add(MusicEntity(2L,"Song2","surl2","artist2","curl2",genre.name,"gloomy","31 jan 2020"))
        newList.add(MusicEntity(3L,"Song3","surl3","artist3","curl3",genre.name,"energetic","21 feb 2020"))
        newList.add(MusicEntity(4L,"Song4","surl4","artist4","curl4",genre.name,"cool","11 may 2020"))
        newList.add(MusicEntity(5L,"Song5","surl5","artist5","curl5",genre.name,"calm","13 jan 2021"))
        newList.add(MusicEntity(6L,"Song6","surl1","artist1","curl1",genre.name,"fear","21 jan 2020"))
        newList.add(MusicEntity(7L,"Song7","surl2","artist2","curl2",genre.name,"gloomy","31 jan 2020"))
        newList.add(MusicEntity(8L,"Song8","surl3","artist3","curl3",genre.name,"energetic","21 feb 2020"))
        newList.add(MusicEntity(9L,"Song9","surl4","artist4","curl4",genre.name,"cool","11 may 2020"))
        newList.add(MusicEntity(10L,"Song10","surl5","artist5","curl5",genre.name,"calm","13 jan 2021"))
        newList.add(MusicEntity(11L,"Song11","surl1","artist1","curl1",genre.name,"fear","21 jan 2020"))
        newList.add(MusicEntity(12L,"Song12","surl2","artist2","curl2",genre.name,"gloomy","31 jan 2020"))
        newList.add(MusicEntity(13L,"Song13","surl3","artist3","curl3",genre.name,"energetic","21 feb 2020"))
        newList.add(MusicEntity(14L,"Song14","surl4","artist4","curl4",genre.name,"cool","11 may 2020"))
        newList.add(MusicEntity(15L,"Song15","surl5","artist5","curl5",genre.name,"calm","13 jan 2021"))
        newList.add(MusicEntity(16L,"Song16","surl1","artist1","curl1",genre.name,"fear","21 jan 2020"))
        newList.add(MusicEntity(17L,"Song17","surl2","artist2","curl2",genre.name,"gloomy","31 jan 2020"))
        newList.add(MusicEntity(18L,"Song18","surl3","artist3","curl3",genre.name,"energetic","21 feb 2020"))
        newList.add(MusicEntity(19L,"Song19","surl4","artist4","curl4",genre.name,"cool","11 may 2020"))
        newList.add(MusicEntity(20L,"Song20","surl5","artist5","curl5",genre.name,"calm","13 jan 2021"))
        addList(newList)
    }

    private fun addList(newList: MutableList<MusicEntity>) {
        observableMusicEntities.postValue(newList)
        observablePageNumber.postValue(observablePageNumber.value?.plus(1))
    }


    override fun requestNextMusicList(genre: Genre, pageNo: Int) {
        val nextList= mutableListOf<MusicEntity>()
        val numberOfPage=pageNo*20
        nextList.add(MusicEntity(numberOfPage+1L,"Song${numberOfPage+1}","surl1","artist1","curl1",genre.name,"fear","21 jan 2020"))
        nextList.add(MusicEntity(numberOfPage+2L,"Song${numberOfPage+2}","surl2","artist2","curl2",genre.name,"gloomy","31 jan 2020"))
        nextList.add(MusicEntity(numberOfPage+3L,"Song${numberOfPage+3}","surl3","artist3","curl3",genre.name,"energetic","21 feb 2020"))
        nextList.add(MusicEntity(numberOfPage+4L,"Song${numberOfPage+4}","surl4","artist4","curl4",genre.name,"cool","11 may 2020"))
        nextList.add(MusicEntity(numberOfPage+5L,"Song${numberOfPage+5}","surl5","artist5","curl5",genre.name,"calm","13 jan 2021"))
        nextList.add(MusicEntity(numberOfPage+6L,"Song${numberOfPage+6}","surl1","artist1","curl1",genre.name,"fear","21 jan 2020"))
        nextList.add(MusicEntity(numberOfPage+7L,"Song${numberOfPage+7}","surl2","artist2","curl2",genre.name,"gloomy","31 jan 2020"))
        nextList.add(MusicEntity(numberOfPage+8L,"Song${numberOfPage+8}","surl3","artist3","curl3",genre.name,"energetic","21 feb 2020"))
        nextList.add(MusicEntity(numberOfPage+9L,"Song${numberOfPage+9}","surl4","artist4","curl4",genre.name,"cool","11 may 2020"))
        nextList.add(MusicEntity(numberOfPage+10L,"Song${numberOfPage+10}","surl5","artist5","curl5",genre.name,"calm","13 jan 2021"))
        nextList.add(MusicEntity(numberOfPage+11L,"Song${numberOfPage+11}","surl1","artist1","curl1",genre.name,"fear","21 jan 2020"))
        nextList.add(MusicEntity(numberOfPage+12L,"Song${numberOfPage+12}","surl2","artist2","curl2",genre.name,"gloomy","31 jan 2020"))
        nextList.add(MusicEntity(numberOfPage+13L,"Song${numberOfPage+13}","surl3","artist3","curl3",genre.name,"energetic","21 feb 2020"))
        nextList.add(MusicEntity(numberOfPage+14L,"Song${numberOfPage+14}","surl4","artist4","curl4",genre.name,"cool","11 may 2020"))
        nextList.add(MusicEntity(numberOfPage+15L,"Song${numberOfPage+15}","surl5","artist5","curl5",genre.name,"calm","13 jan 2021"))
        nextList.add(MusicEntity(numberOfPage+16L,"Song${numberOfPage+16}","surl1","artist1","curl1",genre.name,"fear","21 jan 2020"))
        nextList.add(MusicEntity(numberOfPage+17L,"Song${numberOfPage+17}","surl2","artist2","curl2",genre.name,"gloomy","31 jan 2020"))
        nextList.add(MusicEntity(numberOfPage+18L,"Song${numberOfPage+18}","surl3","artist3","curl3",genre.name,"energetic","21 feb 2020"))
        nextList.add(MusicEntity(numberOfPage+19L,"Song${numberOfPage+19}","surl4","artist4","curl4",genre.name,"cool","11 may 2020"))
        nextList.add(MusicEntity(numberOfPage+20L,"Song${numberOfPage+20}","surl5","artist5","curl5",genre.name,"calm","13 jan 2021"))
        observableMusicEntities.value?.addAll(nextList)

    }
}