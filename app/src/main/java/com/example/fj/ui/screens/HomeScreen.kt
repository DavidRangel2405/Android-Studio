package com.example.fj.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fj.R
import com.example.fj.data.model.ServiceEntity
import com.example.fj.data.model.ServiceModel
import com.example.fj.data.model.controller.ServiceViewModel
import com.example.fj.data.model.database.AppDatabase
import com.example.fj.data.model.database.DatabaseProvider
import com.example.fj.ui.components.ServiceCard
import com.example.fj.ui.components.ServiceDetailCard
import com.example.fj.ui.components.TopBar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: ServiceViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val db: AppDatabase = DatabaseProvider.getDatabase(LocalContext.current)
    var serviceDetail by remember { mutableStateOf<ServiceEntity?>(null) }
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false
    )
    var showBottomSheet by remember { mutableStateOf(false) }
    var services by remember { mutableStateOf<List<ServiceEntity>>(emptyList()) }
    val serviceDao = db.serviceDao()
    Scaffold(
        topBar = { TopBar("Password Manager", navController, backButton = true) },
        bottomBar = {
            BottomAppBar(
                containerColor = Color(0xFF4F0417),
                contentColor = Color.White,
                modifier = Modifier.height(20.dp) // Ajusta este valor según tus necesidades
            ) {
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                containerColor = Color(0xFF4F0417),
                contentColor = Color.Black,
                onClick = {
                    navController.navigate("manage-service/0")
                }) {
                Icon(Icons.Default.Add, contentDescription = "Add icon")
            }
        }
    ) { innerPadding ->

        //Button
        LaunchedEffect(Unit) {
            services = withContext(Dispatchers.IO) {
                viewModel.getServices(db)
                serviceDao.getAll()
            }
        }

        val listState = rememberLazyListState()
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .background(colorResource(R.color.black))
                .fillMaxSize(),
            state = listState
        ) {
            items(services) { service ->
                ServiceCard(
                    service.id,
                    service.name,
                    service.username,
                    service.imageURL,
                    onButtonClick = {
                        viewModel.showService(db, service.id) { entity ->
                            if (entity != null) {
                                serviceDetail = entity
                                showBottomSheet = true
                            } else {
                                Log.d("error", "No se encontró el servicio.")
                            }
                        }
                    }
                )
            }
        }

        if (showBottomSheet) {
            ModalBottomSheet(
                containerColor = Color(0xFF4F0417),
                contentColor = Color.White,
                modifier = Modifier.fillMaxHeight(),
                onDismissRequest = { showBottomSheet = false },
                sheetState = sheetState
            ) {
                ServiceDetailCard(
                    id = serviceDetail?.id ?: 0,
                    name = serviceDetail?.name ?: "",
                    username = serviceDetail?.username ?: "",
                    password = serviceDetail?.password ?: "",
                    description = serviceDetail?.description ?: "",
                    imageURL = serviceDetail?.imageURL,
                    onEditClick = {
                        showBottomSheet = false
                        navController.navigate("manage-service/" + serviceDetail?.id)
                    }
                )
            }
        }
    }
}

/*
Column (
    modifier = Modifier
        .fillMaxSize()
){
    Text(text = "This is the HomeScreen")
    Button(onClick = {navController.navigate("menu")}) {
        Text(text = "MenuScreen")
    }
    Button(onClick = {navController.navigate("components")}) {
        Text(text = "ComponentScreen")
    }
}*/