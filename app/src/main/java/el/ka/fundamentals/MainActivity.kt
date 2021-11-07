package el.ka.fundamentals

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val options = arrayOf("First", "Second", "Third")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, options)

        spMonths.adapter = adapter

        spMonths.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Log.d("Spinner", "Selected: ${adapterView?.getItemAtPosition(position)}")
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Log.d("Spinner", "Selected: nothing")

            }

        }
    }
}