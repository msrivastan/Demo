package com.example.unraveltravels.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.unraveltravels.views.DetailPageActivity
import com.example.unraveltravels.R
import com.example.unraveltravels.dataLayer.ResponseModel

class MainRecyclerListViewAdapter(
    private val activity: AppCompatActivity,
    private val itemList: List<ResponseModel.ItemListDTO>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var isFirstClick = true

    companion object {
        const val VIEW_TYPE_ZERO = 0
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2
    }

    private inner class View1ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvItemName)
        val webView: WebView = itemView.findViewById(R.id.webView)
        val ivArrowIcon: ImageView = itemView.findViewById(R.id.ivArrowIcon)
        val ivMenuIcon: ImageView = itemView.findViewById(R.id.ivMenuIcon)

        @SuppressLint("SetJavaScriptEnabled")
        fun bind(position: Int) {
            tvName.text = itemList[position].name
            if (position == 2)
                ivMenuIcon.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.book))
            ivArrowIcon.setOnClickListener {
                if (isFirstClick || ivArrowIcon.drawable.constantState == ContextCompat.getDrawable(
                        activity,
                        R.drawable.bottom_arrow
                    )?.constantState
                ) {
                    ivArrowIcon.setImageDrawable(
                        ContextCompat.getDrawable(
                            activity,
                            R.drawable.top_arrow
                        )
                    )
                    isFirstClick = false
                    webView.visibility = View.VISIBLE
                    webView.settings.javaScriptEnabled = true
                    webView.loadUrl(itemList[position].weburl)
                } else {
                    ivArrowIcon.setImageDrawable(
                        ContextCompat.getDrawable(
                            activity,
                            R.drawable.bottom_arrow
                        )
                    )
                    webView.visibility = View.GONE
                }
            }
        }
    }

    private inner class View2ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val tvItemName: TextView = itemView.findViewById(R.id.tvItemName)
        val rlMainLayout: RelativeLayout = itemView.findViewById(R.id.rlMainLayout)
        fun bind(position: Int) {
            val item = itemList[position]
            tvItemName.text = item.name
            rlMainLayout.setOnClickListener {
                val intent = Intent(activity, DetailPageActivity::class.java)
                activity.startActivity(intent)
            }
        }
    }

    private inner class View3ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val viewPager: ViewPager = itemView.findViewById(R.id.viewPager)
        val tvItemName: TextView = itemView.findViewById(R.id.tvItemName)
        val tvItemSize: TextView = itemView.findViewById(R.id.tvItemSize)
        fun bind(position: Int) {
            val item = itemList[position]
            tvItemName.text = item.name
            val typeface = Typeface.createFromAsset(activity.assets, "Roboto-Bold.ttf")
            tvItemName.typeface = typeface
            val destList = item.destlist
            if (destList != null) {
                tvItemSize.text =
                    String.format(activity.getString(R.string.dest_size_text, destList.size))
                viewPager.adapter = DestinationViewPagerAdapter(activity, destList)
                viewPager.clipToPadding = false
                viewPager.setPadding(
                    0,
                    0,
                    activity.resources.getDimensionPixelOffset(R.dimen.dimens_20dp),
                    0
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_ZERO -> View1ViewHolder(
                LayoutInflater.from(activity).inflate(R.layout.type_web_view_layout, parent, false)
            )
            VIEW_TYPE_ONE -> View2ViewHolder(
                LayoutInflater.from(activity)
                    .inflate(R.layout.type_day_to_day_view_layout, parent, false)
            )
            VIEW_TYPE_TWO -> View3ViewHolder(
                LayoutInflater.from(activity)
                    .inflate(R.layout.type_horizontal_list_layout, parent, false)
            )
            else -> View1ViewHolder(
                LayoutInflater.from(activity).inflate(R.layout.type_web_view_layout, parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (itemList[position].type) {
            VIEW_TYPE_ZERO -> (holder as View1ViewHolder).bind(position)
            VIEW_TYPE_ONE -> (holder as View2ViewHolder).bind(position)
            VIEW_TYPE_TWO -> (holder as View3ViewHolder).bind(position)
            else -> (holder as View1ViewHolder).bind(position)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun getItemViewType(position: Int): Int {
        return itemList[position].type
    }
}