package com.usama.composelivescorehilt.repository

import com.usama.composelivescorehilt.data.models.Match
import com.usama.composelivescorehilt.data.remote.ElenaApiService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

import javax.inject.Inject
import javax.inject.Singleton

//@Module
//@InstallIn(ViewModelComponent::class)
abstract class InplayMatchesRepository @Inject constructor(private val elenaApiService: ElenaApiService.ElenaApiService) {

//    @Binds
////    @Singleton
//    @Provides
    suspend abstract fun getAllInPlayMatches(): List<Match> = elenaApiService.getInplayMatches().data
}