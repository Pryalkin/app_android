package com.bsuir.spacex.app.screen.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bsuir.spacex.app.model.Launch
import com.bsuir.spacex.app.model.Launchpad

@Composable
fun DetailScreen(
    launch: Launch,
    launchpad: Launchpad
){
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
    ){
        Column(modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .background(Color.LightGray)
                    .fillMaxWidth()
                    .padding(12.dp),
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(6.dp),
                ) {
                    Text(text = "ID: ${launch.id}",
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold)
                    Text(text = "Details: ${launch.details}",
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold)
                    Text(text = "Launchpad (full name): ${launchpad.full_name}",
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold)
                    Text(text = "Launchpad (locality): ${launchpad.locality}",
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold)
                    Text(text = "Launchpad (region): ${launchpad.region}",
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold)
                }
            }
        }
    }

}

@Composable
@Preview(showBackground = true)
fun DetailScreenPreview() {
    DetailScreen(
        Launch(
            id = "id",
            details = "details",
            launchpad = "launchpad"
        ),
        Launchpad(
            id = "id",
            full_name = "full_name",
            locality = "locality",
            region = "region"
        )
    )
}