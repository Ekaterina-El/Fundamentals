package el.ka.fundamentals

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService: Service() {
    val TAG = "MyService"

    init {
        Log.d(TAG, "Service is Running")
    }

    override fun onBind(p0: Intent?): IBinder? = null


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val dataString = intent?.getStringExtra("extra_data");
        dataString?.let {
            Log.d(TAG, dataString)
        }
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Service is killing")
    }

}