package co.samplelist.binders


import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import co.mukulpathak.adaptivelist.BaseModel
import co.mukulpathak.adaptivelist.DataBindViewHolder
import co.mukulpathak.adaptivelist.DataHolderModels
import co.samplelist.adaptiveList.R
import co.samplelist.data.SingleCard
import kotlinx.android.synthetic.main.item_single_card.view.*

class SingleCardBinder : DataHolderModels {
    override fun createInstance(parent: View, viewType: Int): DataBindViewHolder {
        return CustomViewHolder3(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_single_card, null)
        )
    }
    class CustomViewHolder3(itemView : View) : DataBindViewHolder(itemView) {
        override fun onBindVewHolder(position: Int, multiViewItem: BaseModel) {
            super.onBindVewHolder(position, multiViewItem)

            val item = multiViewItem as SingleCard
            itemView.findViewById<TextView>(R.id.btn_text)?.also {
                it.text=item.content.toString()
            }
            itemView.root.setBackgroundColor(item.color)

        }
    }

    override fun getViewType(): Int {
        return R.layout.item_single_card
    }
}