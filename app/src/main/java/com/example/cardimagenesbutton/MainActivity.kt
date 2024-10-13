package com.example.cardimagenesbutton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.cardimagenesbutton.data.Datos
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cardimagenesbutton.model.Bandera
import com.example.cardimagenesbutton.ui.theme.CardImagenesButtonTheme

class MainActivity : ComponentActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      enableEdgeToEdge()
      setContent {
         CardImagenesButtonTheme {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
               Greeting(
                  modifier = Modifier.padding(innerPadding)
               )
            }
         }
      }
   }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
   Column {
      Row {
         CargarBanderas(modifier)
      }
   }
}

@Composable
fun CargarBanderas(modifier: Modifier) {
   val list = Datos().cargarBanderas()
   LazyColumn(modifier) {
      items(list) { bandera ->
         CreateCard(bandera, modifier)
      }
   }

}

@Composable
fun CreateCard(bandera: Bandera, modifier: Modifier) {
   var expadn by remember { mutableStateOf(false) }
   Card(modifier = modifier
      .fillMaxWidth()
      .padding(0.dp), onClick = { expadn = !expadn }
   ) {
      Row(
         modifier
            .fillMaxHeight()
            .padding(0.dp),
         verticalAlignment = Alignment.CenterVertically,
         horizontalArrangement = Arrangement.spacedBy(5.dp)
      ) {
         Column(modifier.weight(2f)) {
            Image(
               painter = painterResource(bandera.imagenResourceId),
               contentDescription = stringResource(bandera.stringResourceIdName),
               modifier = Modifier.fillMaxSize(),
               contentScale = ContentScale.FillWidth
            )
         }
         Column(modifier.weight(1f), verticalArrangement = Arrangement.Center) {
            Text(stringResource(bandera.stringResourceIdName), fontSize = 20.sp)
         }
         Column(modifier.weight(1f), verticalArrangement = Arrangement.Center) {
            IconButton(onClick = {
               expadn = !expadn
            }
            ) {
               if (!expadn) {
                  Icon(Icons.Filled.ExpandMore, contentDescription = "Más y mejor")
               } else {
                  Icon(Icons.Filled.ExpandLess, contentDescription = "Menos y peor")
               }
            }
         }
      }
      if (expadn) {
         Row(
            modifier = modifier
               .height(50.dp)
               .padding(0.dp),
            horizontalArrangement = Arrangement.Center
         ) {
            Column {
               Row {
                  Text(text = stringResource(R.string.capital), fontWeight = FontWeight.Bold)
               }
               Row {
                  Text(stringResource(bandera.stringResourceIdDescription))
               }
            }
         }
      }
   }

}


