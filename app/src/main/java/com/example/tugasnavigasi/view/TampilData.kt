package com.example.tugasnavigasi.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasnavigasi.R
import com.example.tugasnavigasi.data.CobaUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanData(
    uiState: CobaUiState, // Terima UiState dari ViewModel
    onBerandaBtnClick: () -> Unit,
    onFormulirBtnClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        // Judul sesuai string resource "List Daftar Peserta"
                        text = stringResource(id = R.string.tampil),
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700)
                )
            )
        }
    ) { isiRuang ->
        Column(
            modifier = modifier
                .padding(isiRuang)
                .padding(16.dp),
            verticalArrangement = Arrangement.Top
        ) {
            // Tampilkan data dari ViewModel, bukan hardcode
            // Gunakan Card agar mirip dengan desain di gambar
            TampilDataField(label = stringResource(id = R.string.nama_lengkap), data = uiState.nama)
            TampilDataField(label = stringResource(id = R.string.jenis_kelamin), data = uiState.jenisKelamin)
            TampilDataField(label = stringResource(id = R.string.status_perkawinan), data = uiState.status) // Tambahkan string ini
            TampilDataField(label = stringResource(id = R.string.alamat), data = uiState.alamat)

            Spacer(modifier = Modifier.height(30.dp))

            // --- TOMBOL NAVIGASI (Sesuai Gambar 2 & 4) ---
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onBerandaBtnClick // Navigasi ke Welcome
            ) {
                Text(text = stringResource(id = R.string.beranda)) // Tambahkan string ini
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onFormulirBtnClick // Navigasi kembali ke Formulir
            ) {
                Text(text = stringResource(id = R.string.formulir_pendaftaran)) // Tambahkan string ini
            }
        }
    }
}
