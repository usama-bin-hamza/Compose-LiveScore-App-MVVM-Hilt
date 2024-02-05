package com.usama.composelivescorehilt.repository

import com.usama.composelivescorehilt.data.models.Match
import com.usama.composelivescorehilt.data.remote.ElenaApiService

import javax.inject.Inject
import javax.inject.Singleton

class InplayMatchesRepository @Inject constructor(private val elenaApiService: ElenaApiService) {

    suspend fun getAllInPlayMatches(): List<Match> = elenaApiService.getInplayMatches().data
}