package com.arians.marqrar.user


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arians.marqrar.R
import com.arians.marqrar.ui.theme.MarQRARTheme

class ScanQR : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MarQRARTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .clip(RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp))
                            .background(Color.White),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier
                                .height(80.dp)
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp))
                                .background(MaterialTheme.colorScheme.primary),

                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Button(onClick = {
                            }) {
                                Image(
                                    painter = painterResource(R.drawable.arrow_left),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .width(50.dp)
                                        .height(50.dp)
                                        .padding(start = 20.dp)
                                )
                            }

                            Spacer(modifier = Modifier.width(10.dp))

                            Text("Scan QR", fontSize = 20.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Box(
                                modifier = Modifier
                                    .padding(10.dp)
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(MaterialTheme.colorScheme.primary)
                            ) {
                                Text("  Scan QR code  ", fontSize = 16.sp, fontWeight = FontWeight.SemiBold, color = Color.White, modifier = Modifier.padding(10.dp))
                            }

                            Spacer(modifier = Modifier.width(20.dp))

                            Surface(
                                modifier = Modifier
                                    .padding(10.dp)
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(MaterialTheme.colorScheme.primary)
                            ) {
                                Text("Enter code", fontSize = 16.sp, fontWeight = FontWeight.SemiBold, color = Color.Black, modifier = Modifier.padding(10.dp))
                            }
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Text("Place the QR code in the viewfinder to scan", fontSize = 16.sp, fontWeight = FontWeight.SemiBold, color = Color.Black, modifier = Modifier.padding(10.dp))
                    }
                }
            }
        }
    }
}
