package co.mukulpathak.adaptivelist

import android.graphics.Bitmap
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.*
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup


class DataController(var diffUtil: DiffUtil.ItemCallback<BaseModel>? = null) {
    private val dataMaps = HashMap<Int, DataHolderModels>()
//    private val headerMaps = HashMap<Int, DataHolderModels>()
//    private val footerMaps = HashMap<Int, DataHolderModels>()

    private val headersData = ArrayList<BaseModel>()
    private val footersData = ArrayList<BaseModel>()



    private val dataBindListAdaptor  = DataBindListAdaptor(this, diffUtil
            ?: ItemDiffCallback())
//    private val headerBindListAdaptor  = DataBindListAdaptor(this, diffUtil
//            ?: ItemDiffCallback())
//    private val footerBindListAdaptor  = DataBindListAdaptor(this, diffUtil
//            ?: ItemDiffCallback())
    private var recyclerView:RecyclerView?= null

    fun createViewHolder(parent: ViewGroup, viewType : Int) : DataBindViewHolder {
        if (dataMaps[viewType]==null)
            throw  RuntimeException("Register Models before use");
        return dataMaps[viewType]!!.createInstance(parent,viewType)
    }

    fun registerBinder(viewHolderModels: DataHolderModels) {
        dataMaps[viewHolderModels.getViewType()] = viewHolderModels
    }
//    fun registerHeader(viewHolderModels: DataHolderModels) {
//        headerMaps[viewHolderModels.getViewType()] = viewHolderModels
//    }
//    fun registerFooter(viewHolderModels: DataHolderModels) {
//        footerMaps[viewHolderModels.getViewType()] = viewHolderModels
//    }

    fun addheaders(vararg baseModels: BaseModel ){
        baseModels.forEach { baseModel ->
            headersData.contains(baseModel).let {
                if (!it){
                    headersData.add(baseModel)
                }
            }
        }
    }


    fun addFooters(vararg baseModels: BaseModel ){
        baseModels.forEach { baseModel ->
            footersData.contains(baseModel).let {
                if (!it){
                    footersData.add(baseModel)
                }
            }
        }
    }



    fun getDataAdaptor () : DataBindListAdaptor {
        return dataBindListAdaptor
    }

//    fun getHeaderAdaptor () : DataBindListAdaptor {
//        return headerBindListAdaptor
//    }
//
//    fun getFooterAdaptor () : DataBindListAdaptor {
//        return footerBindListAdaptor
//    }

    var spanInterface = object: SpanSizeLookup() {
        override fun getSpanSize(position: Int): Int {
            return when {
                dataBindListAdaptor.getSpan(position)!=-1 -> dataBindListAdaptor.getSpan(position)
//                headerBindListAdaptor.getSpan(position)!=-1 -> headerBindListAdaptor.getSpan(position)
//                footerBindListAdaptor.getSpan(position)!=-1 -> footerBindListAdaptor.getSpan(position)
                else -> 4
            }
        }
    }


    fun setUpRecyclerView(recyclerView: RecyclerView,rowsCount: Int = 1,orientation:Int =1001){
        this.recyclerView=recyclerView
        this.recyclerView?.apply {
            layoutManager = if (rowsCount==0||rowsCount==1){
                LinearLayoutManager(this.context).apply {
                    this.orientation = if (orientation== VIEW_TYPE_HORIZONTAL){
                        LinearLayoutManager.HORIZONTAL
                    }else{
                        LinearLayoutManager.VERTICAL
                    }
                }
            }else{
                GridLayoutManager(this.context,rowsCount).apply {
                    this.orientation = if (orientation== VIEW_TYPE_HORIZONTAL){
                        GridLayoutManager.HORIZONTAL
                    }else{
                        GridLayoutManager.VERTICAL
                    }
                    spanSizeLookup = spanInterface
                }
            }


            adapter = dataBindListAdaptor

            //Tried using concat adaptor but span

//         var config =   ConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(ConcatAdapter.Config.StableIdMode.NO_STABLE_IDS).build()
//            adapter = ConcatAdapter(headerBindListAdaptor,dataBindListAdaptor,footerBindListAdaptor)


        }
    }

    companion object {
        const val VIEW_TYPE_HORIZONTAL = 1000
        const val VIEW_TYPE_VERTICLE = 1001
    }

    fun submit(){

    }
}
interface DataHolderModels {
    fun createInstance(parent: View, viewType : Int) : DataBindViewHolder
    fun getViewType():Int
}