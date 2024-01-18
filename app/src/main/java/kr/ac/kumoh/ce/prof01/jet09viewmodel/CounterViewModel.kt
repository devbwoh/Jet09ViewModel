package kr.ac.kumoh.ce.prof01.jet09viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private val counter = CounterModel()

    private var _count = mutableIntStateOf(counter.count)
    val count: State<Int>
        get() = _count

    fun add() {
        counter.add()
        _count.intValue = counter.count
    }

    fun sub() {
        counter.sub()
        _count.intValue = counter.count
    }
}