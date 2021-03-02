package co.samplelist.data

import co.mukulpathak.adaptivelist.BaseModel
import co.samplelist.adaptiveList.R


data class HalfWidthCard(val content : String, val color :Int): BaseModel(){
    override fun getModelType(): Int {
        return R.layout.item_half_box
    }

    override fun getSpanSize(): Int {
        return SPAN_SIZE_50
    }

}