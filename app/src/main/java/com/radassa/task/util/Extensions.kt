package com.radassa.task.util

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.radassa.task.R
import com.radassa.task.databinding.BottomSheetBinding

fun Fragment.initToolbar(toolbar: Toolbar) {
    (activity as AppCompatActivity).setSupportActionBar(toolbar)
    (activity as AppCompatActivity).title = ""
    (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

    toolbar.setNavigationOnClickListener {
        activity?.onBackPressedDispatcher?.onBackPressed()
    }
}

fun Fragment.showBottomSheet(
    titleDialog: Int? = null,
    titleButton: Int? = null,
    message: Int,
    onClick: () -> Unit = {}
) {
    val bottomSheetDialog = BottomSheetDialog(requireContext())

    val binding: BottomSheetBinding =
        BottomSheetBinding.inflate(layoutInflater, null, false)

    bottomSheetDialog.setContentView(binding.root)

    binding.textviewTitle.text =
        getText(titleDialog ?: R.string.text_title_warning)

    binding.textviewMessage.text = getText(message)

    binding.buttonOk.text =
        getText(titleButton ?: R.string.text_button_warning)

    binding.buttonOk.setOnClickListener {
        // Quando o botão Ok é clicado: o código executa o que foi definido no onClick.
        // Depois, fecha o Bottom Sheet.
        onClick()
        bottomSheetDialog.dismiss()
    }

    bottomSheetDialog.show()
}