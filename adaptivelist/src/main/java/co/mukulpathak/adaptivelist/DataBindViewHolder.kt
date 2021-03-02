package co.mukulpathak.adaptivelist

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class DataBindViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    open fun onBindVewHolder(position:Int, multiViewItem: BaseModel) {

    }
    open fun onViewDetached(position: Int, multiViewItem: BaseModel) {
    }

}