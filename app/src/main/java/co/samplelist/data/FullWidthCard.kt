package co.samplelist.data

import co.mukulpathak.adaptivelist.BaseModel
import co.samplelist.adaptiveList.R


data class FullWidthCard(val content : String, val color :Int): BaseModel(){
    override fun getModelType(): Int {
        return R.layout.item_full_box
    }
}