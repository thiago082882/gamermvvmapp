package com.thiago.gamermvvmapp.screens.detail_post.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.thiago.gamermvvmapp.R
import com.thiago.gamermvvmapp.presentation.ui.theme.GamerMVVMAPPTheme
import com.thiago.gamermvvmapp.presentation.ui.theme.Red500
import com.thiago.gamermvvmapp.screens.detail_post.DetailPostViewModel

@Composable
fun DetailPostContent(
    navController: NavHostController,
    viewModel: DetailPostViewModel = hiltViewModel(),
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {

        Box() {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                model = viewModel.post.image,
                contentDescription = "",
                contentScale = ContentScale.Crop

            )
            IconButton(onClick = { navController?.popBackStack() }) {
                Icon(
                    modifier = Modifier.size(35.dp),
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }
        if (!viewModel.post.user?.username.isNullOrBlank()) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp, horizontal = 15.dp),
                elevation = 4.dp,
                shape = RoundedCornerShape(12.dp)
            ) {

                Row(
                    modifier = Modifier.padding(vertical = 18.dp, horizontal = 15.dp)

                ) {
                    AsyncImage(
                        modifier = Modifier
                            .size(55.dp)
                            .clip(CircleShape),
                        model = viewModel.post.user?.image,
                        contentDescription = "",
                        contentScale = ContentScale.Crop

                    )
                    Column(
                        modifier = Modifier.padding(top = 7.dp, start = 20.dp)
                    ) {
                        Text(
                            text = viewModel.post.user?.username!!,
                            fontSize = 14.sp
                        )
                        Text(
                            text = viewModel.post.user?.email!!,
                            fontSize = 12.sp
                        )
                    }

                }

            }
        } else {
            Spacer(modifier = Modifier.height(15.dp))
        }

        Text(
            modifier = Modifier.padding(start = 20.dp, bottom = 15.dp),
            text = viewModel.post.name,
            fontSize = 20.sp,
            color = Red500,
            fontWeight = FontWeight.Bold
        )
        Card(
            modifier = Modifier.padding(start = 13.dp, bottom = 15.dp),
            elevation = 4.dp,
            shape = RoundedCornerShape(20.dp)
        ) {
            Row(
                modifier = Modifier.padding(vertical = 7.dp, horizontal = 20.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier.size(25.dp),
                    painter = painterResource(
                        id = if (viewModel.post.category == "PC") R.drawable.icon_pc
                        else if (viewModel.post.category == "XBOX") R.drawable.icon_xbox
                        else if (viewModel.post.category == "PS4") R.drawable.icon_ps4
                        else if (viewModel.post.category == "NINTENDO") R.drawable.icon_nintendo
                        else R.drawable.icon_mobile
                    ),
                    contentDescription = ""
                )

                Spacer(
                    modifier = Modifier.width(7.dp)
                )
                Text(
                    text = viewModel.post.category,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp
                )
            }

        }
        Divider(
            modifier = Modifier.padding(end = 20.dp, top = 10.dp, bottom = 10.dp),
            startIndent = 20.dp,
            thickness = 1.dp,
            color = Color.DarkGray
        )

        Text(
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
            text = "DESCRIÇÃO",
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp
        )
        Text(
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 5.dp),
            text = viewModel.post.description,
            fontSize = 14.sp
        )
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewDetailPostContent() {
    GamerMVVMAPPTheme(darkTheme = true) {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            DetailPostContent(rememberNavController())
        }
    }
}
