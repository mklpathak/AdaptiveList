package co.samplelist.data

import co.mukulpathak.adaptivelist.BaseModel
import co.samplelist.ModelTypes
import co.samplelist.adaptiveList.R


data class FullWidthCard(val content : String, val color :Int): BaseModel(){


    override fun getViewType(): Int {
       return ModelTypes.FULL_WIDTH

    }

    override fun getItemSpan(): Int {
        return 4
    }
}