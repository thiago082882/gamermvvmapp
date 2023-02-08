package com.thiago.gamermvvmapp.presentation.login.component

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.thiago.gamermvvmapp.R
import com.thiago.gamermvvmapp.components.DefaultButton
import com.thiago.gamermvvmapp.components.DefaultTextField
import com.thiago.gamermvvmapp.presentation.login.LoginViewModel
import com.thiago.gamermvvmapp.presentation.ui.theme.Darkgray500
import com.thiago.gamermvvmapp.presentation.ui.theme.GamerMVVMAPPTheme
import com.thiago.gamermvvmapp.presentation.ui.theme.Red500


@Composable
fun LoginContent(viewModel : LoginViewModel = hiltViewModel()) {
    Box(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(280.dp)
                .background(Red500)

        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Image(
                    modifier = Modifier.height(130.dp),
                    painter = painterResource(id = R.drawable.control),
                    contentDescription = "Controle de xbox 360"
                )
                Text(
                    text = "FIREBASE MVVM"
                )
            }

        }

        Card(
            modifier = Modifier.padding(start = 40.dp, end = 40.dp, top = 200.dp),
            backgroundColor = Darkgray500
        ) {

            Column(
                modifier = Modifier.padding(horizontal = 20.dp)

            ) {
                Text(
                    modifier = Modifier
                        .padding(
                            top = 40.dp,
                            bottom = 0.dp,
                            start = 0.dp,
                            end = 0.dp
                        ),

                    text = "LOGIN",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Por favor inicie a sessão para continuar",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
                DefaultTextField(
                    modifier = Modifier.padding(top = 25.dp),
                    value = viewModel.email.value,
                    onValueChange = { viewModel.email.value = it },
                    label = "Email",
                    icon = Icons.Default.Email,
                    keyboardType = KeyboardType.Email,
                    errorMsg = viewModel.emailErrorMsg.value,
                    validateField = {
                        viewModel.validateEmail()
                    }
                )
                DefaultTextField(
                    modifier = Modifier.padding(top = 5.dp),
                    value = viewModel.senha.value,
                    onValueChange = { viewModel.senha.value = it },
                    label = "Senha",
                    icon = Icons.Default.Lock,
                    hideText = true,
                    errorMsg = viewModel.senhaErrorMsg.value,
                    validateField = {
                        viewModel.validateSenha()
                    }
                )
                DefaultButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 40.dp),
                    text = "INICIAR SESSÃO",
                    onClick = {

                        Log.d("LoginContent", "Email: ${viewModel.email.value}")
                        Log.d("LoginContent", "Password:${viewModel.senha.value}")


                    },
                    enabled = viewModel.isEnableLoginButton
                )

            }
        }
        }
}


