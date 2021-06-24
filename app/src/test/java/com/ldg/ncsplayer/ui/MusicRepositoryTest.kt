package com.ldg.ncsplayer.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.ldg.ncsplayer.MainCoroutineRule
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
    }

    @After
    fun tearDown() {

    }

    @Test
    fun `만일 중복된 음악 id가 insert된다면 무시`()= runBlockingTest{

        //given
        val origin= musicRepository.observableMusicEntities.getOrAwaitValueTest().size

        val newResponse= mutableListOf<MusicEntity>()
        newResponse.add(MusicEntity(1L,"Song1","surl1","artist1","curl1","bass","fear","21 jan 2020"))
        newResponse.add(MusicEntity(2L,"Song2","surl2","artist2","curl2","chill","gloomy","31 jan 2020"))
        newResponse.add(MusicEntity(3L,"Song3","surl3","artist3","curl3","trap","energetic","21 feb 2020"))
        newResponse.add(MusicEntity(4L,"Song4","surl4","artist4","curl4","bass","cool","11 may 2020"))
        newResponse.add(MusicEntity(5L,"Song5","surl5","artist5","curl5","chill","calm","13 jan 2021"))


        //when
            musicRepository.insertMusicEntitiesDB(newResponse)

        //then
        val compare=musicRepository.observableMusicEntities.getOrAwaitValueTest().size
        assertThat(origin!=compare).isFalse()


    }

    @Test
    fun `새로운 리스트가 들어오고, id값이 중복이 아니라면 insert 성공`()= runBlockingTest{
        //given
        val origin= musicRepository.observableMusicEntities.getOrAwaitValueTest().size

        val newResponse= mutableListOf<MusicEntity>()
        newResponse.add(MusicEntity(6L,"Song1","surl1","artist1","curl1","bass","fear","21 jan 2020"))
        newResponse.add(MusicEntity(7L,"Song2","surl2","artist2","curl2","chill","gloomy","31 jan 2020"))
        newResponse.add(MusicEntity(8L,"Song3","surl3","artist3","curl3","trap","energetic","21 feb 2020"))
        newResponse.add(MusicEntity(9L,"Song4","surl4","artist4","curl4","bass","cool","11 may 2020"))
        newResponse.add(MusicEntity(10L,"Song5","surl5","artist5","curl5","chill","calm","13 jan 2021"))


        //when
            musicRepository.insertMusicEntitiesDB(newResponse)

        //then
        val compare=musicRepository.observableMusicEntities.getOrAwaitValueTest().size
        assertThat(origin+5).isEqualTo(compare)
    }



}