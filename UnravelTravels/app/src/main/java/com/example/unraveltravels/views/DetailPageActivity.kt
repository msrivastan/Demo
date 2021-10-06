package com.example.unraveltravels.views

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.unraveltravels.R
import com.example.unraveltravels.dataLayer.ResponseModel
import com.google.android.material.bottomsheet.BottomSheetDialog

class DetailPageActivity : AppCompatActivity() {

    private var data: ResponseModel.ItemListDTO.DestlistDTO? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_page)
        getIntentData()
        initView()
    }

    private fun getIntentData() {
        if (intent != null && intent.hasExtra("data"))
            data = intent.getSerializableExtra("data") as ResponseModel.ItemListDTO.DestlistDTO
    }

    private fun initView() {
        if (data != null) {
            val tvPrice: TextView = findViewById(R.id.tvPrice)
            val tvDestName: TextView = findViewById(R.id.tvDestName)
            val tvDays: TextView = findViewById(R.id.tvDays)
            val tvDescription: TextView = findViewById(R.id.tvDescription)
            tvPrice.text = data!!.price
            tvDestName.text = data!!.dest
            tvDays.text = data!!.days
            tvDescription.text = data!!.description
        }
        val tvMore: TextView = findViewById(R.id.tvMore)
        val typeface = Typeface.createFromAsset(assets, "Roboto-Bold.ttf")
        tvMore.typeface = typeface
        tvMore.setOnClickListener {
            showBottomDialog()
        }
    }

    private fun showBottomDialog() {
        val dialog = BottomSheetDialog(this)
        dialog.setContentView(R.layout.bottom_dialog_layout)
        val llReplace: LinearLayout? = dialog.findViewById(R.id.llReplace)
        val llReorder: LinearLayout? = dialog.findViewById(R.id.llReorder)
        val llWishList: LinearLayout? = dialog.findViewById(R.id.llWishList)
        val llShare: LinearLayout? = dialog.findViewById(R.id.llShare)
        val llDelete: LinearLayout? = dialog.findViewById(R.id.llDelete)

        llReplace?.setOnClickListener{
            dialog.dismiss()
            Toast.makeText(this, R.string.replace_in_trip,Toast.LENGTH_SHORT).show()
        }
        llReorder?.setOnClickListener{
            dialog.dismiss()
            Toast.makeText(this, R.string.reorder_in_trip,Toast.LENGTH_SHORT).show()
        }
        llWishList?.setOnClickListener{
            dialog.dismiss()
            Toast.makeText(this, R.string.add_to_wishlist,Toast.LENGTH_SHORT).show()
        }
        llShare?.setOnClickListener{
            dialog.dismiss()
            Toast.makeText(this, R.string.share,Toast.LENGTH_SHORT).show()
        }
        llDelete?.setOnClickListener{
            dialog.dismiss()
            Toast.makeText(this, R.string.remove_from_trip,Toast.LENGTH_SHORT).show()
        }
        dialog.show()
    }
}