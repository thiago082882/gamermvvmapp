package com.thiago.gamermvvmapp.presentation.login.component

import android.support.v4.os.IResultReceiver.Default
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.thiago.gamermvvmapp.presentation.navigation.AppScreen

@Composable
fun LoginBottomBar(navController: NavHostController){

    Row(
   modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp),
        horizontalArrangement = Arrangement.Center

    ) {
        Text(
            text = "Não tem uma conta?",
            fontSize = 14.sp,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.width(7.dp))
        Text(
            modifier = Modifier.clickable {
                 navController.navigate(route = AppScreen.SignUp.route)
            },
            text = "REGISTRE AQUI",
            color = Color.Red,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold


        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginBottomBar(){

    LoginBottomBar(rememberNavController())

}
