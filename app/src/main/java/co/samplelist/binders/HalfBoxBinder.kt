package co.samplelist.binders

import android.view.LayoutInflater
import android.view.View
import co.mukulpathak.adaptivelist.BaseModel
import co.mukulpathak.adaptivelist.BinderViewHolder
import co.mukulpathak.adaptivelist.Binder
import co.samplelist.ModelTypes
import co.samplelist.adaptiveList.databinding.ItemHalfBoxBinding
import co.samplelist.data.HalfWidthCard



class HalfBoxBinder : Binder<BaseModel> {
    override fun createInstance(parent: View, viewType: Int): BinderViewHolder<BaseModel> {
        return ViewHolder(
            ItemHalfBoxBinding.inflate(LayoutInflater.from(parent.context))
        )
    }
    class ViewHolder(var itemHeaderBinding: ItemHalfBoxBinding) : BinderViewHolder<BaseModel>(itemHeaderBinding.root) {
        override fun onBind(position: Int, multiViewItem: BaseModel) {
            val item = multiViewItem as HalfWidthCard
            itemHeaderBinding.apply {
                btnText.text = item.content
                itemView.setBackgroundColor(item.color)
            }

        }
    }
    override fun getViewType(): Int {
        return ModelTypes.HALF_WIDTH
    }
}
