package com.example.sounds

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.sounds.theme.SoundSTheme
import kotlinx.coroutines.launch

class MainActivity4 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SoundSTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen4()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen4() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent1 {
                scope.launch {
                    drawerState.close()
                }
            }
        },
        content = {
            SHOPPAGEP {
                scope.launch {
                    drawerState.open()
                }
            }
        }
    )
}

@Composable
fun SHOPPAGEP(onMenuClick: () -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xffa7a7a7))
            .padding(1.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item { TopBar(onMenuClick) }
        item { Spacer(modifier = Modifier.height(16.dp)) }
        item { SearchBar() }
        item { Spacer(modifier = Modifier.height(16.dp)) }
        item { CategorySection() }
        item { Spacer(modifier = Modifier.height(16.dp)) }
        item { ProductSection() }
        item { Spacer(modifier = Modifier.height(16.dp)) }
        items(3) { // Replace 3 with the number of products
            ProductItem()
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun TopBar(onMenuClick: () -> Unit) {


    Box(
        modifier = Modifier
            .width(600.dp)
            .height(87.dp)
            .background(Color(0xff1b00c2)),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 15.dp)
        ) {
            IconButton(
                onClick = onMenuClick,
                modifier = Modifier.size(40.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu Button",
                    tint = Color.White
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Shop",
                color = Color.White,
                style = TextStyle(fontSize = 20.sp),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun SearchBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 16.dp)
        ) {
            Icon(
                painter = painterResource(id = android.R.drawable.ic_search_category_default),
                contentDescription = "Right Button",
                tint = Color.Black
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Search Product",
                color = Color.Black.copy(alpha = 0.38f),
                style = TextStyle(fontSize = 18.sp)
            )
        }
    }
}

@Composable
fun CategorySection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(35.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Image(
            painter = painterResource(id = R.drawable.logosound),
            contentDescription = "Home Icon",
            modifier = Modifier.size(95.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = "Home",
            color = Color.Black,
            style = TextStyle(fontSize = 20.sp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Divider(
            color = Color.Black,
            modifier = Modifier
                .height(35.dp)
                .width(1.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = "Category",
            color = Color.Black,
            style = TextStyle(fontSize = 20.sp)
        )
    }
}

@Composable
fun ProductSection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
            .padding(16.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.speaker1),
                contentDescription = "Product Image",
                modifier = Modifier
                    .height(140.dp)
                    .fillMaxWidth()

            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "JBL-EON710",
                color = Color.Black,
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Ergonomic or cup with on-ear controls up to 22 hours of listening time. Apple Wireless chip & Class",
                color = Color.Black,
                style = TextStyle(fontSize = 14.sp),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Price $450.55",
                color = Color(0xffff6107),
                style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                ActionButton(text = "Add to Cart")
                ActionButton(text = "Buy Now", backgroundColor = Color(0xff1b00c2))
            }
        }
    }
}

@Composable
fun ActionButton(text: String, backgroundColor: Color = Color.White) {
    Surface(
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(2.dp, Color(0xff1b00c2)),
        color = backgroundColor,
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(
                text = text,
                color = if (backgroundColor == Color.White) Color.Black else Color.White,
                style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium)
            )
        }
    }
}

@Composable
fun ProductItem() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color(0xffe0e0e0))
            .padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.headphones),
                contentDescription = "Product Image",

                modifier = Modifier
                    .size(84.dp)

            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = "SENNHEISER MOMENTUM 2",
                    color = Color.Black,
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold)
                )
                Text(
                    text = "Price $270.00",
                    color = Color(0xffff6107),
                    style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold)
                )
                Text(
                    text = "4.9",
                    color = Color(0xff1b00c2),
                    style = TextStyle(fontSize = 12.sp)
                )
            }
        }
    }
}

@Composable
fun DrawerContent12(onCloseDrawer: () -> Unit) {
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Menu",
            modifier = Modifier
                .padding(16.dp)
                .background(Color(0xFF00008B))
                .fillMaxWidth()
                .padding(16.dp),
            color = Color.White,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextButton(onClick = {
            context.startActivity(Intent(context, MainActivity::class.java))
            onCloseDrawer()
        }) {
            Text("Sign up")
        }
        TextButton(onClick = {
            context.startActivity(Intent(context, MainActivity2::class.java))
            onCloseDrawer()
        }) {
            Text("Log in")
        }
        TextButton(onClick = {
            context.startActivity(Intent(context, MainActivity3::class.java))
            onCloseDrawer()
        }) {
            Text("User")
        }
        TextButton(onClick = {
            context.startActivity(Intent(context, MainActivity4::class.java))
            onCloseDrawer()
        }) {
            Text("Shop")
        }
        TextButton(onClick = {
            context.startActivity(Intent(context, MainActivity5::class.java))
            onCloseDrawer()
        }) {
            Text("Home page")
        }
        TextButton(onClick = {
            context.startActivity(Intent(context, MainActivity6::class.java))
            onCloseDrawer()
        }) {
            Text("Dashboard")
        }
        TextButton(onClick = {
            context.startActivity(Intent(context, MainActivity7::class.java))
            onCloseDrawer()
        }) {
            Text("Wave Dynamics")
        }
    }
}

@Preview(widthDp = 393, heightDp = 852)
@Composable
fun SHOPPAGEPPreview() {
    SoundSTheme {
        MainScreen4()
    }
}