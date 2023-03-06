package com.course.canvas

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.course.canvas.ui.theme.CanvasTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalTextApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CanvasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val measurer = rememberTextMeasurer()

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .drawBehind {
                                drawLine(
                                    color = Color.Gray,
                                    start = Offset(x = size.width / 5, y = size.height / 5),
                                    end = Offset(x = size.width * 4 / 5, y = size.height / 5),
                                    strokeWidth = 2f
                                )
                                drawLine(
                                    color = Color.Gray,
                                    start = Offset(x = size.width / 5, y = size.height * 4 / 5),
                                    end = Offset(x = size.width * 4 / 5, y = size.height * 4 / 5),
                                    strokeWidth = 2f
                                )
                                drawLine(
                                    color = Color.Gray,
                                    start = Offset(x = size.width / 5, y = size.height / 5),
                                    end = Offset(x = size.width / 5, y = size.height * 4 / 5),
                                    strokeWidth = 2f
                                )
                                drawLine(
                                    color = Color.Gray,
                                    start = Offset(x = size.width * 4 / 5, y = size.height / 5),
                                    end = Offset(x = size.width * 4 / 5, y = size.height * 4 / 5),
                                    strokeWidth = 2f
                                )

                                drawCircle(
                                    color = Color.Blue,
                                    radius = size.width / 8,
                                    center = center
                                )
                                val bitmap = BitmapFactory.decodeResource(
                                    resources,
                                    R.drawable.icon_128
                                )
                                drawImage(
                                    image = bitmap.asImageBitmap(),
                                    topLeft = Offset(
                                        x = (size.width - bitmap.width) / 2,
                                        y = center.y - size.width / 2
                                    )
                                )
                                drawText(
                                    textMeasurer = measurer,
                                    text = "BMI",
                                    topLeft = Offset(
                                        x = center.x - size.width * 1 / 8,
                                        y = center.y + size.width / 4
                                    ),
                                    style = TextStyle(
                                        color = Color.Red,
                                        fontSize = 40.sp,
                                        textAlign = TextAlign.Center
                                    )
                                )
                            }
                    )
                }
            }
        }
    }
}
