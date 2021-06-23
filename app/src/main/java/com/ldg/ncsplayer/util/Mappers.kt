package com.ldg.ncsplayer.util

import com.ldg.ncsplayer.database.MusicEntity
import com.ldg.ncsplayer.network.MusicResult


fun MusicResult.mapToEntity(id:Long): MusicEntity =
        MusicEntity(
                id = id,
                streamUrl=this.streamUrl,
                track = this.track,
                coverUrl = this.coverUrl,
                releaseDate = releaseDate,
                genre = this.genre,
                tags = this.tags,
                artist=this.artist
        )