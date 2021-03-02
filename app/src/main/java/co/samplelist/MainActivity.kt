package co.samplelist
import android.graphics.Color
import android.os.Bundle
import android.widget.Adapter
import androidx.appcompat.app.AppCompatActivity
import co.mukulpathak.adaptivelist.BaseModel
import co.mukulpathak.adaptivelist.DataBindListAdaptor
import co.mukulpathak.adaptivelist.DataController
import co.samplelist.adaptiveList.R
import co.samplelist.binders.FullBoxBinder
import co.samplelist.binders.HalfBoxBinder
import co.samplelist.binders.HorizontalScrollBoxesBinder
import co.samplelist.binders.SingleCardBinder
import co.samplelist.data.FullWidthCard
import co.samplelist.data.HalfWidthCard
import co.samplelist.data.HorizonalLayoutData
import co.samplelist.data.SingleCard
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList


class  MainActivity : AppCompatActivity() {

    lateinit var dataAdapter: DataBindListAdaptor
    lateinit var headerAdaptor: DataBindListAdaptor
    lateinit var footerAdaptor: DataBindListAdaptor




    lateinit var dataController: DataController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var dataList = ArrayList<BaseModel>()
        var headerList = ArrayList<BaseModel>()
        var footerList = ArrayList<BaseModel>()


        dataController = DataController()
        dataController.registerBinder(FullBoxBinder())
        dataController.registerBinder(HorizontalScrollBoxesBinder())
        dataController.registerBinder(HalfBoxBinder())
        dataController.registerBinder(SingleCardBinder())
        dataAdapter= dataController.getDataAdaptor()
        dataController.setUpRecyclerView(recyclerview,rowsCount = 4)


//        recyclerview.registerViewTypes(ViewHolder3Models (object : MyListener {
//            override fun showToast(message: String) {
//                Toast.makeText(this@MainActivity, message, Toast.LENGTH_LONG).show()
//            }
//        }),ViewHolder3Models (object : MyListener {
//            override fun showToast(message: String) {
//                Toast.makeText(this@MainActivity, message, Toast.LENGTH_LONG).show()
//            }
//        })){
//            adaptor = it
//        }


//        headerList.add(FullWidthCard("Header Card",getRandomColor()))
//        headerList.add(FullWidthCard("Header Card1",getRandomColor()))
//        headerList.add(FullWidthCard("Header Card2",getRandomColor()))
//        headerList.add(FullWidthCard("Header Card4",getRandomColor()))
//
//
//
//
//        headerAdaptor.submitList(headerList)
//
//        footerList.add(FullWidthCard("Footer Card",getRandomColor()))
//        footerList.add(FullWidthCard("Footer Card1",getRandomColor()))
//        footerList.add(FullWidthCard("Footer Card2",getRandomColor()))
//        footerList.add(FullWidthCard("Footer Card3",getRandomColor()))
//        footerList.add(FullWidthCard("Footer Card4",getRandomColor()))
//
//
//
//
//        footerAdaptor.submitList(footerList)




        dataList.addAll(getSampleItemList())
        dataAdapter.submitList(dataList)
        addItems.setOnClickListener {
            var list :ArrayList<BaseModel> = ArrayList(dataAdapter.currentList)
            list.add(0, SingleCard("N",getRandomColor()))
            dataAdapter.submitList(list) {
                recyclerview.scrollToPosition(0)
            }
        }


        addInBetween.setOnClickListener {
            var lista :ArrayList<BaseModel> = ArrayList(dataAdapter.currentList)
            for (i in 0 until lista.size){
                if (i!=0 && i%2==0){
                    lista.add(i, SingleCard("B",getRandomColor()))
                }
            }
            dataAdapter.submitList(lista) {
                recyclerview.scrollToPosition(0)
            }
        }

        suffle.setOnClickListener {
            var lista :ArrayList<BaseModel> = ArrayList(dataAdapter.currentList)
            lista.shuffle()
            dataAdapter.submitList(lista) {
                recyclerview.scrollToPosition(0)
            }
        }

        delItem.setOnClickListener {
            var list :ArrayList<BaseModel> = ArrayList(dataAdapter.currentList)
            if (list.isEmpty())
                return@setOnClickListener
            list.removeAt(0)
            dataAdapter.submitList(list) {
                recyclerview.scrollToPosition(0)
            }
        }


        delInBetween.setOnClickListener {
            var lista :ArrayList<BaseModel> = ArrayList(dataAdapter.currentList)
            val iterator: MutableListIterator<BaseModel> = lista.listIterator()
            var i =0
            while (iterator.hasNext()) {
                var b =  iterator.next()
                if (i!=0 && i%2==0 && lista.contains(b)){
                    iterator.remove()
                }
                ++i;
            }
            dataAdapter.submitList(lista) {
                recyclerview.scrollToPosition(0)
            }
        }
    }


    fun getSampleItemList() : ArrayList<BaseModel> {
        val list = ArrayList<BaseModel>()

        var count = 0
        while (count < 10) {
            list.add(HorizonalLayoutData("$count heading", getHorizontalListData()))
            list.add(FullWidthCard("$count s",getRandomColor()))
            list.add(HalfWidthCard("$count halfwidth",getRandomColor()))
            list.add(SingleCard("$count s",getRandomColor()))
            count++
        }
        return list
    }

    interface MyListener {
        fun showToast(message :String)
    }


    fun getRandomColor () : Int {
        val rnd = Random()
        return    Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }

    fun getHorizontalListData() : ArrayList<BaseModel> {
        val list = ArrayList<BaseModel>()
        var count = 0
        while (count < 10) {
            list.add(SingleCard("$count single",getRandomColor()))
            count++
        }
        return list
    }
}
