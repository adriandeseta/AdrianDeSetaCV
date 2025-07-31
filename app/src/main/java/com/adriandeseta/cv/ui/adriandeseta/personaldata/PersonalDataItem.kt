package com.adriandeseta.cv.ui.adriandeseta.personaldata

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adriandeseta.cv.R
import com.adriandeseta.cv.ui.main.resources.CustomText
import com.adriandeseta.cv.ui.theme.cv_text_grey

@Composable
fun PersonalDataItem(
    title: String,
    data: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(66.dp)
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CustomText(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
            CustomText(
                text = data,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = cv_text_grey
            )

        }
    }
}

@Composable
fun PersonalDataItemLink(
    title: String,
    data: String,
    url:String
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(66.dp)
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CustomText(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
            CustomText(
                text = data,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.clickable {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    context.startActivity(intent)
                },
                color = cv_text_grey,
                textDecoration = TextDecoration.Underline
            )
        }
    }
}

@Composable
fun PersonalDataItemWithDialog(
    title: String,
    data: String,
    phoneNumber: String
) {
    val context = LocalContext.current
    var showDialog by remember { mutableStateOf(false) }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(stringResource(R.string.personal_data_dialog_title)) },
            confirmButton = {},
            text = {
                Column {
                    Text(
                        stringResource(R.string.personal_data_dialog_call_action),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+$phoneNumber"))
                                context.startActivity(intent)
                                showDialog = false
                            }
                            .padding(8.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        stringResource(R.string.personal_data_dialog_title_wa),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                val url = "https://wa.me/$phoneNumber"
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                                context.startActivity(intent)
                                showDialog = false
                            }
                            .padding(8.dp)
                    )
                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text(stringResource(R.string.personal_data_dialog_btn_cancel))
                }
            }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(66.dp)
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CustomText(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
            CustomText(
                text = data,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.clickable { showDialog = true },
                color = cv_text_grey,
                textDecoration = TextDecoration.Underline
            )
        }
    }
}

@Composable
fun PersonalEmailItemWithDialog(
    title: String,
    email: String
) {
    val context = LocalContext.current
    var showDialog by remember { mutableStateOf(false) }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(stringResource(R.string.personal_data_dialog_title)) },
            text = {
                Column {
                    Text(
                        stringResource(R.string.personal_data_dialog_title_email),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                val intent = Intent(Intent.ACTION_SENDTO).apply {
                                    data = Uri.parse("mailto:$email")
                                    putExtra(Intent.EXTRA_SUBJECT, "Consulta desde la app")
                                }
                                context.startActivity(intent)
                                showDialog = false
                            }
                            .padding(8.dp)
                    )
                }
            },
            confirmButton = {},
            dismissButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text(stringResource(R.string.personal_data_dialog_btn_cancel))
                }
            }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(66.dp)
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CustomText(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
            CustomText(
                text = email,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.clickable { showDialog = true },
                color = cv_text_grey,
                textDecoration = TextDecoration.Underline
            )
        }
    }
}

