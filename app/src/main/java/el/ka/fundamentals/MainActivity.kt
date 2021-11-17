package el.ka.fundamentals

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start.setOnClickListener {
            Intent(this, MyService::class.java).also {
                startService(it)
                tv_status.text = "Service started"
            }
        }

        btn_stop.setOnClickListener {
            Intent(this, MyService::class.java).also {
                stopService(it)
                tv_status.text = "Service stopped"
            }
        }

        btn_send.setOnClickListener {
            Intent(this, MyService::class.java).also {
                val data = et_data.text.toString()
                it.putExtra("extra_data", data)
                startService(it)
                tv_status.text = "Service starting"
            }
        }
    }
}