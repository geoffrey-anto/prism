package com.arians.marqrar.user

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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

class HomeActivity: ComponentActivity() {
    private fun goQRScanPage() {
        val scanQrIntent = Intent(this, ScanQR::class.java)
        startActivity(scanQrIntent)
    }

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
                    Column {
                        Row(modifier = Modifier
                            .height(80.dp)
                            .clip(RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp))
                            .background(MaterialTheme.colorScheme.primary)
                        ){
                            Image(
                                painter = painterResource(R.drawable.arrow_down),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(50.dp)
                                    .height(50.dp)
                                    .padding(top = 20.dp, start = 20.dp)
                            )
                            Spacer(modifier = Modifier.weight(4f))

                            Image(
                                painter = painterResource(R.drawable.avatar),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(50.dp)
                                    .height(50.dp)
                                    .padding(top = 20.dp, end = 20.dp)
                            )
                        }

                        Row(modifier = Modifier.padding(top=80.dp, start=40.dp)) {
                            Spacer(modifier = Modifier.height(20.dp))
                            Text("Good Morning!", fontSize = 30.sp, color = Color.Black)
                        }

                        Spacer(modifier = Modifier.height(60.dp))

                        Column(modifier = Modifier.padding(top=20.dp, start=40.dp), verticalArrangement = Arrangement.spacedBy(15.dp), Alignment.CenterHorizontally) {
                            Spacer(modifier = Modifier.height(20.dp))
                            Text("Scan QR Code to Begin a Repair Recipe", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.Black)
                            Text(text = "Click on + to add a new Recipe", fontSize = 16.sp, color = Color.Black)
                        }

                        Spacer(modifier = Modifier.weight(4f))

                        Row(modifier = Modifier
                            .height(80.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp))
                            .background(MaterialTheme.colorScheme.primary)
                        ){
                            Spacer(modifier = Modifier.weight(4f, true))
                            Image(
                                painter = painterResource(R.drawable.calendar),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(70.dp)
                                    .height(70.dp)
                                    .padding(top = 10.dp)
                            )
                            Spacer(modifier = Modifier.weight(4f, true))

                            Button(onClick = { goQRScanPage() }) {
                                Image(
                                    painter = painterResource(R.drawable.button_icon),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .width(70.dp)
                                        .height(70.dp)
                                        .padding(top = 10.dp)
                                )
                            }

                            Spacer(modifier = Modifier.weight(4f, true))

                            Image(
                                painter = painterResource(R.drawable.planner),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(70.dp)
                                    .height(70.dp)
                                    .padding(top = 10.dp)
                            )

                            Spacer(modifier = Modifier.weight(4f, true))
                        }
                    }

                }
            }
        }
    }
}