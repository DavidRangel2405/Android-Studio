package com.example.fj

import android.graphics.Picture
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.fj.ui.theme.FJTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fj.ui.screens.HomeScreen
import com.example.fj.ui.screens.MenuScreen
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import com.example.fj.ui.theme.ColdGray
import com.example.fj.ui.theme.DarkBlueGray
import com.example.fj.ui.theme.MediumBlueGray
import com.example.fj.ui.theme.Purple40
import com.example.fj.ui.theme.SalmonPink


//import androidx.navigation.compose.NavHostController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            GmailApp()
            //ComposeMultiScreenApp()
            /*
            Column(
                modifier=Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
            ){
                CustomText()
                Picture()
                Content1()
                Content2()
                 //Text(text ="Simple text")
                 ModifierExample()
                ModifierExample2()
                  ModifierExample3()
                BoxExample1()
                BoxExample2()

            }
            //Layouts
            /*Column {
                 Text(text = "First Row")
                 Text(text = "Second Row")
                 Text(text = "Third Row")

                 Row{
                     Text(text = "Text1")
                     Text(text = "Text2")
                     Text(text = "Text3")
                     Text(text = "Text2")
                 }
                 Box{
                     Text(text = "Larabel 1")
                     Text(text = "Larabel 2")

                 }
                 Greeting(name ="World")

             }*/
            */
        }
    }
}
/*

private fun column(function: () -> Unit) {

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FJTheme {
        Greeting("Android")
    }
}
//@Preview(showBackground = true)
@Composable
fun ModifierExample(){
    Column(
        modifier= Modifier
            .padding(24.dp)
    ){
        Text(text="Hello world")

    }
}
//@Preview(showBackground = true)
@Composable
fun ModifierExample2(){
    Column(
        modifier= Modifier
            .padding(24.dp)
            .fillMaxWidth()
            .clickable(onClick = { clickAction() })
    ){
        Text(text="Hello world")

    }
}
//@Preview(showBackground = true)
@Composable
fun ModifierExample3() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp)
            .background(Color.Red)
            .border(width = 2.dp, color = Color.Green)
            .width(200.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "Hello Item 1")
        Text(text = "Hello Item 2")
        Text(text = "Hello Item 3")
        Text(text = "Hello Item 4")
        Text(text = "Hello Item 5")
    }}
@Preview(showBackground = true)
@Composable
fun CustomText() {
    Column {
        Text(
            stringResource(R.string.hello_world_text),
            color = colorResource(R.color.purple_500),
            fontSize = 28.sp,
            fontWeight = FontWeight.ExtraBold
        )
        val gradientColors = listOf(Color.Cyan, Color.Blue, Color.Red)
        Text(
            stringResource(R.string.hello_world_text),
            style = TextStyle(brush = Brush.linearGradient(colors =gradientColors))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Picture(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
    ){
        Image(
            modifier= Modifier
                .fillMaxWidth(),
            painter = painterResource(R.drawable.descargar),
            contentDescription ="Logo Android",
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Content1(){
    Card(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(5.dp)
    ){
        Text (text = "This is a Title",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
        )
        Image(
            modifier = Modifier
                .fillMaxWidth(),
            painter = painterResource(id = R.drawable.descargar),
            contentDescription = "Android Logo",
            contentScale = ContentScale.Crop
        )
        Text(
            stringResource(R.string.Text_Card),
            textAlign = TextAlign.Justify,
            lineHeight = 18.sp,
            modifier = Modifier
                .padding(10.dp)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun Content2() {
    Card(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(5.dp)
    ){
        Row {
            Image(
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp),
                //.fillMaxWidth()
                painter = painterResource(id = R.drawable.descargar),
                contentDescription = "Android Logo",
                contentScale = ContentScale.Crop
            )
            Column {
                Text (text = "This is a Title",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(10.dp)
                )
                Text(
                    stringResource(R.string.Text_Card),
                    textAlign = TextAlign.Justify,
                    lineHeight = 18.sp,
                    maxLines = 4,
                    modifier = Modifier
                        .padding(10.dp)
                )
            }
        }
    }
}

    @Preview(showBackground = true)
    @Composable
    fun BoxExample1() {
        Box(
            modifier = Modifier
                .background(Color.DarkGray)
                .fillMaxWidth()
                .padding(5.dp)
        ){
            Image(painterResource(R.drawable.descargar),
                contentDescription = "Android Logo",
                contentScale = ContentScale.FillBounds
            )
            Row(
                modifier = Modifier

                    .fillMaxWidth()
                    .padding(0.dp, 0.dp),
                horizontalArrangement = Arrangement.Center
            ){
                Icon(
                    Icons.Filled.AccountCircle,
                    contentDescription = "Icon Account"
                )
                Text(text = "Text")
            }
        }
    }

@Preview(showBackground = true)
@Composable
fun BoxExample2() {
    Box(
        modifier = Modifier
            .background(Color.Magenta)
            .padding(5.dp)
            .size(290.dp)
    ) {
        Text(text = "TopStart", Modifier.align(Alignment.TopStart))
        Text(text = "TopEnd", Modifier.align(Alignment.TopEnd))
        Text(text = "CenterStart", Modifier.align(Alignment.CenterStart))
        Text(text = "Center", Modifier.align(Alignment.Center))
        Text(text = "CenterEnd", Modifier.align(Alignment.CenterEnd))
        Text(text = "BottomStart", Modifier.align(Alignment.BottomStart))
        Text(text = "BottomEnd", Modifier.align(Alignment.BottomEnd))
    }
    }

fun clickAction(){
    println("Column Clicked")


}
@Preview(showBackground = true)
@Composable
fun ComposeMultiScreenApp(){
    val navController = rememberNavController()
    Surface(color = Color.White) {
        SetupNavGraph(navController = navController)
    }
}

@Composable
fun SetupNavGraph(navController: NavHostController){
    NavHost(navController = navController,startDestination = "menu"){
        composable("menu"){ MenuScreen(navController)}
        composable("home"){ HomeScreen(navController)}
    }
}
*/
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GmailApp() {
    Scaffold(
        containerColor = DarkBlueGray,
        topBar = {
            Box(
                modifier = Modifier
                    .offset(x = 15.dp, y = 20.dp)
                    .size(width = 364.dp, height = 40.dp)
                    .clip(RoundedCornerShape(50))
                    .background(Color.DarkGray)
                    .padding(0.dp)
            ) {
                TopAppBar(
                    title = {
                        var searchText by remember { mutableStateOf(TextFieldValue("")) }
                        BasicTextField(
                            value = searchText,
                            onValueChange = { searchText = it },
                            decorationBox = { innerTextField ->
                                Box(
                                    modifier = Modifier
                                ) {
                                    if (searchText.text.isEmpty()) {
                                        Text(
                                            text = "Buscar en el correo electrónico",
                                            color = Color.White,
                                            fontSize = 17.sp,
                                            modifier = Modifier.align(Alignment.CenterStart)
                                        )
                                    }

                                }
                                innerTextField()
                            },
                            textStyle = TextStyle(
                                color = Color.White,
                                fontSize = 18.sp
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { /* Handle Menu Click */ }) {
                            Icon(Icons.Filled.Menu, contentDescription = "Menu", tint = Color.White)
                        }
                    },
                    actions = {
                        NotificationBadge()
                    },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.DarkGray)
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Handle compose click */ },
                containerColor = ColdGray,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 0.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 15.dp, vertical = 8.dp)
                ) {
                    Icon(Icons.Filled.Edit, contentDescription = "Compose", tint = Color.White)
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = "Redactar", color = Color.White)
                }
            }
        },
        content = { paddingValues ->
            GmailBody(modifier = Modifier.padding(paddingValues))
        },
        bottomBar = {
            FooterWithIcons()
        }
    )
}

