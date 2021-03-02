package co.mukulpathak.adaptivelist

abstract class BaseModel {
    abstract fun getModelType():Int
    open fun getSpanSize():Int{
        return SPAN_SIZE_100
    }
    companion object{
        const val SPAN_SIZE_100 = 4
        const val SPAN_SIZE_75 = 3
        const val SPAN_SIZE_50 = 2
        const val SPAN_SIZE_25 = 1
    }

}