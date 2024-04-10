package com.arians.marqrar

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arians.marqrar.auth.LoginActivity
import com.arians.marqrar.auth.SignUpActivity
import com.arians.marqrar.ui.theme.MarQRARTheme

class MainActivity : ComponentActivity() {
    private fun goToLogin() {
        val loginIntent = Intent(this, LoginActivity::class.java)
        startActivity(loginIntent)
    }

    private fun goToSignup() {
        val signupIntent = Intent(this, SignUpActivity::class.java)
        startActivity(signupIntent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MarQRARTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginSignupScreen(
                        onLoginClick = { goToLogin() },
                        onSignupClick = { goToSignup() }
                    )
                }
            }
        }
    }
}

@Composable
fun LoginSignupScreen(
    onLoginClick: () -> Unit,
    onSignupClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Heading(text = "Welcome to MarQR.AR")
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = onLoginClick) {
            Text(text = "Login")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onSignupClick) {
            Text(text = "Signup")
        }
    }
}

@Composable
fun Heading(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.headlineLarge
    )
}