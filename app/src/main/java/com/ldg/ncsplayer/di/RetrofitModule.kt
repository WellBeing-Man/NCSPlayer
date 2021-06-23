package com.ldg.ncsplayer.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.ldg.ncsplayer.network.MusicService
import com.ldg.ncsplayer.other.Constants.MOCKY_URL
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideMoshiConverterFactory(moshi: Moshi): MoshiConverterFactory {
        return MoshiConverterFactory.create(moshi)
    }


    @Singleton
    @Provides
    fun provideJsonAdapterFactory():JsonAdapter.Factory{
        return KotlinJsonAdapterFactory()
    }


    @Singleton
    @Provides
    fun provideMoshi(factory: JsonAdapter.Factory):Moshi{
        return Moshi
                .Builder().add(factory)
                .build()
    }

    @Singleton
    @Provides
    fun provideCoroutineCallConverterFactory():CoroutineCallAdapterFactory{
        return CoroutineCallAdapterFactory()
    }

    @Singleton
    @Provides
    fun provideRetrofitBuilder(moshiConverterFactory: MoshiConverterFactory,coroutineCallAdapterFactory: CoroutineCallAdapterFactory): Retrofit.Builder {
        return Retrofit.Builder()
                .baseUrl(MOCKY_URL)
                .addConverterFactory(moshiConverterFactory)
                .addCallAdapterFactory(coroutineCallAdapterFactory)

    }


    @MockyMusicApi
    @Singleton
    @Provides
    fun provideMockyMusicService(retrofit: Retrofit.Builder):MusicService{
        return retrofit.build().create(MusicService::class.java)
    }


    @Qualifier
    annotation class MockyMusicApi
}