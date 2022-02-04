package co.samplelist.data

import android.view.Display
import co.mukulpathak.adaptivelist.BaseModel
import co.samplelist.ModelTypes
import co.samplelist.adaptiveList.R


data class HorizonalLayoutData(var heading : String, var list: List<BaseModel>): BaseModel(){
    override fun getViewType(): Int {
       return ModelTypes.HORIZONTAL_SCROLL
    }

    override fun getItemSpan(): Int {
      return 4
    }

}