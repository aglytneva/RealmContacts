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

        binding.etName.setText(viewModel.getContactWithId(idContactToEdit)?.name)
        binding.etSurname.setText(viewModel.getContactWithId(idContactToEdit)?.surname)
        binding.etNumber.setText(viewModel.getContactWithId(idContactToEdit)?.number)

        binding.btnDelete.setOnClickListener {
            viewModel.deleteContact(idContactToEdit)
            startActivity(Intent(this@EditContactActivity, MainActivity::class.java))
            finish()
        }
        binding.btnSaveChanges.setOnClickListener {
            viewModel.changeContact(
                name = binding.etName.text.toString(),
                surname = binding.etSurname.text.toString(),
                number = binding.etNumber.text.toString(),
                idContactToEdit)
            startActivity(Intent(this@EditContactActivity, MainActivity::class.java))
            finish()
        }
    }

}