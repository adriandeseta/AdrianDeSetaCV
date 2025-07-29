package com.adriandeseta.cv.ui.adriandeseta.personaldata

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.adriandeseta.cv.ui.main.resources.BoldText
import com.adriandeseta.cv.ui.main.resources.CustomText
import com.adriandeseta.cv.ui.theme.cv_text_grey

@Composable
fun PersonalDataScreen(modifier: Modifier, navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        BoldText(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            text = "Información personal",
            fontSize = 62.sp,
        )
        Spacer(Modifier.height(20.dp))
        PersonalDataItem("Nombre", "Adrián De Seta")
        PersonalDataItem("Dirección", "Sarachaga 4958 | CABA")
        PersonalDataItem("Nacionalidad", "Argentina | Italiana")
        PersonalDataItem("Fecha de nacimiento", "06/09/1985")
        PersonalDataItemWithDialog(
            title = "Teléfono",
            data = "+54 9 11 6754-7474",
            phoneNumber = "5491167547474"
        )
        PersonalDataItemLink(
            "Linkedin",
            "Ir al perfil",
            "https://www.linkedin.com/in/adrian-de-seta-755a1854"
        )
        PersonalDataItemLink("Github", "Ir al repositorio", "https://github.com/adriandeseta")
        PersonalEmailItemWithDialog("Email", "adriandeseta1985@gmail.com")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPersonalDataScreen() {
    // Si tenés un tema custom, usalo acá:
    MaterialTheme {
        // Usamos un NavController de prueba
        PersonalDataScreen(
            navController = rememberNavController(),
            modifier = Modifier
        )
    }
}