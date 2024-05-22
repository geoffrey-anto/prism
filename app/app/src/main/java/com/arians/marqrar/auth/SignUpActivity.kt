package com.arians.marqrar.auth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arians.marqrar.ui.theme.MarQRARTheme

class SignUpActivity : ComponentActivity() {
    private fun signUp(fullname: String, email: String, username: String, password: String) {

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarQRARTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SignUpComponent(onSubmit = {
                        fullname, email, username, password ->
                        signUp(fullname, email, username, password)
                    })
                }
            }
        }
    }
}

@Composable
fun SignUpComponent(
    onSubmit: (String, String, String, String) -> Unit,
    modifier: Modifier = Modifier
) {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SignUpHeading()

        Box(
            modifier = Modifier
                .heightIn(200.dp)
                .defaultMinSize(minWidth = 300.dp)
                .padding(top = 5.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 20.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SignUpTextInput("Full Name", Icons.Outlined.Person, fullName, onValueChange = { fullName = it })
                SignUpTextInput("Email", Icons.Outlined.Email, email, onValueChange = { email = it })
                SignUpTextInput("Username", Icons.Outlined.Person, username, onValueChange = { username = it })
                SignUpTextInput("Password", Icons.Outlined.Lock, password, onValueChange = { password = it })
            }
        }

        Text(
            text = "I agree to all Term, Privacy Policy and fees",
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Normal,
                fontSize = 16.sp,
            ),
            modifier = Modifier.padding(top = 10.dp),
            color = Color.Gray
        )

        SignUpSubmitButton( {
            onSubmit(fullName, email, username, password)
        })
    }
}

@Composable
fun SignUpHeading(modifier: Modifier = Modifier) {
    Text(
        text = "Welcome Back",
        style = TextStyle(
            fontWeight = FontWeight.ExtraBold,
            fontStyle = FontStyle.Normal,
            fontSize = 40.sp
        ),
        modifier = modifier
    )
}

@Composable
fun SignUpSubmitButton(onSubmit: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = { onSubmit() },
        modifier = modifier
            .padding(top = 15.dp)
            .fillMaxWidth(0.9f)
            .height(60.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colorScheme.primary)
            .border(1.dp, Color.White),
    ) {
        Box (modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center){
            Text(
                text = "Sign Up",
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

@Composable
fun SignUpTextInput(name: String, icon: ImageVector, value: String, onValueChange: (String) -> Unit, modifier: Modifier = Modifier){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 5.dp)
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
                .padding(top = 0.dp, start = 18.dp, end = 10.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start

        ) {
            Icon(
                icon,
                contentDescription = "Username",
                modifier= Modifier.size(22.dp),
                tint = Color.Gray
            )
            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(start = 10.dp)
                    .border(2.dp, Color.White)
                    .background(Color.White),
                placeholder = {
                    Text(name)
                },
            )
        }
    }
}