package el.ka.fundamentals

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

const val spFile = "spFile"

class MainActivity : AppCompatActivity() {
    lateinit var editSP: SharedPreferences.Editor
    lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sp = getSharedPreferences(spFile, MODE_PRIVATE)
        editSP = sp.edit()

        save.setOnClickListener {
            saveSP()
        }

        load.setOnClickListener {
            loadSP()
        }
    }

    private fun loadSP() {
        et_name.setText(sp.getString("name", "empty"))
        et_age.setText(sp.getInt("age", 0).toString())
        is_adult.isChecked = sp.getBoolean("isAdult", false)
    }

    private fun saveSP() {
        val name = et_name.text.toString()
        val age = et_age.text.toString().toInt()
        val isAdult = is_adult.isChecked

        editSP.apply {
            putString("name", name)
            putInt("age", age)
            putBoolean("isAdult", isAdult)
            apply()
        }
    }
}