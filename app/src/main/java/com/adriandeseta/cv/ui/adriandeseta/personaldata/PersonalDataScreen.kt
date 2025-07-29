package com.adriandeseta.cv.ui.adriandeseta.personaldata

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.adriandeseta.cv.R
import com.adriandeseta.cv.ui.main.resources.BoldText

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
            text = stringResource(R.string.personal_data_title),
            fontSize = 62.sp,
        )
        Spacer(Modifier.height(20.dp))
        PersonalDataItem(
            stringResource(R.string.personal_data_name_title),
            stringResource(R.string.personal_data_name)
        )
        PersonalDataItem(
            stringResource(R.string.personal_data_adress_title),
            stringResource(R.string.personal_data_adress)
        )
        PersonalDataItem(
            stringResource(R.string.personal_data_nationality_title),
            stringResource(R.string.personal_data_nationality)
        )
        PersonalDataItem(
            stringResource(R.string.personal_data_birthday_title),
            stringResource(R.string.personal_data_birthday)
        )
        PersonalDataItemWithDialog(
            title = stringResource(R.string.personal_data_phone_title),
            data = stringResource(R.string.personal_data_phone_data),
            phoneNumber = stringResource(R.string.personal_data_phone)
        )
        PersonalDataItemLink(
            stringResource(R.string.personal_data_linkedin_title),
            stringResource(R.string.personal_data_linkedin_data),
            stringResource(R.string.personal_data_linkedin)
        )
        PersonalDataItemLink(
            stringResource(R.string.personal_data_github_title),
            stringResource(R.string.personal_data_github_data),
            stringResource(R.string.personal_data_github)
        )
        PersonalEmailItemWithDialog(
            stringResource(R.string.personal_data_email_title),
            stringResource(R.string.personal_data_email_data)
        )
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