@Composable
fun FooterWithIcons(iconSpacing: Dp = 120.dp) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MediumBlueGray)
            .padding(0.dp),
        horizontalArrangement = Arrangement.Center, // Alinea los íconos hacia el centro
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Icono de correo con contador de notificaciones
        Box(
            modifier = Modifier
                .size(40.dp),
            contentAlignment = Alignment.Center
        ) {
            IconButton(onClick = { /* Handle camera click */ }) {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "Email Icon",
                    tint = Color.White,
                    modifier = Modifier
                        .size(30.dp)
                )
            }
            // Box para el número de notificaciones
            Box(
                modifier = Modifier
                    .width(25.dp)  // Ancho más largo
                    .height(16.dp) // Altura más corta
                    .background(SalmonPink, RoundedCornerShape(10.dp)) // Bordes redondeados
                    .align(Alignment.TopEnd),
                contentAlignment = Alignment.Center
            ) {
                Text("16", color = Color.Black, fontSize = 10.sp)
            }
        }

        // Espacio entre los iconos
        Spacer(modifier = Modifier.width(iconSpacing)) // Define el espacio entre los iconos

        // Imagen de cámara a la derecha
        Image(
            painter = painterResource(id = R.drawable.videocamera), // Cambia por tu recurso de imagen
            contentDescription = "Camera Image",
            modifier = Modifier
                .size(35.dp)
                .clickable { /* Manejar el clic de la cámara */ } // Agrega un clic si es necesario
        )

    }
}

