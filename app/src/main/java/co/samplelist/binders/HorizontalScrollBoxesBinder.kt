package co.samplelist.binders

import android.view.LayoutInflater
import android.view.View
import co.mukulpathak.adaptivelist.*
import co.samplelist.ModelTypes
import co.samplelist.adaptiveList.databinding.BinderHorizontalLayoutBinding
import co.samplelist.adaptiveList.databinding.ItemSingleCardBinding
import co.samplelist.data.HorizonalLayoutData
import co.samplelist.data.SingleCard


class HorizontalScrollBoxesBinder : Binder<BaseModel> {
    override fun createInstance(parent: View, viewType: Int): BinderViewHolder<BaseModel> {
        return ViewHolder(
            BinderHorizontalLayoutBinding.inflate(LayoutInflater.from(parent.context))
        )
    }
    class ViewHolder(var itemHeaderBinding: BinderHorizontalLayoutBinding) : BinderViewHolder<BaseModel>(itemHeaderBinding.root) {
        override fun onBind(position: Int, multiViewItem: BaseModel) {
            val item = multiViewItem as HorizonalLayoutData
            itemHeaderBinding.apply {
                AdaptiveList<BaseModel>().apply {
                    registerViewHolders(getKey = {
                        ModelTypes.SINGLE_CARD
                    }, getView = {
                        ItemSingleCardBinding.inflate(LayoutInflater.from(it.context))
                    }, setData = { binding, data ->
                        val data = data as SingleCard

                        binding.apply {
                            btnText.text = data.content
                            root.setBackgroundColor(data.color)
                        }
                    })
                    setUpRecyclerView(recyclerview,1,orientation =  AdaptiveList.VIEW_TYPE_HORIZONTAL)
                    submitList(item.list)
                }
            }
        }
    }
    override fun getViewType(): Int {
        return ModelTypes.HORIZONTAL_SCROLL
    }
}

