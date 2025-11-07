package com.example.tugasnavigasi.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasnavigasi.R

@Composable
fun HalamanWelcome(
    onNextButtonClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Selamat Datang",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(50.dp))


        Image(
            painter = painterResource(id = R.drawable.nagi),
            contentDescription = "Logo Card-Ist",
            modifier = Modifier.width(150.dp) //
        )
        Text(text = "MOBILE APP 2025") //

        Spacer(modifier = Modifier.height(100.dp))

        Text(text = "Nagi Seishiro", fontSize = 18.sp)
        Text(text = "20230140148", fontSize = 16.sp)

        Spacer(modifier = Modifier.height(50.dp))

        Button(onClick = onNextButtonClicked) {
            Text(text = "Submit")
        }
    }
}