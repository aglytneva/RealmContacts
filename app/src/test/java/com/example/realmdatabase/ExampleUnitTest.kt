package com.example.realmdatabase

import com.example.realmdatabase.di.appModule
import io.realm.Realm
import io.realm.RealmModel
import io.realm.RealmObject
import org.junit.Test

import org.junit.Assert.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.get
import org.koin.core.context.startKoin

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun testViewModel() {


        val contactRepository = ContactRepositoryImpl()

        val number = "+88005553535"
        val contact = FakeContact(
            name = "Stas",
            surname = "Qmar",
            phone = "88005553535"
        )
        contactRepository.addContact(contact.name, contact.surname, contact.phone)
        val list = contactRepository.getContact()
        val lastContact = list.last()

        assertEquals(contact, lastContact)
        assertNotEquals(number, lastContact.number)
    }
}