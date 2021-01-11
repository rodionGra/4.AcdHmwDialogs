package com.a4acdhmwdialogs

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.a4acdhmwdialogs.databinding.CustomDialogFragmentBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputLayout


class MyDialogFragment : DialogFragment() {

    private lateinit var binding: CustomDialogFragmentBinding
    private var resultCallBack: ((String, String, String) -> (Unit))? = null

    private lateinit var materialAlertDialogBuilder: MaterialAlertDialogBuilder

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CustomDialogFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            materialAlertDialogBuilder = MaterialAlertDialogBuilder(it)

            val materialAlertDialogBuilder = MaterialAlertDialogBuilder(it)
            // Building the Alert dialog using materialAlertDialogBuilder instance
            materialAlertDialogBuilder.setView(R.layout.custom_dialog_fragment)
                .setTitle("Details")
                .setMessage("Enter your basic details")
                .setPositiveButton("Add") { dialog, _ ->

                    /*val name: String = binding.nameTextField.editText?.text.toString()
                    val phone: String = binding.phoneNumberTextField.editText?.text.toString()
                    val address: String = binding.addressTextField.editText?.text.toString()
                    resultCallBack?.invoke(name, phone, address)*/

                    dialog.dismiss()
                }
                .setNegativeButton("Cancel") { dialog, _ ->
                    Toast.makeText(context, "Operation cancelled!", Toast.LENGTH_LONG).show()
                    dialog.dismiss()
                }
                .create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    fun setupResultCallBack(resultCallBack: (String, String, String) -> (Unit)) {
        this.resultCallBack = resultCallBack
    }
}