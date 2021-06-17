package ir.cafebaazar.notebaazar.views.dialogs

import android.app.Activity
import android.app.AlertDialog
import android.widget.AdapterView
import ir.cafebaazar.notebaazar.R

object DialogHelper {

    fun showConfirmDialog(
        activity: Activity,
        onConfirmSelectedListener: AdapterView.OnItemSelectedListener
    ) {
        AlertDialog.Builder(activity)
            .setView(
                activity.layoutInflater.inflate(
                    R.layout.dialog_confirm,
                    activity.findViewById(R.id.coordinator_layout),
                    false
                )
            )
            .setOnItemSelectedListener(onConfirmSelectedListener)
            .setCancelable(true)
            .create()
            .show()
    }

    fun showCreateFolderDialog(
        activity: Activity,
        onConfirmSelectedListener: AdapterView.OnItemSelectedListener
    ) {
        AlertDialog.Builder(activity)
            .setView(
                activity.layoutInflater.inflate(
                    R.layout.dialog_new_folder,
                    activity.findViewById(R.id.coordinator_layout),
                    false
                )
            )
            .setOnItemSelectedListener(onConfirmSelectedListener)
            .setCancelable(true)
            .create()
            .show()
    }

    fun showEditFolderDialog(
        activity: Activity,
        onConfirmSelectedListener: AdapterView.OnItemSelectedListener
    ) {
        AlertDialog.Builder(activity)
            .setView(
                activity.layoutInflater.inflate(
                    R.layout.dialog_edit_folder,
                    activity.findViewById(R.id.coordinator_layout),
                    false
                )
            )
            .setOnItemSelectedListener(onConfirmSelectedListener)
            .setCancelable(true)
            .create()
            .show()
    }
}