@Composable
fun NotificationBadge(offsetX: Dp = 12.dp, offsetY: Dp = 0.dp) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .offset(x = offsetX, y = offsetY), // Desplazamiento libre
        contentAlignment = Alignment.TopEnd
    ) {
        IconButton(onClick = { /* Handle profile click */ }) {
            Image(
                painter = painterResource(id = R.drawable.foto),
                contentDescription = "Profile",
                modifier = Modifier
                    .size(25.dp)
                    .clip(CircleShape) // Aplica la forma circular
                    .background(Color.LightGray, CircleShape),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun GmailBody(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Principal",
                fontSize = 15.sp,
                color = Color.White,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Lista de estados para las imágenes (puede ser más compleja si se necesita)
        val imageList = listOf(R.drawable.gmail, R.drawable.perfil, R.drawable.mercadolibre,
            R.drawable.paypal, R.drawable.steam, R.drawable.mondongo)
        val selectedImages = remember { mutableStateListOf(false, false, false, false, false, false) }

        // Email rows con imágenes individuales
        EmailRow(
            subject = "Gmail",
            preview = "Protege tu cuenta con la verificación en dos pasos",
            message = "Añade una capa extra de seguridad activando la verificación en dos pasos.",
            time = "12:30 PM",
            imageId = imageList[0],
            isImageSelected = selectedImages[0],
            onImageClick = { selectedImages[0] = !selectedImages[0] }
        )

        EmailRow(
            subject = "Mercado Libre",
            preview = "Recomendaciones personalizadas para ti",
            message = "Basándonos en tus últimas compras, te sugerimos estos productos.",
            time = "9:15 AM",
            imageId = imageList[2],
            isImageSelected = selectedImages[2],
            onImageClick = { selectedImages[2] = !selectedImages[2] }
        )

        EmailRow(
            subject = "PayPal",
            preview = "Actualiza tu información de cuenta",
            message = "Es hora de revisar y actualizar tu información de contacto en PayPal.",
            time = "17 sept",
            imageId = imageList[3],
            isImageSelected = selectedImages[3],
            onImageClick = { selectedImages[3] = !selectedImages[3] }
        )

        EmailRow(
            subject = "Steam",
            preview = "¡Actualización disponible para tu juego!",
            message = "Tu juego tiene una nueva actualización. Descárgala ahora para mejorar tu experiencia.",
            time = "16 sept",
            imageId = imageList[4],
            isImageSelected = selectedImages[4],
            onImageClick = { selectedImages[4] = !selectedImages[4] }
        )

        EmailRow(
            subject = "Mario Mondongo",
            preview = "Fotos del viaje",
            message = "Aquí tienes las fotos del viaje del fin de semana pasado. ¡Nos divertimos mucho!",
            time = "15 sept",
            imageId = imageList[5],
            isImageSelected = selectedImages[5],
            onImageClick = { selectedImages[5] = !selectedImages[5] }
        )

        EmailRow(
            subject = "Nike",
            preview = "Nuevas zapatillas de edición limitada",
            message = "Descubre las nuevas zapatillas de la colección limitada, disponibles solo por tiempo limitado.",
            time = "15 sept",
            imageId = imageList[1],
            isImageSelected = selectedImages[1],
            onImageClick = { selectedImages[1] = !selectedImages[1] }
        )

        EmailRow(
            subject = "Jimmyson",
            preview = "Reunión familiar este domingo",
            message = "Te esperamos este domingo para la reunión familiar en casa de los abuelos.",
            time = "14 sept",
            imageId = imageList[1],
            isImageSelected = selectedImages[1],
            onImageClick = { selectedImages[1] = !selectedImages[1] }
        )

        EmailRow(
            subject = "Amazon",
            preview = "Tu pedido ha sido enviado",
            message = "El paquete con tu pedido ha sido enviado y está en camino a tu dirección.",
            time = "14 sept",
            imageId = imageList[2],
            isImageSelected = selectedImages[2],
            onImageClick = { selectedImages[2] = !selectedImages[2] }
        )

        EmailRow(
            subject = "Gmail",
            preview = "Limita el uso de almacenamiento de tu cuenta",
            message = "Te estás quedando sin espacio en tu cuenta de Google. Aprende a liberar espacio.",
            time = "14 sept",
            imageId = imageList[0],
            isImageSelected = selectedImages[0],
            onImageClick = { selectedImages[0] = !selectedImages[0] }
        )

        EmailRow(
            subject = "Mercado Libre",
            preview = "Vende más rápido con nuestras nuevas herramientas",
            message = "Mejora la visibilidad de tus productos con las nuevas funciones de Mercado Libre.",
            time = "13 sept",
            imageId = imageList[2],
            isImageSelected = selectedImages[2],
            onImageClick = { selectedImages[2] = !selectedImages[2] }
        )

        EmailRow(
            subject = "PayPal",
            preview = "Se ha completado tu transacción",
            message = "Tu pago ha sido exitoso y el destinatario ha recibido los fondos.",
            time = "13 sept",
            imageId = imageList[3],
            isImageSelected = selectedImages[3],
            onImageClick = { selectedImages[3] = !selectedImages[3] }
        )

        EmailRow(
            subject = "Steam",
            preview = "Revisa las nuevas ofertas de la semana",
            message = "Aprovecha los descuentos en juegos populares esta semana en Steam.",
            time = "11 sept",
            imageId = imageList[4],
            isImageSelected = selectedImages[4],
            onImageClick = { selectedImages[4] = !selectedImages[4] }
        )

        EmailRow(
            subject = "Compas S.A",
            preview = "Reunión de equipo confirmada",
            message = "La reunión del equipo se llevará a cabo el jueves a las 10AM en la sala 2.",
            time = "11 sept",
            imageId = imageList[1],
            isImageSelected = selectedImages[1],
            onImageClick = { selectedImages[1] = !selectedImages[1] }
        )

        EmailRow(
            subject = "H&M",
            preview = "Última oportunidad para nuestras rebajas de verano",
            message = "Las rebajas de verano están a punto de terminar. ¡Aprovecha los descuentos!",
            time = "9 sept",
            imageId = imageList[1],
            isImageSelected = selectedImages[1],
            onImageClick = { selectedImages[1] = !selectedImages[1] }
        )

        EmailRow(
            subject = "José Padilla",
            preview = "Entrega final del proyecto",
            message = "Recuerda que la entrega del proyecto es este viernes a las 5PM.",
            time = "9 sept",
            imageId = imageList[1],
            isImageSelected = selectedImages[1],
            onImageClick = { selectedImages[1] = !selectedImages[1] }
        )

        EmailRow(
            subject = "Amazon",
            preview = "Renueva tu suscripción Prime",
            message = "Tu suscripción a Amazon Prime está a punto de caducar. Renueva ahora.",
            time = "9 sept",
            imageId = imageList[1],
            isImageSelected = selectedImages[1],
            onImageClick = { selectedImages[1] = !selectedImages[1] }
        )
    }
}

@Composable
fun EmailRow(
    subject: String,
    preview: String,
    message: String,
    time: String,
    imageId: Int,
    isImageSelected: Boolean,
    onImageClick: () -> Unit
) {
    var isFavorite by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .weight(1f)
                .padding(bottom = 12.dp)
        ) {
            // Imagen individual con un click handler
            Image(
                painter = painterResource(id = imageId),
                contentDescription = "Profile",
                modifier = Modifier
                    .size(50.dp)
                    .background(if (isImageSelected) Color.Blue else Color.LightGray, CircleShape)
                    .clip(CircleShape)
                    .clickable { onImageClick() }, // Cambia el estado de la imagen al hacer clic
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = subject,
                        fontWeight = FontWeight.Bold,
                        fontSize = 21.sp,
                        color = Color.White,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .weight(1f)
                            .clickable { onImageClick() } // Cambia el estado de la imagen al hacer clic
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = time,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        color = Color.White,
                        modifier = Modifier
                            .align(Alignment.Bottom) // Alinea el texto en la parte inferior del Row
                    )
                }

                Row(
                    verticalAlignment = Alignment.Bottom // Alinear con la parte inferior
                ) {
                    Text(
                        text = preview,
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp,
                        color = Color.White,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .weight(1f)
                            .clickable { onImageClick() } // Cambia el estado de la imagen al hacer clic
                            .padding(end = 35.dp) // Agrega un padding a la derecha
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
                Row(
                    verticalAlignment = Alignment.Bottom // Alinear con la parte inferior
                ) {
                    Text(
                        text = message,
                        fontSize = 16.sp,
                        color = Color.Gray,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .weight(1f)
                            .clickable { onImageClick() } // Cambia el estado de la imagen al hacer clic
                            .padding(end = 9.dp) // Agrega un padding a la derecha
                            .align(Alignment.CenterVertically)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(
                        onClick = { isFavorite = !isFavorite },
                        modifier = Modifier.size(25.dp)
                    ) {
                        Icon(
                            imageVector = if (isFavorite) Icons.Filled.Star else Icons.Outlined.Star,
                            contentDescription = if (isFavorite) "Unfavorite" else "Favorite",
                            tint = if (isFavorite) Purple40 else Color.Gray,
                            modifier = Modifier
                                .size(25.dp)
                                .clickable { onImageClick() }, // Cambia el estado de la imagen al hacer clic
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable fun DefaultPreview() { GmailApp() }