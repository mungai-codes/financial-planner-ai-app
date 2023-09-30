package com.example.financial_planner_ai_app.login_screen

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import com.example.financial_planner_ai_app.R
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(){
    val scale = remember{
       Animatable(0f)
    }
    LaunchedEffect(key1 = true){
        scale.animateTo(
            targetValue = 0.3f,
            animationSpec = tween(
                durationMillis = 500,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        delay(3000L)
        //navController.navigate("login_screen")
    }
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
        ){
        Image(
            painter = painterResource(id = R.drawable.credit_card),
            contentDescription = "Logo",
            modifier = Modifier.scale(scale.value)
        )

    }
}