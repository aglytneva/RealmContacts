package com.example.realmdatabase

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.realmdatabase.data.model.Contact

class ContactLiveData : MutableLiveData<List<Contact>>() {

    override fun onActive() {
        super.onActive()
        Log.d("ContactLiveData", "ContactLiveData - onActive")
    }

    override fun onInactive() {
        super.onInactive()
        Log.d("ContactLiveData", "ContactLiveData - onInactive")
    }




}