package kr.ac.kumoh.ce.prof01.jet09viewmodel

class CounterModel {
    private var _count = 0
    val count: Int
        get() = _count

    fun add() {
        _count++
    }

    fun sub() {
        if (_count > 0)
            _count--
    }
}