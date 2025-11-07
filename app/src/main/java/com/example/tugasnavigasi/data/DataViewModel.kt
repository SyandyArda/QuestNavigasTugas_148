package com.example.tugasnavigasi.data

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

// Data class untuk menampung semua state UI
data class CobaUiState(
    val nama: String = "",
    val jenisKelamin: String = "",
    val status: String = "",
    val alamat: String = ""
)

class DataViewModel : ViewModel() {
    // State privat yang hanya bisa diubah di dalam ViewModel
    private val _uiState = MutableStateFlow(CobaUiState())

    // State publik yang hanya bisa dibaca oleh Composable (UI)
    val uiState: StateFlow<CobaUiState> = _uiState.asStateFlow()

    // Fungsi untuk memperbarui nama
    fun setNama(nama: String) {
        _uiState.update { currentState ->
            currentState.copy(nama = nama)
        }
    }

    // Fungsi untuk memperbarui jenis kelamin
    fun setJenisKelamin(jenisKelamin: String) {
        _uiState.update { currentState ->
            currentState.copy(jenisKelamin = jenisKelamin)
        }
    }

    // Fungsi untuk memperbarui status
    fun setStatus(status: String) {
        _uiState.update { currentState ->
            currentState.copy(status = status)
        }
    }

    // Fungsi untuk memperbarui alamat
    fun setAlamat(alamat: String) {
        _uiState.update { currentState ->
            currentState.copy(alamat = alamat)
        }
    }

    // Fungsi untuk mereset data (jika diperlukan)
    fun resetForm() {
        _uiState.value = CobaUiState()
    }
}