package co.samplelist.data

import co.mukulpathak.adaptivelist.BaseModel
import co.samplelist.adaptiveList.R


data class SingleCard(val content : String, val color :Int) : BaseModel(){
    override fun getModelType(): Int {
        return R.layout.item_single_card
    }

    override fun getSpanSize(): Int {
        return SPAN_SIZE_25
    }
}