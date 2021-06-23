package com.ldg.ncsplayer.data

import java.lang.IllegalArgumentException

enum class MusicTAG {
        EPIC, ENERGETIC
}
fun createMusicTAG(tag:String): MusicTAG {
        return when(tag) {
                "epic" -> MusicTAG.EPIC
                "energetic"-> MusicTAG.ENERGETIC

                else -> throw IllegalArgumentException()
        }
}