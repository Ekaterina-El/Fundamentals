package el.ka.fundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_toast.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showToast.setOnClickListener {
            Toast(this).apply {
                duration = Toast.LENGTH_SHORT
                view = layoutInflater.inflate(R.layout.custom_toast, clToast)
                show()
            }
        }
    }
}