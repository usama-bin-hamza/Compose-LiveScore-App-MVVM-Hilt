package com.usama.composelivescorehilt.data.remote

import com.usama.composelivescorehilt.data.models.InplayMatchesResponse
import com.usama.composelivescorehilt.data.models.UpcomingMatchesResponse
import com.usama.composelivescorehilt.util.GET_INPLAY_FIXTURES
import com.usama.composelivescorehilt.util.GET_UPCOMING_MATCHES
import dagger.Provides
import retrofit2.http.GET
interface ElenaApiService {

    //        @Provides
    @GET(GET_INPLAY_FIXTURES)
    suspend fun getInplayMatches(): InplayMatchesResponse

    @GET(GET_UPCOMING_MATCHES)
    suspend fun getUpcomingMatches(): UpcomingMatchesResponse
}