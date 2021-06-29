package com.ldg.ncsplayer.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.ldg.ncsplayer.MainCoroutineRule
import com.ldg.ncsplayer.data.Genre
import com.ldg.ncsplayer.database.MusicEntity
import com.ldg.ncsplayer.getOrAwaitValueTest
import com.ldg.ncsplayer.repository.FakeMusicRepository
import com.ldg.ncsplayer.ui.list.MusicListViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class MusicRepositoryTest {

    @get:Rule
    var instantExecutorRule= InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule= MainCoroutineRule()

    private lateinit var musicRepository: FakeMusicRepository

    private lateinit var genre: Genre
    private var pageNo:Int = 0
    /**
     fakerepo에 있는 정보
    musicRequestResponses.add(MusicEntity(1L,"Song1","surl1","artist1","curl1","bass","fear","21 jan 2020"))
    musicRequestResponses.add(MusicEntity(2L,"Song2","surl2","artist2","curl2","chill","gloomy","31 jan 2020"))
    musicRequestResponses.add(MusicEntity(3L,"Song3","surl3","artist3","curl3","trap","energetic","21 feb 2020"))
    musicRequestResponses.add(MusicEntity(4L,"Song4","surl4","artist4","curl4","bass","cool","11 may 2020"))
    musicRequestResponses.add(MusicEntity(5L,"Song5","surl5","artist5","curl5","chill","calm","13 jan 2021"))

     * */
    @Before
    fun setUp() {
        musicRepository=FakeMusicRepository()
        pageNo=0
        genre=Genre.BASS
        musicRepository.getMusicList(genre)
        pageNo++
    }



    @Test
    fun `primary repo have 20 items`(){
        //given when
        val list= musicRepository.observableMusicEntities.getOrAwaitValueTest().toList()
        assertThat(list.size).isEqualTo(20)
    }

    @Test
    fun `if request next item repo add 20 items`(){
        //given
        val list= musicRepository.observableMusicEntities.getOrAwaitValueTest().toList()
        //when
        assertThat(list.size).isEqualTo(20)
        musicRepository.requestNextMusicList(genre, pageNo)
        //then
        val compare=musicRepository.observableMusicEntities.getOrAwaitValueTest().toList()
        assertThat(list.size+20).isEqualTo(compare.size)
        for(i in list.indices){
            assertThat(list[i].id).isEqualTo(compare[i].id)
        }
    }



}