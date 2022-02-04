package co.samplelist.binders

import android.view.LayoutInflater
import android.view.View
import co.mukulpathak.adaptivelist.BaseModel
import co.mukulpathak.adaptivelist.BinderViewHolder
import co.samplelist.data.FullWidthCard
import co.mukulpathak.adaptivelist.Binder
import co.samplelist.ModelTypes
import co.samplelist.adaptiveList.databinding.ItemFullBoxBinding


class FullBoxBinder : Binder<BaseModel> {
    override fun createInstance(parent: View, viewType: Int): BinderViewHolder<BaseModel> {
        return ViewHolder(
            ItemFullBoxBinding.inflate(LayoutInflater.from(parent.context))
        )
    }
    class ViewHolder(var itemHeaderBinding:  ItemFullBoxBinding) : BinderViewHolder<BaseModel>(itemHeaderBinding.root) {
        override fun onBind(position: Int, multiViewItem: BaseModel) {
            val item = multiViewItem as FullWidthCard
            itemHeaderBinding.apply {
                btnText.text = item.content
                itemView.setBackgroundColor(item.color)
            }
        }
    }
    override fun getViewType(): Int {
        return ModelTypes.FULL_WIDTH
    }
}