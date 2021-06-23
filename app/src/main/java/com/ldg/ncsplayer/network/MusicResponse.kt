package com.ldg.ncsplayer.network

data class MusicResponse (
        val musics: List<MusicResult>,
        val total: Int,
        val totalHits: Int
        )
