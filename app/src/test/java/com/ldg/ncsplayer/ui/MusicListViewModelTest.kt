package com.ldg.ncsplayer.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.ldg.ncsplayer.MainCoroutineRule
import com.ldg.ncsplayer.getOrAwaitValueTest
import com.ldg.ncsplayer.repository.FakeMusicRepository
import com.ldg.ncsplayer.ui.list.MusicListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class MusicListViewModelTest {

    @get:Rule
    var instantExecutorRule= InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule= MainCoroutineRule()


    private lateinit var viewModel:MusicListViewModel

    @Before
    fun setUp() {
        viewModel= MusicListViewModel(FakeMusicRepository())
    }

    @Test
    fun `when view model created, there is 10 items in list`(){
        //when given
        val list=viewModel.musicEntities.getOrAwaitValueTest()
        //then
        assertThat(list.size).isEqualTo(10)

    }

    @Test
    fun `new music list request when refresh list`(){
            val origin=viewModel.musicEntities.getOrAwaitValueTest()
            //when
            viewModel.requestNextMusic()
            viewModel.refresh()
            val compare=viewModel.musicEntities.getOrAwaitValueTest()
            //then
              assertThat(origin.size).isEqualTo(compare.size)
                for (i in origin.indices){
                    assertThat(origin[i].id).isEqualTo(compare[i].id)
                }

    }

    @Test
    fun `if scroll meet end of list, add 10 list from repo`(){
            //given
            val origin=viewModel.musicEntities.getOrAwaitValueTest()
            //when
            viewModel.requestNextMusic()
            //then
            val compare=viewModel.musicEntities.getOrAwaitValueTest()
            assertThat(origin.size.plus(10)).isEqualTo(compare.size)
                for (i in origin.indices){
                    assertThat(origin[i].id).isEqualTo(compare[i].id)
                }
    }


    @Test
    fun `if sort list order by track name ascending`(){
        val origin=viewModel.musicEntities.getOrAwaitValueTest()
        //given&& when
        viewModel.sortListByName()
        val compare = viewModel.musicEntities.getOrAwaitValueTest()
        origin.sortedBy { it.track }
        //then
        for (i in origin.indices){
            assertThat(origin[i].id).isEqualTo(compare[i].id)
        }
    }


    @Test
    fun `if sort list order by track name descending`(){
        val origin=viewModel.musicEntities.getOrAwaitValueTest()
        //given&& when
        viewModel.sortListByName()
        val compare = viewModel.musicEntities.getOrAwaitValueTest()
        origin.sortedByDescending { it.track }
        //then
        for (i in origin.indices){
            assertThat(origin[i].id).isEqualTo(compare[i].id)
        }
    }



}