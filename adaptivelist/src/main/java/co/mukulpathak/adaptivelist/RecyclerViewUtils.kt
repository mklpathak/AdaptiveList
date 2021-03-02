package co.mukulpathak.adaptivelist

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.registerViewTypes(vararg models: DataHolderModels,
                                   getController: (DataBindListAdaptor) -> Unit){
    val baseViewHolderProvider = DataController()
    models.forEach {
        baseViewHolderProvider.registerBinder(it)
    }
    var dataBindListAdaptor = DataBindListAdaptor(baseViewHolderProvider, ItemDiffCallback())
    this.adapter = dataBindListAdaptor
    getController.invoke(dataBindListAdaptor)
    this.layoutManager = LinearLayoutManager(this.context)
}