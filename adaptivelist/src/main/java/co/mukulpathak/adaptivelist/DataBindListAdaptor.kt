package co.mukulpathak.adaptivelist

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import java.lang.IndexOutOfBoundsException

class DataBindListAdaptor(
        private val viewHolderProvider: DataController,
        diffUtil: DiffUtil.ItemCallback<BaseModel>) : ListAdapter<BaseModel, DataBindViewHolder>(
   diffUtil
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBindViewHolder {
        return viewHolderProvider.createViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: DataBindViewHolder, position: Int) {
        holder.onBindVewHolder(position, getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).getModelType()
    }

    fun getSpan(position: Int): Int {
       return try{
            getItem(position).getSpanSize()
       } catch (e:IndexOutOfBoundsException){
           -1
       }
    }
}