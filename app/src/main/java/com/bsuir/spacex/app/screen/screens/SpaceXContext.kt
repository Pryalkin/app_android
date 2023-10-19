package com.bsuir.spacex.app.screen.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bsuir.spacex.app.model.Company
import com.bsuir.spacex.app.model.Headquarters

@Composable
fun SpaceXContext(company: Company){
    Surface(color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp).clickable{
        },
    ) {
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
                        .weight(1f).padding(12.dp),
                ) {
                    Text(text = "Name: ${company.name}",
                        color = Color.Black,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold)
                    Text(text = "Founder: ${company.founder}",
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal)
                    Text(text = "Headquarters: ${company.headquarters.state}, " +
                            "${company.headquarters.city}, " +
                            "${company.headquarters.address}",
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal)
                    Text(text = "Summary: ${company.summary}",
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal)
                }
            }
        }
    }
}

@Composable
@Preview
fun SpaceXContextPreview() {
    SpaceXContext(
        company = Company(
            id = "id",
            summary = "summary",
            headquarters = Headquarters(
                address = "address",
                city = "city",
                state = "state"
            ),
            name = "name",
            founder = "founder"
        )
    )
}
