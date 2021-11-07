package el.ka.fundamentals

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import el.ka.fundamentals.model.Person
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val person = intent.getSerializableExtra("person_info") as Person
        info.text = person.getString()

        btnBack.setOnClickListener { finish() }
    }
}