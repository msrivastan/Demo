package com.example.unraveltravels.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import com.example.unraveltravels.views.DetailPageActivity
import com.example.unraveltravels.R
import com.example.unraveltravels.dataLayer.ResponseModel

class DestinationViewPagerAdapter(
    private val activity: AppCompatActivity,
    private val itemList: List<ResponseModel.ItemListDTO.DestlistDTO>
) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(activity)
        val view: ViewGroup = inflater.inflate(R.layout.trip_list_item_layout, container, false) as ViewGroup
        updateView(view, position)
        container.addView(view)
        return view
    }

    private fun updateView(view : ViewGroup, position: Int){
        val rlTopView : RelativeLayout = view.findViewById(R.id.rlTopView)
        val tvPrice : TextView = view.findViewById(R.id.tvPrice)
        val tvDestName : TextView = view.findViewById(R.id.tvDestName)
        val tvDays : TextView = view.findViewById(R.id.tvDays)
        val tvDescription : TextView = view.findViewById(R.id.tvDescription)
        val item = itemList[position]
        tvPrice.text = item.price
        tvDestName.text = item.dest
        tvDays.text = item.days
        tvDescription.text = item.description
        rlTopView.setOnClickListener{
            val intent = Intent(activity, DetailPageActivity::class.java)
            intent.putExtra("data", item)
            activity.startActivity(intent)
        }
    }

    override fun destroyItem(container: ViewGroup, position: Int, view : Any) {
        container.removeView(view as View)
    }


    override fun getCount(): Int {
        return  itemList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }
}