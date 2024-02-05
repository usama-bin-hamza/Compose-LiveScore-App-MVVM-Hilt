package com.usama.composelivescorehilt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.usama.composelivescorehilt.data.models.Match


import com.usama.composelivescorehilt.ui.theme.Green900
import com.usama.composelivescorehilt.viewmodel.InplayMatchesViewModel
import com.usama.composelivescorehilt.viewmodel.UpcomingMatchesViewModel
import com.usama.composelivescorehilt.viewmodel.state.MatchesState
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Locale

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // A surface container using the 'background' color from the theme
                Column(modifier = Modifier.padding(10.dp)) {
                    TopAppBar()
                    FetchData()
                }
            }
        }
    }
}


@Composable
fun FetchData(
    inplayMatchesViewModel: InplayMatchesViewModel = viewModel(),
    upcomingMatchesViewModel: UpcomingMatchesViewModel = viewModel()
) {

    Column {

        when (val state = inplayMatchesViewModel.inPlayMatchesState.collectAsState().value) {

            is MatchesState.Empty -> Text(text = "No data available")
            is MatchesState.Loading -> Text(text = "Loading...")
            is MatchesState.Success -> LiveMatches(liveMatches = state.data)
            is MatchesState.Error -> Text(text = state.message)
        }

        when (val state = upcomingMatchesViewModel.upcomingMatchesState.collectAsState().value) {

            is MatchesState.Empty -> Text(text = "No data available")
            is MatchesState.Loading -> Text(text = "Loading...")
            is MatchesState.Success -> UpcomingMatches(upcomingMatches = state.data)
            is MatchesState.Error -> Text(text = state.message)
        }
    }
}

@Composable
fun LiveMatches(liveMatches: List<Match>) {

    Column(modifier = Modifier.padding(15.dp)) {

        Text(
            text = "Live Matches",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = 12.dp)
        )

        if (liveMatches.isEmpty()) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "No Live Matches Currently"
                )
                Text(
                    text = "No Live Matches Currently",
                    style = MaterialTheme.typography.labelSmall
                )
            }
        } else {

            LazyRow(
                modifier = Modifier.padding(top = 15.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(liveMatches.size) {
                    LiveMatchItem(match = liveMatches[it])
                }
            }
        }
    }
}



@Composable
fun LiveMatchItem(match: Match) {

    Card(
        shape = RoundedCornerShape(24.dp),
        modifier = Modifier
            .width(300.dp)
            .height(150.dp),
//        elevation = 1.dp
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(
                text = match.leagueName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.labelMedium
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val homeScore = match.team_home_90min_goals
                val awayScore = match.team_away_90min_goals

                Text(
                    text = match.homeName,
                    style = MaterialTheme.typography.labelLarge
                )
                Text(
                    text = "$homeScore:$awayScore",
                    style = MaterialTheme.typography.labelLarge
                )
                Text(
                    text = match.awayName,
                    style = MaterialTheme.typography.labelLarge
                )
            }
//            Chip(
//                onClick = {
// },
//                colors = ChipDefaults.chipColors(
//                    contentColor = Color.White,
//                    backgroundColor = Green900
//                ),
//                modifier = Modifier
//                    .align(
//                        Alignment.CenterHorizontally
//                    )
//                    .padding(top = 20.dp)
//            ) {
//                Text(matchStatus(match))
//            }
        }
    }
}

fun matchStatus(match: Match): String {
    return when (match.status) {
        "in progress" -> "${match.elapsed}"
        "half time" -> "half time"
        "not started" -> "not started"
        "finished" -> "finished"
        "cancelled" -> "cancelled"
        "postponed" -> "postponed"
        else -> "suspended"
    }
}


@Composable
fun UpcomingMatches(upcomingMatches: List<Match>) {

    Column(modifier = Modifier.padding(15.dp)) {

        Text(
            text = "Scheduled Matches",
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.padding(top = 12.dp)
        )

        if (upcomingMatches.isEmpty()) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "No Upcoming Matches Currently"
                )
                Text(
                    text = "No Upcoming Matches Currently",
                    style = MaterialTheme.typography.labelLarge
                )
            }
        } else {

            LazyColumn(
                modifier = Modifier.padding(top = 15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(upcomingMatches.size) {
                    UpcomingMatchItem(match = upcomingMatches[it])
                }
            }
        }
    }
}

@Composable
fun UpcomingMatchItem(match: Match) {
    Card(
        shape = RoundedCornerShape(24.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(bottom = 10.dp),
//        elevation = 0.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val month = getMatchDayAndMonth(match.date)
            val time = getMatchTime(match.date)
            Text(
                text = match.homeName,
                style = MaterialTheme.typography.labelLarge
            )
            Text(
                text = "$time\n$month",
                style = MaterialTheme.typography.labelLarge,
                color = Green900,
                textAlign = TextAlign.Center
            )
            Text(
                text = match.awayName,
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}

fun getMatchDayAndMonth(date: String): String? {
    val parser = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH)
    val formatter = SimpleDateFormat("d MMM", Locale.ENGLISH)
    return date.let { it -> parser.parse(it)?.let { formatter.format(it)  } }
}

fun getMatchTime(date: String): String? {
    val parser = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH)
    val formatter = SimpleDateFormat("hh:mm a", Locale.ENGLISH)//06:30 pm
    return date.let { it -> parser.parse(it)?.let { formatter.format(it)  } }
}

@Composable
fun TopAppBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = {
 }) {
            Icon(imageVector = Icons.Default.Refresh, contentDescription = "Refresh Icon")
        }

        Text(text = "LiveScores", style = MaterialTheme.typography.labelMedium)

        IconButton(onClick = {
 }) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_launcher_background), //modeicon
                contentDescription = "Toggle Theme"
            )
        }
    }
}

