package com.example.unraveltravels.dataLayer

import java.io.Serializable

class ResponseModel : Serializable {

     var itemList: List<ItemListDTO>? = null

    class ItemListDTO : Serializable {
         var name: String = ""
         var type: Int = 0
         var weburl: String = ""
         var destlist: List<DestlistDTO>? = null

        class DestlistDTO : Serializable {
             var dest: String = ""
             var days: String = ""
             var description: String = ""
             var price: String? = ""
        }
    }
}