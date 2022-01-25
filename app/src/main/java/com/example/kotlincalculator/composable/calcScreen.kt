package com.example.kotlincalculator.composable

import android.view.View
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.absoluteValue

@Composable
fun calcScreen() {
    val ansValue: MutableState<Int> = remember { mutableStateOf(0)}
    val ansHold: MutableState<Int> = remember { mutableStateOf(0)}
    val charHold: MutableState<Char> = remember { mutableStateOf('0')}
    var result: Boolean = false
    var display1: String =
        if (ansValue.value==0)
             ""
        else (if (ansValue.value!=0 && charHold.value=='0')
            ansValue.value.toString()
        else if (ansValue.value!=0 && charHold.value!='0'&& ansHold.value==0)
            ansValue.value.toString()+" "+charHold.value.toString()
        else if(ansValue.value!=0 && charHold.value!='0'&& ansHold.value!=0)
            ansValue.value.toString()+" "+charHold.value.toString()+" "+ansHold.value.toString()
        else
            if (result)
                ansValue.value.toString()
            else
                "") as String


    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF25A5BE))
    ) {
        LazyRow(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth()
                .border(width = 2.dp, color = Color.Black)
        ) {
           item { Text(
               text = display1,
               fontSize = 40.sp,
               color = Color.Black,
               fontWeight = FontWeight.Medium
           ) }
        }
        Spacer(modifier = Modifier.padding(5.dp))
        Row(horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth()
                .border(width = 2.dp, color = Color.Black)) {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .border(width = 1.dp, color = Color.Black)
                    .fillMaxHeight()
                    .width(98.dp)
            ) {
                Button(onClick = {
                    ansValue.value = 0
                    ansHold.value = 0
                    result = false
                }, modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(0xFF2596BE))) {
                    Text(text = "C", style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 30.sp))
                }
            }
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .border(width = 1.dp, color = Color.Black)
                    .fillMaxHeight()
                    .width(98.dp)
            ) {
                Button(onClick = { charHold.value = '%' }, modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(0xFF25A5BE)) ) {
                    Text(text = "%", style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 30.sp))
                }
            }
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .border(width = 1.dp, color = Color.Black)
                    .fillMaxHeight()
                    .width(98.dp)
            ) {
                Button(onClick = {
                    if(ansValue.value == 0)
                        return@Button
                    else
                        if(charHold.value=='0')
                            ansValue.value= ansValue.value/10
                        else if (ansHold.value == 0)
                            charHold.value = '0'
                        else
                            ansHold.value = ansHold.value/10
                }, modifier = Modifier.fillMaxSize() ) {
                    Text(text = "<-", style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 30.sp))
                }
            }
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .border(width = 1.dp, color = Color.Black)
                    .fillMaxHeight()
                    .width(98.dp)
            ) {
                Button(onClick = { charHold.value = '/' }, modifier = Modifier.fillMaxSize() ) {
                    Text(text = "/", style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 30.sp))
                }
            }
            
        }
        Spacer(modifier = Modifier.padding(1.dp))
        Row(horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth()
                .border(width = 2.dp, color = Color.Black)) {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .border(width = 1.dp, color = Color.Black)
                    .fillMaxHeight()
                    .width(98.dp)
            ) {
                Button(onClick = {
                    if(ansValue.value == 0)
                        ansValue.value = 7
                    else
                        if(charHold.value=='0')
                            ansValue.value= ansValue.value*10 + 7
                        else if (ansHold.value == 0)
                            ansHold.value = 7
                        else
                            ansHold.value = ansHold.value*10 + 7
                }, modifier = Modifier.fillMaxSize() ) {
                    Text(text = "7", style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 30.sp))
                }
            }
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .border(width = 1.dp, color = Color.Black)
                    .fillMaxHeight()
                    .width(98.dp)
            ) {
                Button(onClick = {
                    if(ansValue.value == 0)
                        ansValue.value = 8
                    else
                        if(charHold.value=='0')
                            ansValue.value= ansValue.value*10 + 8
                        else if (ansHold.value == 0)
                            ansHold.value = 8
                        else
                            ansHold.value = ansHold.value*10 + 8
                }, modifier = Modifier.fillMaxSize() ) {
                    Text(text = "8", style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 30.sp))
                }
            }
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .border(width = 1.dp, color = Color.Black)
                    .fillMaxHeight()
                    .width(98.dp)
            ) {
                Button(onClick = {
                    if(ansValue.value == 0)
                        ansValue.value = 9
                    else
                        if(charHold.value=='0')
                            ansValue.value= ansValue.value*10 + 9
                        else if (ansHold.value == 0)
                            ansHold.value = 9
                        else
                            ansHold.value = ansHold.value*10 + 9
                }, modifier = Modifier.fillMaxSize() ) {
                    Text(text = "9", style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 30.sp))
                }
            }
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .border(width = 1.dp, color = Color.Black)
                    .fillMaxHeight()
                    .width(98.dp)
            ) {
                Button(onClick = {
                    charHold.value = '*'
                }, modifier = Modifier.fillMaxSize() ) {
                    Text(text = "*", style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 30.sp))
                }
            }
        }
        Spacer(modifier = Modifier.padding(1.dp))
        Row(horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth()
                .border(width = 2.dp, color = Color.Black)) {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .border(width = 1.dp, color = Color.Black)
                    .fillMaxHeight()
                    .width(98.dp)
            ) {
                Button(onClick = {
                    if(ansValue.value == 0)
                        ansValue.value = 4
                    else
                        if(charHold.value=='0')
                            ansValue.value= ansValue.value*10 + 4
                        else if (ansHold.value == 0)
                            ansHold.value = 4
                        else
                            ansHold.value = ansHold.value*10 + 4
                }, modifier = Modifier.fillMaxSize() ) {
                    Text(text = "4", style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 30.sp))
                }
            }
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .border(width = 1.dp, color = Color.Black)
                    .fillMaxHeight()
                    .width(98.dp)
            ) {
                Button(onClick = {
                    if(ansValue.value == 0)
                        ansValue.value = 5
                    else
                        if(charHold.value=='0')
                            ansValue.value= ansValue.value*10 + 5
                        else if (ansHold.value == 0)
                            ansHold.value = 5
                        else
                            ansHold.value = ansHold.value*10 + 5
                }, modifier = Modifier.fillMaxSize() ) {
                    Text(text = "5", style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 30.sp))
                }
            }
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .border(width = 1.dp, color = Color.Black)
                    .fillMaxHeight()
                    .width(98.dp)
            ) {
                Button(onClick = {
                    if(ansValue.value == 0)
                        ansValue.value = 9
                    else
                        if(charHold.value=='0')
                            ansValue.value= ansValue.value*10 + 6
                        else if (ansHold.value == 0)
                            ansHold.value = 6
                        else
                            ansHold.value = ansHold.value*10 + 6
                }, modifier = Modifier.fillMaxSize() ) {
                    Text(text = "6", style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 30.sp))
                }
            }
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .border(width = 1.dp, color = Color.Black)
                    .fillMaxHeight()
                    .width(98.dp)
            ) {
                Button(onClick = {
                    charHold.value = '-'
                }, modifier = Modifier.fillMaxSize() ) {
                    Text(text = "-", style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 30.sp))
                }
            }
        }
        Spacer(modifier = Modifier.padding(1.dp))
        Row(horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth()
                .border(width = 2.dp, color = Color.Black)) {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .border(width = 1.dp, color = Color.Black)
                    .fillMaxHeight()
                    .width(98.dp)
            ) {
                Button(onClick = {
                    if(ansValue.value == 0)
                        ansValue.value = 1
                    else
                        if(charHold.value=='0')
                            ansValue.value= ansValue.value*10 + 1
                        else if (ansHold.value == 0)
                            ansHold.value = 1
                        else
                            ansHold.value = ansHold.value*10 + 1
                }, modifier = Modifier.fillMaxSize() ) {
                    Text(text = "1", style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 30.sp))
                }
            }
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .border(width = 1.dp, color = Color.Black)
                    .fillMaxHeight()
                    .width(98.dp)
            ) {
                Button(onClick = {
                    if(ansValue.value == 0)
                        ansValue.value = 2
                    else
                        if(charHold.value=='0')
                            ansValue.value= ansValue.value*10 + 2
                        else if (ansHold.value == 0)
                            ansHold.value = 2
                        else
                            ansHold.value = ansHold.value*10 + 2
                }, modifier = Modifier.fillMaxSize() ) {
                    Text(text = "2", style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 30.sp))
                }
            }
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .border(width = 1.dp, color = Color.Black)
                    .fillMaxHeight()
                    .width(98.dp)
            ) {
                Button(onClick = {
                    if(ansValue.value == 0)
                        ansValue.value = 3
                    else
                        if(charHold.value=='0')
                            ansValue.value= ansValue.value*10 + 3
                        else if (ansHold.value == 0)
                            ansHold.value = 3
                        else
                            ansHold.value = ansHold.value*10 + 3
                }, modifier = Modifier.fillMaxSize() ) {
                    Text(text = "3", style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 30.sp))
                }
            }
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .border(width = 1.dp, color = Color.Black)
                    .fillMaxHeight()
                    .width(98.dp)
            ) {
                Button(onClick = { charHold.value = '+' }, modifier = Modifier.fillMaxSize() ) {
                    Text(text = "+", style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 30.sp))
                }
            }

        }
        Spacer(modifier = Modifier.padding(1.dp))
        Row(horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth()
                .border(width = 2.dp, color = Color.Black)) {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .border(width = 1.dp, color = Color.Black)
                    .fillMaxHeight()
                    .width(98.dp)
            ) {
                Button(onClick = {
                    if(ansValue.value == 0)
                        return@Button
                    else
                        if(charHold.value=='0')
                            ansValue.value= ansValue.value*100
                        else
                            ansHold.value = ansHold.value*100
                }, modifier = Modifier.fillMaxSize() ) {
                    Text(text = "00", style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 30.sp))
                }
            }
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .border(width = 1.dp, color = Color.Black)
                    .fillMaxHeight()
                    .width(98.dp)
            ) {
                Button(onClick = {
                    if(ansValue.value == 0)
                        return@Button
                    else
                        if(charHold.value=='0')
                            ansValue.value= ansValue.value*10
                        else
                            ansHold.value = ansHold.value*10
                }, modifier = Modifier.fillMaxSize() ) {
                    Text(text = "0", style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 30.sp))
                }
            }
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .border(width = 1.dp, color = Color.Black)
                    .fillMaxHeight()
                    .width(98.dp)
            ) {
                Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxSize() ) {
                    Text(text = ".", style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 30.sp))
                }
            }
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .border(width = 1.dp, color = Color.Black)
                    .fillMaxHeight()
                    .width(98.dp)
            ) {
                Button(onClick = {
                    if(ansValue.value == 0 || ansHold.value ==0|| charHold.value == '0')
                        return@Button
                    else
                        if (charHold.value == '*'){
                            ansValue.value*=ansHold.value
                            result = true
                            charHold.value='0'
                        }
                        else if (charHold.value == '-'){
                            ansValue.value-=ansHold.value
                            result = true
                            charHold.value='0'
                        }
                        else if (charHold.value == '+'){
                            ansValue.value+=ansHold.value
                            result = true
                            charHold.value='0'
                        }
                        else if (charHold.value == '%'){
                            ansValue.value%=ansHold.value
                            result = true
                            charHold.value='0'
                        }
                        else if (charHold.value == '/'){
                            ansValue.value/=ansHold.value
                            result = true
                            charHold.value='0'
                        }
                }, modifier = Modifier.fillMaxSize() ) {
                    Text(text = "=", style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 30.sp))
                }
            }
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Button(onClick = { ansValue.value += 20 },modifier = Modifier
            .height(50.dp)
            .width(100.dp)
            .border(
                BorderStroke(width = 2.dp, color = Color.Black),
                shape = RoundedCornerShape(12.dp)
            )) {
            Text(text = "Increment",style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 20.sp))
        }
    }
}