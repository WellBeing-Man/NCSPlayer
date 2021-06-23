package com.ldg.ncsplayer.network

data class MusicResult (
        val track:String,
        val streamUrl:String,
        val artist:String,
        val coverUrl:String,
        val genre: String,
        val tags:String,
        val releaseDate:String
    )
