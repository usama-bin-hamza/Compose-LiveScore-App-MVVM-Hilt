package com.usama.composelivescorehilt.repository

import com.usama.composelivescorehilt.data.models.Match
import com.usama.composelivescorehilt.data.remote.ElenaApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Inject

//@Module
//@InstallIn(ViewModelComponent::class)
class UpcomingMatchesRepository @Inject constructor(private val elenaApiService: ElenaApiService) {

//    @Provides
    suspend fun getAllUpcomingMatches(): List<Match> = elenaApiService.getUpcomingMatches().data
}