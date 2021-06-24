package com.ldg.ncsplayer.network


import androidx.lifecycle.LiveData
import com.ldg.ncsplayer.other.Constants.TEST_BASS_GENRE
import com.ldg.ncsplayer.other.Constants.TEST_CHILL_GENRE
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MusicService {
    @GET("{genre}")
    fun getMusicByGenre(@Path("genre") genre:String):Call<MusicResponse>


}