package com.example.unraveltravels.dataLayer

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson

class MainViewModel : ViewModel() {

    private var responseLiveData: MutableLiveData<ResponseModel> = MutableLiveData()

    fun parseResponse() {
        val responseModel: ResponseModel = Gson().fromJson(getResponse(), ResponseModel::class.java)
        responseLiveData.postValue(responseModel)
    }

    fun getResponseData(): MutableLiveData<ResponseModel> {
        return responseLiveData
    }


    /*
      this function will return the dummy response
     */
    private fun getResponse(): String {
        return "{\n" +
                "  \"itemList\": [{\n" +
                "      \"name\" : \"What's included?\",\n" +
                "       \"type\" : 0,\n" +
                "       \"weburl\":\"http://vidzee.s3.ap-south-1.amazonaws.com/data/content/html/generated_v2/ACTIVITY/acti_included/00002426-9dbc-46e7-96f3-ba611e764ccd_acti_included.html\",\n" +
                "       \"destlist\" : []\n" +
                "  \n" +
                "  },{\n" +
                "      \"name\" : \"check day-to-day itinerary\",\n" +
                "       \"type\" : 1,\n" +
                "       \"weburl\":\"\",\n" +
                "       \"destlist\" : []\n" +
                "  \n" +
                "  },{\n" +
                "      \"name\" : \"Booking & Cancellation\",\n" +
                "       \"type\" : \"0\",\n" +
                "       \"weburl\":\"http://vidzee.s3.ap-south-1.amazonaws.com/data/content/html/generated_v2/ACTIVITY/acti_included/00002426-9dbc-46e7-96f3-ba611e764ccd_acti_included.html\",\n" +
                "       \"destlist\" : []\n" +
                "  \n" +
                "  },{\n" +
                "      \"name\" : \"Related Trips\",\n" +
                "       \"type\" : 2,\n" +
                "       \"weburl\":\"\",\n" +
                "       \"destlist\" : [{\n" +
                "           \"dest\" : \"Munich\",\n" +
                "           \"days\" : \"4 days\",\n" +
                "           \"description\" : \"Bavarian Suprises with Bonus Trip to Neuchwestein\",\n" +
                "           \"price\" : \"Euro 990\"\n" +
                "       },\n" +
                "       {\n" +
                "           \"dest\" : \"Italy\",\n" +
                "           \"days\" : \"5 days\",\n" +
                "           \"description\" : \"Bavarian Suprises with Bonus Trip to Neuchwestein\",\n" +
                "           \"price\" : \"Euro 1000\"\n" +
                "       },{\n" +
                "           \"dest\" : \"Switzerland\",\n" +
                "           \"days\" : \"4 days\",\n" +
                "           \"description\" : \"Bavarian Suprises with Bonus Trip to Neuchwestein\",\n" +
                "           \"price\" : \"Euro 970\"\n" +
                "       },{\n" +
                "           \"dest\" : \"Russia\",\n" +
                "           \"days\" : \"6 days\",\n" +
                "           \"description\" : \"Bavarian Suprises with Bonus Trip to Neuchwestein\",\n" +
                "           \"price\" : \"Euro 980\"\n" +
                "       },{\n" +
                "           \"dest\" : \"Dubai\",\n" +
                "           \"days\" : \"4 days\",\n" +
                "           \"description\" : \"Bavarian Suprises with Bonus Trip to Neuchwestein\",\n" +
                "           \"price\" : \"Euro 940\"\n" +
                "       },{\n" +
                "           \"dest\" : \"Finland\",\n" +
                "           \"days\" : \"3 days\",\n" +
                "           \"description\" : \"Bavarian Suprises with Bonus Trip to Neuchwestein\",\n" +
                "           \"price\" : \"Euro 990\"\n" +
                "       },{\n" +
                "           \"dest\" : \"London\",\n" +
                "           \"days\" : \"5 days\",\n" +
                "           \"description\" : \"Bavarian Suprises with Bonus Trip to Neuchwestein\",\n" +
                "           \"price\" : \"Euro 960\"\n" +
                "       },{\n" +
                "           \"dest\" : \"Maldives\",\n" +
                "           \"days\" : \"4 days\",\n" +
                "           \"description\" : \"Bavarian Suprises with Bonus Trip to Neuchwestein\",\n" +
                "           \"price\" : \"Euro 920\"\n" +
                "       },{\n" +
                "           \"dest\" : \"South Africa\",\n" +
                "           \"days\" : \"4 days\",\n" +
                "           \"description\" : \"Bavarian Suprises with Bonus Trip to Neuchwestein\",\n" +
                "           \"price\" : \"Euro 900\"\n" +
                "       },{\n" +
                "           \"dest\" : \"France\",\n" +
                "           \"days\" : \"4 days\",\n" +
                "           \"description\" : \"Bavarian Suprises with Bonus Trip to Neuchwestein\",\n" +
                "           \"price\" : \"Euro 90\"\n" +
                "       }\n" +
                "       \n" +
                "       ]\n" +
                "  \n" +
                "  }\n" +
                "  ]\n" +
                "}"
    }
}