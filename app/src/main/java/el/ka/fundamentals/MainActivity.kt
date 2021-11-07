package el.ka.fundamentals

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPermissions.setOnClickListener {
            getPermissions()
        }

        if (hasPermission(Manifest.permission.ACCESS_COARSE_LOCATION) ||
            hasPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) ||
            hasPermission(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
        ) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                btnPermissions.setBackgroundColor(getColor(R.color.ok))
            }
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                btnPermissions.setBackgroundColor(getColor(R.color.danger))
            }
        }
    }

    private fun getPermissions() {
        val permissions = mutableListOf<String>()

        if (!hasPermission(Manifest.permission.ACCESS_COARSE_LOCATION)) {
            permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION)
        }

        if (!hasPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }

        if (!hasPermission(Manifest.permission.ACCESS_BACKGROUND_LOCATION)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                permissions.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
            }
        }

        if (permissions.isNotEmpty()) {
            ActivityCompat.requestPermissions(this, permissions.toTypedArray(), 0)
        }
    }

    private fun hasPermission(permission: String) =
        ActivityCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 0 && grantResults.isNotEmpty()) {
            var countOfGranted = 0
            for (i in grantResults.indices) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    countOfGranted += 1
                    Log.d("Permissions", "${permissions[i]}: OK")
                } else {
                    Log.d("Permissions", "${permissions[i]}: Failed")
                }
            }

            if (countOfGranted == permissions.size) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    btnPermissions.setBackgroundColor(getColor(R.color.ok))
                }
            }
        }

    }
}