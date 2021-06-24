package com.ldg.ncsplayer.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "musics")
data class MusicEntity(
        @PrimaryKey(autoGenerate = true)
        val id :Long,
        val track:String,
        val streamUrl:String,
        val artist:String,
        val coverUrl:String,
        val genre: String,
        val tags:String,
        val releaseDate:String
        ){
        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as MusicEntity

                if (id != other.id) return false

                return true
        }


}
