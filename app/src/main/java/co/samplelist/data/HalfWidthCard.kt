package co.samplelist.data

import co.mukulpathak.adaptivelist.BaseModel
import co.samplelist.ModelTypes
import co.samplelist.adaptiveList.R


data class HalfWidthCard(val content : String, val color :Int): BaseModel(){
    override fun getViewType(): Int {
        return ModelTypes.HALF_WIDTH
    }

    override fun getItemSpan(): Int {
        return 2
    }
}