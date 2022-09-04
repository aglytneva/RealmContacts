package com.example.realmdatabase

import android.R.id
import io.realm.Realm
import java.util.*


class ContactRepositoryImpl(
    //Обязательное добавление Realm, с помощью которого мы будем делать запросы
    private val realm: Realm
) : ContactRepository {
    override fun addContact(name: String, surname: String, number: String) {
        // создаем объект с помощью REALM
        realm.executeTransaction {
            it.createObject(Contact::class.java, UUID.randomUUID().toString()).apply {
                this.name = name
                this.surname = surname
                this.number = number
            }
        }
    }

    override fun getContact(): List<Contact> {
        return realm.where(Contact::class.java).findAll()
    }

    override fun deleteContact(contact: Contact) {

        realm.executeTransaction {
            realm.where(Contact::class.java).equalTo("id", contact.id ).findAll()
            .deleteAllFromRealm()
//            return  realm.where(Contact::class.java).findAll()
        }

    }


}