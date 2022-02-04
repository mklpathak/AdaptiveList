package co.samplelist.binders


import android.view.LayoutInflater
import android.view.View
import co.mukulpathak.adaptivelist.BaseModel
import co.mukulpathak.adaptivelist.BinderViewHolder
import co.mukulpathak.adaptivelist.Binder
import co.samplelist.ModelTypes
import co.samplelist.adaptiveList.databinding.ItemSingleCardBinding
import co.samplelist.data.SingleCard

class SingleCardBinder : Binder<BaseModel> {
    override fun createInstance(parent: View, viewType: Int): BinderViewHolder<BaseModel> {
        return ViewHolder(
            ItemSingleCardBinding.inflate(LayoutInflater.from(parent.context))
        )
    }
    class ViewHolder(var itemHeaderBinding: ItemSingleCardBinding) : BinderViewHolder<BaseModel>(itemHeaderBinding.root) {
        override fun onBind(position: Int, multiViewItem: BaseModel) {
            val item = multiViewItem as SingleCard
            itemHeaderBinding.apply {
                btnText.text = item.content
                itemView.setBackgroundColor(item.color)
            }
        }
    }
    override fun getViewType(): Int {
        return ModelTypes.SINGLE_CARD
    }
}
