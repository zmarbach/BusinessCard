package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material.icons.rounded.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCardScreen()
                }
            }
        }
    }
}

@Composable
fun BusinessCardScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0C2340))
    ){
        NameAndLogo(painterResource(id = R.drawable.new_york_yankees_logo_transparent),"Derek Jeter", "Hall of Fame Shortstop", Color.White, Modifier.weight(2f))
        ContactInformation("(123)-456-7890", "@jeter2", "derek.jeter@yankees.com", Color.White, Modifier.weight(1f))
    }
}

@Composable
fun NameAndLogo(image: Painter, name: String, jobTitle: String, textColor: Color, modifier: Modifier){
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = image, contentDescription = "Yankees logo", modifier = Modifier.size(200.dp).padding(bottom = 8.dp))
        Text(name, fontSize = 42.sp, color = textColor, modifier = Modifier.padding(8.dp))
        Text(jobTitle, fontSize = 20.sp, color = textColor)
    }

}

@Composable
fun ContactInformation(phone: String, social: String, email: String, textColor: Color, modifier: Modifier){
    val contactInfoRowModifier = Modifier.fillMaxWidth().padding(start = 50.dp, bottom = 8.dp)

    Column(
        modifier = modifier.fillMaxSize().padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = contactInfoRowModifier
        ) {
            Icon(
                imageVector = Icons.Rounded.Phone,
                modifier = Modifier.padding(end = 24.dp),
                contentDescription = "Phone icon",
                tint = textColor
            )
            Text(phone, fontSize = 20.sp, color = textColor)
        }
        Row(
            modifier = contactInfoRowModifier
        ) {
            Icon(
                imageVector = Icons.Rounded.ThumbUp,
                modifier = Modifier.padding(end = 24.dp),
                contentDescription = "Social icon",
                tint = textColor
            )
            Text(social, fontSize = 20.sp,color = textColor)

        }
        Row(
            modifier = contactInfoRowModifier
        ) {
            Icon(
                imageVector = Icons.Rounded.Email,
                modifier = Modifier.padding(end = 24.dp),
                contentDescription = "Email icon",
                tint = textColor
            )
            Text(email, fontSize = 20.sp, color = textColor)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardScreenPreview() {
    BusinessCardTheme {
        BusinessCardScreen()
    }
}