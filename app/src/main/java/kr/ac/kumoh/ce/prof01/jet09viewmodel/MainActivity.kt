package kr.ac.kumoh.ce.prof01.jet09viewmodel

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import kr.ac.kumoh.ce.prof01.jet09viewmodel.ui.theme.Jet09ViewModelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val viewModel: CounterViewModel = viewModel()

    Jet09ViewModelTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            if (LocalConfiguration.current.orientation
                    == Configuration.ORIENTATION_PORTRAIT) {
                Column {
                    Box (modifier = Modifier.weight(1F)) {
                        Counter(
                            Modifier.background(Color(0xFFFE7A36)),
                            viewModel.count,
                            { viewModel.add() },
                            { viewModel.sub() },
                        )
                    }
//                    Box (modifier = Modifier.weight(1F)) {
//                        Counter(
//                            Modifier.background(Color(0xFF280274)),
//                            viewModel.count,
//                            { viewModel.add() },
//                            { viewModel.sub() },
//                        )
//                    }
                }
            }
            else {
                Row {
                    Box (modifier = Modifier.weight(1F)) {
                        Counter(
                            Modifier.background(Color(0xFFFE7A36)),
                            viewModel.count,
                            { viewModel.add() },
                            { viewModel.sub() },
                        )
                    }
//                    Box (modifier = Modifier.weight(1F)) {
//                        Counter(
//                            Modifier.background(Color(0xFF280274)),
//                            viewModel.count,
//                            { viewModel.add() },
//                            { viewModel.sub() },
//                        )
//                    }
                }
            }
        }
    }
}

@Composable
fun Counter(
    modifier: Modifier = Modifier,
    state: State<Int>,
    onAddCount: () -> Unit,
    onSubCount: () -> Unit,
    //viewModel: CounterViewModel = viewModel(),
) {
    val count by state

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(Color(0XFFE9F6FF)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = count.toString(),
            modifier = modifier
                .padding(8.dp)
                .fillMaxWidth(),
            color = Color.White,
            fontSize = 100.sp,
            textAlign = TextAlign.Center,
        )

        Row {
            Button(
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1F),
                onClick = {
                    //viewModel.add()
                    onAddCount()
                }
            ) {
                Text("증가", fontSize = 30.sp)
            }

            Spacer(modifier = Modifier.size(8.dp))

            Button(
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1F),
                onClick = {
                    //viewModel.sub()
                    onSubCount()
                }
            ) {
                Text("감소", fontSize = 30.sp)
            }
        }
    }
}