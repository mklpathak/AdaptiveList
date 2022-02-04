package co.samplelist.data

import co.mukulpathak.adaptivelist.BaseModel
import co.samplelist.ModelTypes
import co.samplelist.adaptiveList.R


data class SingleCard(val content : String, val color :Int) : BaseModel(){
    override fun getViewType(): Int {
        return ModelTypes.SINGLE_CARD
    }

    override fun getItemSpan(): Int {
        return 1
    }

}