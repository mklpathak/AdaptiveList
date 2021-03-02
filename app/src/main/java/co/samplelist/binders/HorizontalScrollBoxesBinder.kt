package co.samplelist.binders

import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import co.mukulpathak.adaptivelist.*
import co.samplelist.adaptiveList.R
import co.samplelist.data.HorizonalLayoutData


class HorizontalScrollBoxesBinder : DataHolderModels {
    override fun createInstance(parent: View, viewType: Int): DataBindViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.binder_horizontal_layout, null)
        )
    }
    class ViewHolder(itemView : View) : DataBindViewHolder(itemView) {

        var heading  =  itemView.findViewById<TextView>(R.id.heading)
        var recyclerView  =  itemView.findViewById<RecyclerView>(R.id.recyclerview)

        override fun onBindVewHolder(position: Int, multiViewItem: BaseModel) {
            super.onBindVewHolder(position, multiViewItem)
            val item = multiViewItem as HorizonalLayoutData

            var dataController = DataController()
            var adaptor: DataBindListAdaptor?= null
            dataController.registerBinder(SingleCardBinder())
            dataController.registerBinder(
                HalfBoxBinder()
            )
            adaptor= dataController.getDataAdaptor()
            dataController.setUpRecyclerView(recyclerView,rowsCount = 1,orientation = DataController.VIEW_TYPE_HORIZONTAL)
            heading.text = item.heading
            adaptor.submitList(item.list)
        }
    }

    override fun getViewType(): Int {
        return R.layout.binder_horizontal_layout
    }
}