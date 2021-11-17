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
            Intent(this, MyIntentService::class.java).also {
                startService(it)
                tv_status.text = "Service running"
            }
        }

        btn_stop.setOnClickListener {
            MyIntentService.stopService()
            tv_status.text = "Service stopped"
        }
    }
}