package com.example.tugasnavigasi.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.tugasnavigasi.R
import com.example.tugasnavigasi.data.CobaUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanFormulir(
    uiState: CobaUiState,
    onNamaChange: (String) -> Unit,
    onAlamatChange: (String) -> Unit,
    onJenisKelaminSelect: (String) -> Unit,
    onStatusSelect: (String) -> Unit,
    OnSubmitBtnClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val jenisKelaminList = listOf("Laki-laki", "Perempuan")
    val statusList = listOf("Janda", "Duda", "Lajang")

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.home), // "Formulir Pendaftaran"
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700)
                )
            )
        }}