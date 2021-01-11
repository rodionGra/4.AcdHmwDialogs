package com.a4acdhmwdialogs

import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class MyAlertDialog : DialogFragment() {

    private val zodiacSigns = arrayOf("♈ Aries (Ram)", "♉ Taurus (Bull)", "♊ Gemini (Twins)", "♋ Cancer (Crab)",
            "♌ Leo (Lion)", "♍ Virgo (Virgin)", "♎ Libra (Balance)", "♏ Scorpius (Scorpion)",
            "♐ Sagittarius (Archer)", "♑ Capricornus (Goat)", "♒ Aquarius (Water Bearer)", "♓ Pisces (Fish)")

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Choose your zodiac icon!")
                .setItems(zodiacSigns){
                        _, which ->  Toast.makeText(it, zodiacSigns[which], Toast.LENGTH_SHORT).show()
                }
                .setIcon(R.drawable.choose)
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}