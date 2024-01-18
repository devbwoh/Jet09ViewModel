package kr.ac.kumoh.ce.prof01.jet09viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    // Counter 1------------------------------------------
    private val counter1 = CounterModel()

    private var _count1 = mutableIntStateOf(counter1.count)
    val count1: State<Int>
        get() = _count1

    fun add1() {
        counter1.add()
        _count1.intValue = counter1.count
    }

    fun sub1() {
        counter1.sub()
        _count1.intValue = counter1.count
    }

    // Counter 2------------------------------------------
    private val counter2 = CounterModel()

    private var _count2 = mutableIntStateOf(counter1.count)
    val count2: State<Int>
        get() = _count2

    fun add2() {
        counter2.add()
        _count2.intValue = counter2.count
    }

    fun sub2() {
        counter2.sub()
        _count2.intValue = counter2.count
    }
}