package ir.cafebaazar.notebaazar.dialogs

import android.app.AlertDialog
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import ir.cafebaazar.notebaazar.R

object DialogHelper {

    fun AppCompatActivity.showConfirmDialog(onConfirmSelectedListener: AdapterView.OnItemSelectedListener) {
        AlertDialog.Builder(this)
            .setView(
                this.layoutInflater.inflate(
                    R.layout.dialog_confirm,
                    this.findViewById(R.id.coordinator_layout),
                    false
                )
            )
            .setOnItemSelectedListener(onConfirmSelectedListener)
            .setCancelable(true)
            .create()
            .show()
    }

    fun AppCompatActivity.showCreateFolderDialog(onConfirmSelectedListener: AdapterView.OnItemSelectedListener) {
        AlertDialog.Builder(this)
            .setView(
                this.layoutInflater.inflate(
                    R.layout.dialog_new_folder,
                    this.findViewById(R.id.coordinator_layout),
                    false
                )
            )
            .setOnItemSelectedListener(onConfirmSelectedListener)
            .setCancelable(true)
            .create()
            .show()
    }
}