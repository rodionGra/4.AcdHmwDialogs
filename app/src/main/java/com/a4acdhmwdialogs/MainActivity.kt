package com.a4acdhmwdialogs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.a4acdhmwdialogs.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.bottom_sheet.view.*

/**Показ AlertDialog
Показ DialogFragment
Показ BottomSheet зрболенний через xml
Показ BottomSheet як наслідника BottomSheetDialogFragment*/

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val bottomSheetBehavior : BottomSheetBehavior<ConstraintLayout> by lazy {
        BottomSheetBehavior.from(
            binding.root.bottom_sheet   //use kotlin synthetic
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupListeners()
    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupListeners() {
        binding.btnAlertDialog.setOnClickListener{
            openAlertDialog()
        }
        binding.btnFragmentDialog.setOnClickListener{
            openFragmentDialog()
        }
        binding.btnBottomSheetXml.setOnClickListener{
            openBottomSheetDialogXml()
        }
        binding.btnListBottomSheet.setOnClickListener{
            openListBottomSheetDialog()
        }
    }

    private fun openAlertDialog() {
        supportFragmentManager
            .beginTransaction()
            .add(MyAlertDialog(), "TAG")
            .commitAllowingStateLoss()
    }

    private fun openFragmentDialog() {
        supportFragmentManager
            .beginTransaction()
            .add(MyDialogFragment(), "TAG")
            .commitAllowingStateLoss()
    }

    private fun openBottomSheetDialogXml() {
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED;
    }


    private fun openListBottomSheetDialog() {
        SimpleListBottomSheet().apply {
            show(supportFragmentManager, "tag")
        }
    }
}