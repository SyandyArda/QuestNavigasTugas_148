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
        }
    ) { isiRuang ->
        Column(
            modifier = modifier
                .padding(isiRuang)
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            // --- NAMA LENGKAP ---
            OutlinedTextField(
                value = uiState.nama,
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Nama Lengkap") },
                onValueChange = onNamaChange
            )
            Spacer(modifier = Modifier.height(16.dp))

            // --- JENIS KELAMIN ---
            Text(text = "JENIS KELAMIN")
            Row {
                jenisKelaminList.forEach { item ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = uiState.jenisKelamin == item,
                            onClick = { onJenisKelaminSelect(item) }
                        )
                        Text(text = item)
                        Spacer(modifier = Modifier.width(16.dp))
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            // --- STATUS PERKAWINAN (BARU) ---
            Text(text = "STATUS PERKAWINAN")
            Column { // Gunakan Column agar radio button rapi ke bawah
                statusList.forEach { item ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = uiState.status == item,
                            onClick = { onStatusSelect(item) }
                        )
                        Text(text = item)
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            // --- ALAMAT ---
            OutlinedTextField(
                value = uiState.alamat,
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Alamat") },
                onValueChange = onAlamatChange,
            )
            Spacer(modifier = Modifier.height(30.dp))

            // --- TOMBOL SUBMIT ---
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = OnSubmitBtnClick
            ) {
                Text(text = stringResource(id = R.string.submit))
            }
        }
    }
}