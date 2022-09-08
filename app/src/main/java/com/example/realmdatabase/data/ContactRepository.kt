package com.example.realmdatabase.data

import com.example.realmdatabase.data.model.Contact

interface ContactRepository {

    fun addContact(name: String, surname: String, number: String)

    fun getContact(): List<Contact>

    fun deleteContact(contact: Contact)

    fun changeContact(name: String, surname: String, number: String, contact: Contact)
}