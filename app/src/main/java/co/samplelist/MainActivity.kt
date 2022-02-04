package co.samplelist
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import co.mukulpathak.adaptivelist.*
import co.samplelist.adaptiveList.R
import co.samplelist.adaptiveList.databinding.ActivityMainBinding
import co.samplelist.binders.FullBoxBinder
import co.samplelist.binders.HalfBoxBinder
import co.samplelist.binders.HorizontalScrollBoxesBinder
import co.samplelist.binders.SingleCardBinder
import co.samplelist.data.FullWidthCard
import co.samplelist.data.HalfWidthCard
import co.samplelist.data.HorizonalLayoutData
import co.samplelist.data.SingleCard
import java.util.*
import kotlin.collections.ArrayList


class  MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)?.apply {
            val dataList = ArrayList<BaseModel>()
            dataList.addAll(getSampleItemList())
            val adaptiveList = recyclerview.listOf(
                FullBoxBinder(),
                HalfBoxBinder(),
                SingleCardBinder(),
                HorizontalScrollBoxesBinder()
            )

            adaptiveList.submitList(dataList)
//            addItems.setOnClickListener {
//                dataList.add(0, SingleCard("N",getRandomColor()))
//                adaptiveList.submitList(ArrayList(dataList))
//                recyclerview.smoothScrollToPosition(0)
//
//            }
//
//
//            addInBetween.setOnClickListener {
//                for (i in 0 until dataList.size){
//                    if (i!=0 && i%2==0){
//                        dataList.add(i, SingleCard("B",getRandomColor()))
//                    }
//                }
//                adaptiveList.submitList(ArrayList(dataList))
//                recyclerview.smoothScrollToPosition(0)
//            }
//
//            suffle.setOnClickListener {
//                dataList.shuffle()
//                adaptiveList.submitList(ArrayList(dataList))
//                recyclerview.scrollToPosition(0)
//            }
//
//            delItem.setOnClickListener {
//                if (dataList.isEmpty())
//                    return@setOnClickListener
//                dataList.removeAt(0)
//                adaptiveList.submitList(ArrayList(dataList))
//                recyclerview.scrollToPosition(0)
//            }
//
//
//            delInBetween.setOnClickListener {
//                val iterator: MutableListIterator<BaseModel> = dataList.listIterator()
//                var i =0
//                while (iterator.hasNext()) {
//                    var b =  iterator.next()
//                    if (i!=0 && i%2==0 && dataList.contains(b)){
//                        iterator.remove()
//                    }
//                    ++i;
//                }
//                adaptiveList.submitList(ArrayList(dataList))
//                recyclerview.scrollToPosition(0)
//            }
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
