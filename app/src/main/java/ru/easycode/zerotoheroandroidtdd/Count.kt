package ru.easycode.zerotoheroandroidtdd

interface Count {

    fun increment(number:String):UiState
    fun decrement(number: String):UiState
    fun initial(number:String):UiState

    data class Base(
        private val step:Int,
        private val max:Int,
        private val min:Int,
        ):Count {

    init {
        if (step < 1 ) {
            throw IllegalStateException("step should be positive, but was $step")
        }
        if (max < 1){
            throw IllegalStateException("max should be positive, but was $max")
        }
        if (step>=max){
            throw IllegalStateException("max should be more than step")
        }
        if (max<min){
            throw IllegalStateException("max should be more than min")
        }

    }
        override fun increment(number: String): UiState {
                val result = number.toInt() + step
                if (result >= max)
                return UiState.Max(max.toString())
                return if (result > max-step)
                    UiState.Max(result.toString())
                else
                    UiState.Base(result.toString())
        }

        override fun decrement(number: String): UiState {
            val result = number.toInt() - step
            return if (result <= min)
                 UiState.Min(min.toString())
            else UiState.Base(result.toString())
        }

        override fun initial(number: String): UiState {
            if (number.toInt() >= max)
                return UiState.Max(max.toString())
            if (number.toInt() == min)
                    return UiState.Min(number)
            else return UiState.Base(number)

        }
    }

}
