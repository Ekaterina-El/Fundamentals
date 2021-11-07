package el.ka.fundamentals

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addContactDialog = AlertDialog.Builder(this)
            .setTitle("Add contact")
            .setMessage("Do you want to add Mr. Poop to your contact list?")
            .setIcon(R.drawable.ic_baseline_person_add_24)
            .setPositiveButton("Yes") { _, _ ->
                Log.d("Dialog", "You added Mr. Poop to your contact list")
            }
            .setNegativeButton("No") { _, _ ->
                Log.d("Dialog", "You didn't add Mr. Poop to your contact list")
            }.create()

        btnDialog1.setOnClickListener { addContactDialog.show() }

        val options = arrayOf("First Item", "Second Item", "Third Item")
        val optionsDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of there options")
            .setSingleChoiceItems(options, 0) { _, i ->
                Log.d("Dialog", "You clicked on ${options[i]}")
            }
            .setPositiveButton("Accept") { _, i ->
                Log.d("Dialog", "You accept")
            }
            .setNegativeButton("Cancel") { _, _ ->
                Log.d("Dialog", "Canceled choose")
            }
            .create()
        btnDialog2.setOnClickListener { optionsDialog.show() }

        val multiChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of there options")
            .setMultiChoiceItems(options, booleanArrayOf(true, true, false)) { _, i, b ->
                Log.d("Dialog", "You clicked on ${options[i]}")
            }
            .setPositiveButton("Accept") { _, i ->
                Log.d("Dialog", "You accept")
            }
            .setNegativeButton("Cancel") { _, _ ->
                Log.d("Dialog", "Canceled choose")
            }
            .create()
        btnDialog3.setOnClickListener { multiChoiceDialog.show() }
    }
}