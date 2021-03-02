package co.samplelist.data

import co.mukulpathak.adaptivelist.BaseModel
import co.samplelist.adaptiveList.R


data class HorizonalLayoutData(var heading : String, var list: List<BaseModel>): BaseModel (){
    override fun getModelType(): Int {
        return R.layout.binder_horizontal_layout
    }
    override fun getSpanSize(): Int {
        return SPAN_SIZE_100
    }
}