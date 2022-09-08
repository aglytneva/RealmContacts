package com.example.realmdatabase

import com.example.realmdatabase.faceObjects.FakeContact
import com.example.realmdatabase.faceObjects.FakeContactRepository
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */


class ExampleUnitTest {

    val number = "+88005553535"
    val contact = FakeContact(
        name = "TestName",
        surname = "TestSurname",
        phone = "88005553535"
    )
    val contactRepository = FakeContactRepository()


    @Test
    fun testAddContact() {

        contactRepository.addContact(contact)
        val list = contactRepository.getAllContacts()
        val lastContact = list.last()

        assertEquals(contact, lastContact)
        assertNotEquals(number, lastContact.phone)
    }
    @Test
    fun testDeleteContact() {
        val contactfirst = FakeContact(
            name = "TestName",
            surname = "TestSurname",
            phone = "88005553535"
        )
        val contactSecond = FakeContact(
            name = "TestName",
            surname = "TestSurname",
            phone = "88005553535"
        )

        contactRepository.addContact(contactfirst)
        contactRepository.addContact(contactSecond)
        contactRepository.deleteContact(contactSecond)
        val list = contactRepository.getAllContacts()
        val lastContact = list.last()

        assertEquals(contactfirst, lastContact)
//        assertNotEquals(contactfirst, contactSecond)
    }
}
