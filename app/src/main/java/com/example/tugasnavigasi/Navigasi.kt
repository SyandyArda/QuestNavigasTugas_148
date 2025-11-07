package com.example.tugasnavigasi

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.tugasnavigasi.data.DataViewModel
import com.example.tugasnavigasi.view.HalamanData
import com.example.tugasnavigasi.view.HalamanFormulir
import com.example.tugasnavigasi.view.HalamanWelcome
