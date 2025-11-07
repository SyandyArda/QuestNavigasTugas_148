package com.example.tugasnavigasi

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tugasnavigasi.data.DataViewModel
import com.example.tugasnavigasi.view.HalamanData
import com.example.tugasnavigasi.view.HalamanFormulir
import com.example.tugasnavigasi.view.HalamanWelcome

// Enum untuk semua layar di aplikasi Anda
enum class Navigasi {
    Welcome,
    Formulir,
    Detail
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    // Buat instance ViewModel yang akan dibagikan ke semua layar
    val viewModel: DataViewModel = viewModel()

    Scaffold { isiRuang ->
        NavHost(
            navController = navController,
            // Mulai dari Halaman Welcome, sesuai Gambar 1
            startDestination = Navigasi.Welcome.name,
            modifier = Modifier.padding(isiRuang)
        ) {
            // Rute untuk Halaman Welcome
            composable(route = Navigasi.Welcome.name) {
                HalamanWelcome(
                    onNextButtonClicked = {
                        // Saat tombol "Submit" di Welcome diklik, pergi ke Formulir
                        navController.navigate(Navigasi.Formulir.name)
                    }
                )
            }

            // Rute untuk Halaman Formulir
            composable(route = Navigasi.Formulir.name) {
                // Ambil data state dari ViewModel
                val uiState by viewModel.uiState.collectAsState()

                HalamanFormulir(
                    uiState = uiState,
                    onNamaChange = viewModel::setNama,
                    onAlamatChange = viewModel::setAlamat,
                    onJenisKelaminSelect = viewModel::setJenisKelamin,
                    onStatusSelect = viewModel::setStatus,
                    OnSubmitBtnClick = {
                        // Saat "Submit" di Formulir diklik, pergi ke Detail
                        navController.navigate(Navigasi.Detail.name)
                    }
                )
            }

            // Rute untuk Halaman Tampil Data
            composable(route = Navigasi.Detail.name) {
                // Ambil data state dari ViewModel
                val uiState by viewModel.uiState.collectAsState()

                HalamanData(
                    uiState = uiState,
                    onBerandaBtnClick = {
                        // Tombol "Beranda" kembali ke layar Welcome
                        // dan membersihkan riwayat navigasi
                        navController.popBackStack(Navigasi.Welcome.name, inclusive = false)
                    },
                    onFormulirBtnClick = {
                        // Tombol "Formulir" kembali ke layar Formulir
                        navController.popBackStack(Navigasi.Formulir.name, inclusive = false)
                    }
                )
            }
        }
    }
}