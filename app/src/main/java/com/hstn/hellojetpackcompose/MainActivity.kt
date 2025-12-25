package com.hstn.hellojetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()

            var message by rememberSaveable(){ mutableStateOf(  "Hello METANIT.COM")}
            Text(
                text = message,
                fontSize = 25.sp,
                modifier = Modifier.clickable( onClick = { message = "Helo World"})
                    .padding(30.dp)
            )
        }
    }
}


@Composable
fun MainScreen() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(Color(0xFFF3F2F0))
            .fillMaxSize(1f)
    ) {
        Column {
            HelloLine("Анастасия")
            ProgressLine()
            CurrentNote()
        }

    }
}

@Composable
fun HelloLine(name:String){
    Row() {
        Column() {
            Text(
                text = "Привет, $name \uD83D\uDC4B",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Сегодня, 15 марта",
                color = Color(0xff7F7C7A),
                modifier = Modifier.padding(top = 10.dp)
            )
        }
        OutlinedButton(
            onClick = {},
            colors = ButtonDefaults.outlinedButtonColors(
                Color.White
            ),
            border = null,
            shape = CircleShape,
            contentPadding = PaddingValues(0.dp),
            modifier = Modifier.padding(start = 30.dp)
                .shadow(elevation = 1.dp, shape = CircleShape, clip = true )
                .size(40.dp)
            ,
        ) {
            Text(
                text = "☾",
                fontSize = 30.sp,
                modifier = Modifier.rotate(320f)
            )
        }

    }
}

@Composable
fun CurrentNote() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.padding(top = 20.dp)
            .shadow(elevation = 1.dp, shape = RoundedCornerShape(10.dp), clip = true)
            .clip(shape = RoundedCornerShape(10.dp))
            .size(height = 150.dp, width = 315.dp )
            .background(Color.White)
    ) {
        Column {
            Row {
                Image(
                    painter = painterResource(R.drawable.books),
                    contentDescription = "Hello "
                )
                Column (
                    modifier = Modifier.padding(start = 20.dp)
                ){
                    Text(
                        text = "Водный баланс",
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Пил воду сегодня?",
                        color = Color(0xFF707070),
                        modifier = Modifier.padding(top = 5.dp)
                    )
                }

            }
            Box(
                modifier = Modifier.padding(top = 20.dp).width(250.dp).height(1.dp)
                    .background(color = Color(0xFF707070).copy(alpha = 0.25f))

            ){}
            Row {

            }
        }
    }
}


@Composable
fun ProgressLine(){
    val current = 2f
    val total = 3f
    val progress = (current / total).coerceAtMost(1f)

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.padding(top = 20.dp)
            .shadow(elevation = 0.25.dp, shape = RoundedCornerShape(10.dp), clip = true)
            .clip(shape = RoundedCornerShape(10.dp))
            .size(height = 150.dp, width = 315.dp )
            .background(Color(0xFFFBFBFB))
    ){
        Column{
            Row {
                Text(
                    text = "Прогресс дня",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "" + current.toInt() + "/"+ total.toInt(),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 120.dp)
                )
            }
            GradientProgressBar(
                progress = current / total,
                modifier = Modifier.padding(top = 20.dp)
                    .width(260.dp)
                    .height(10.dp),
                gradientColors = listOf(
                    Color(0xFF00C9FF), 
                    Color(0xFF92FE9D)
                ),
                backgroundColor = Color(0xFFE6E6E6)
            )
            Text(
                text = "Отличная работа! Продолжай в том же духе \uD83C\uDF89",
                color = Color(0xFF9B9B9B),
                modifier = Modifier.padding(top = 20.dp)
                    .width(260.dp)
            )


        }
    }
}



@Composable
fun SwitchCastom (){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize(1f)
    ){
        Box (
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(Color(0xFFD9F9B8))
                .clickable{

                }

        ){
            Text(
                text = "✔\uFE0E",
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }
}
@Composable
fun GradientProgressBar(
    progress: Float,
    modifier: Modifier = Modifier,
    height: Dp = 8.dp,
    gradientColors: List<Color> = listOf(Color.Blue, Color.White),
    backgroundColor: Color = Color.LightGray
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .clip(RoundedCornerShape(height / 2))
            .background(backgroundColor)
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(height / 2))
                .fillMaxWidth(progress)
                .fillMaxHeight()
                .background(
                    brush = Brush.horizontalGradient(gradientColors)
                )

        )
    }
}




@Preview(showSystemUi = true)
@Composable
fun MainScreenPreview() {
//    MainScreen()
//    SwitchCastom()

}