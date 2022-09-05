package com.example.realmdatabase

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.realmdatabase.databinding.ActivityAddContactBinding
import com.example.realmdatabase.databinding.ActivityEditContactBinding
import com.example.realmdatabase.presenter.MainAction
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class EditContactActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditContactBinding

    private val viewModel : MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityEditContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val idContactToEdit:String = intent.getStringExtra("id").toString()

        val contact: Contact? = viewModel.getContactWithId(idContactToEdit)

        binding.etName.setText(contact?.name)
        binding.etSurname.setText(contact?.surname)
        binding.etNumber.setText(contact?.number)

        binding.btnDelete.setOnClickListener {
            viewModel.deleteContact(idContactToEdit)
            startActivity(Intent(this@EditContactActivity, MainActivity::class.java))
            finish()
        }
//        binding.btnDelete.setOnClickListener {
//            with(binding) {
//                presenter.deleteContact()
//                startActivity(Intent(this@EditContactActivity, MainActivity::class.java))
//                finish()
//            }
//        }
    }

//    override fun onAddContact(contacts: List<Contact>) {
//        TODO("Not yet implemented")
//    }


}