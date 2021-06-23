package com.ldg.ncsplayer.data

data class MusicModel(
        val id :Long,
        val track:String,
        val streamUrl:String,
        val coverUrl:String,
        val artist:String,
        val releaseDate:String,
        val genre: String,
        val tag: List<String>,
        val isPlaying : Boolean=false
)
