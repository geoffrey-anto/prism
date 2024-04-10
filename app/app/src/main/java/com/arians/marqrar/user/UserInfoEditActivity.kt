package com.arians.marqrar.user

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arians.marqrar.ui.theme.MarQRARTheme

class UserInfoEditActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarQRARTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .fillMaxHeight(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(modifier = Modifier.padding(22.dp)) {
                        UserInfoEditScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun UserInfoEditScreen() {
    var fullName by remember { mutableStateOf("") }

    UserInfoTopBar()

    Spacer(modifier = Modifier.height(150.dp))

    Column(modifier = Modifier) {
        UserInfoTextInput(name = "Full Name", value = fullName, onValueChange = {
            fullName = it
        })
        UserInfoTextInput(name = "Date Of Birth", value = fullName, onValueChange = {
            fullName = it
        })
        UserInfoTextInput(name = "Email", value = fullName, onValueChange = {
            fullName = it
        })
        UserInfoTextInput(name = "Phone No", value = fullName, onValueChange = {
            fullName = it
        })

        UserInfoTextInput(name = "Gender", value = fullName, onValueChange = {
            fullName = it
        })
    }

    UserInfoSubmitButton()
}

@Composable
fun UserInfoTopBar() {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                Icons.Outlined.ArrowBack,
                contentDescription = "Back Button",
                modifier = Modifier.width(25.dp)
            )
            Text(
                text = "Complete Your Profile",
                modifier = Modifier.padding(start=10.dp),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )
            )
        }
    }
}

@Composable
fun UserInfoTextInput(name: String, value: String, onValueChange: (String) -> Unit, modifier: Modifier = Modifier){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    ) {
        Text(
            text = name,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Normal,
                fontSize = 18.sp
            ),
            modifier = Modifier
                .padding(start = 5.dp)
        )
        Row (
            modifier = Modifier
                .padding(top = 4.dp, end = 5.dp, start = 5.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start

        ) {
            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.Gray,
                    focusedBorderColor = MaterialTheme.colorScheme.primary
                ),
                placeholder = {
                    Text(name)
                },
            )
        }
    }
}

@Composable
fun UserInfoSubmitButton(modifier: Modifier = Modifier) {
    Button(
        onClick = { /*TODO*/ },
        modifier = modifier
            .padding(top = 15.dp)
            .height(60.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(MaterialTheme.colorScheme.primary)
            .border(1.dp, Color.White),
    ) {
        Box (modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center){
            Text(
                text = "Continue",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Normal,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    color = Color.White
                ),
                modifier = modifier.fillMaxWidth(0.9f)
            )
        }
    }
}