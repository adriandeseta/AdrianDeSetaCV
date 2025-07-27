package com.adriandeseta.cv.ui.adriandeseta.personaldata

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.adriandeseta.cv.ui.adriandeseta.profile.ProfileScreen

@Composable
fun PersonalDataScreen(navController: NavController) {

    val context = LocalContext.current
    val url = "https://www.linkedin.com/in/adrian-de-seta-755a1854"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondary)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )  {

        Text(
            text = "Adrián De Seta - CV",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .padding(vertical = 32.dp)
                .align(Alignment.CenterHorizontally)
        )

        Text(
            text = "NOMBRE",
            style = MaterialTheme.typography.titleLarge,
        )
        Text(
            text = "Adrián De Seta",
            style = MaterialTheme.typography.labelLarge,
        )

        Spacer(Modifier.height(10.dp))

        Text(
            text = "DIRECCION",
            style = MaterialTheme.typography.titleLarge,
        )
        Text(
            text = "Sarachaga 4958 | CABA",
            style = MaterialTheme.typography.labelLarge,
        )

        Spacer(Modifier.height(10.dp))

        Text(
            text = "NACIONALIDAD",
            style = MaterialTheme.typography.titleLarge,
        )
        Text(
            text = "Argentina | Italiana",
            style = MaterialTheme.typography.labelLarge,
        )

        Spacer(Modifier.height(10.dp))

        Text(
            text = "FECHA DE NACIMIENTO",
            style = MaterialTheme.typography.titleLarge,
        )
        Text(
            text = "06/09/1985",
            style = MaterialTheme.typography.labelLarge,
        )

        Spacer(Modifier.height(10.dp))

        Text(
            text = "TELEFONO",
            style = MaterialTheme.typography.titleLarge,
        )
        Text(
            text = "+54 11 6754 7474",
            style = MaterialTheme.typography.labelLarge,
        )

        Spacer(Modifier.height(10.dp))

        Text(
            text = "LINKEDIN",
            style = MaterialTheme.typography.titleLarge,
        )
        Text(
            text = AnnotatedString(url),
            style = MaterialTheme.typography.labelLarge.copy(
                color = MaterialTheme.colorScheme.primary,
                textDecoration = TextDecoration.Underline
            ),
            modifier = Modifier
                .padding(top = 4.dp)
                .clickable {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    context.startActivity(intent)
                }
        )

        Spacer(Modifier.height(10.dp))

        Text(
            text = "E-MAIL",
            style = MaterialTheme.typography.titleLarge,
        )
        Text(
            text = "adriandeseta1985@gmail.com",
            style = MaterialTheme.typography.labelLarge,
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPersonalDataScreen() {
    // Si tenés un tema custom, usalo acá:
    MaterialTheme {
        // Usamos un NavController de prueba
        PersonalDataScreen(navController = rememberNavController())
    }
}