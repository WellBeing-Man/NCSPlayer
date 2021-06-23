package com.ldg.ncsplayer.network


import com.ldg.ncsplayer.other.Constants.TEST_BASS_GENRE
import retrofit2.http.GET

interface MusicService {
    @GET(TEST_BASS_GENRE)
    suspend fun getMusicByBass():MusicResponse

}