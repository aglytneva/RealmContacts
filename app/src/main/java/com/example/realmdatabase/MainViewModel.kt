package com.example.realmdatabase

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(private val contactRepository: ContactRepository) : ViewModel() {

    val allContacts: ContactLiveData
        get() = getAllContacts() as ContactLiveData

    fun addContact(name: String, surname: String, number: String) {

        contactRepository.addContact(name, surname, number)
    }

    private fun getAllContacts(): MutableLiveData<List<Contact>> {
        val list = ContactLiveData()
        val allContacts = contactRepository.getContact()
        list.value = allContacts.subList(0, allContacts.size)
        return list
    }

    fun deleteContact(id: String) {
        val contact = getContactWithId(id)
        if (contact != null) {
            contactRepository.deleteContact(contact)
        }
    }

    fun changeContact (name: String, surname:String, number: String, id: String) {
        val contact = getContactWithId(id)
        if (contact != null) {
            contactRepository.changeContact(name, surname, number, contact)
        }
    }

    fun getContactId (index:Int): String {
        val allContact = contactRepository.getContact()
        val contact = allContact[index]
        return contact.id
    }

    fun getContactWithId (id:String): Contact? {
        val contact = contactRepository.getContact().find {it.id == id}
        return contact
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("MainViewModel", "MainViewModel -> onCleared")
    }
}