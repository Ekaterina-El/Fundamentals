package el.ka.fundamentals

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*

val permissions = arrayOf(
    Manifest.permission.ACCESS_COARSE_LOCATION,
    Manifest.permission.WRITE_EXTERNAL_STORAGE
)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPermissions.setOnClickListener { getPermissions() }
        if (hasPermissions(permissions)) {
            setOkBtn()
        } else {
            setFailedBtn()
        }
    }

    private fun hasPermissions(permissions: Array<String>): Boolean {
        for (permission in permissions) {
            if (!hasPermission(permission)) return false
        }
        return true
    }

    private fun getPermissions() {
        val permissionsToRequest = mutableListOf<String>()

        for (permission in permissions) {
            if (!hasPermission(permission)) {
                permissionsToRequest.add(permission)

            }
        }

        if (permissionsToRequest.isNotEmpty()) {
            ActivityCompat.requestPermissions(this, permissionsToRequest.toTypedArray(), 0)
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
                if (hasPermission(permissions[i])) {
                    countOfGranted += 1
                    Log.d("Permissions", "${permissions[i]}: OK")
                } else {
                    Log.d("Permissions", "${permissions[i]}: Failed")
                }
            }

            if (countOfGranted == permissions.size) {
                setOkBtn()
            }
        }

    }

    private fun setOkBtn() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            btnPermissions.setBackgroundColor(getColor(R.color.ok))
        }
    }

    private fun setFailedBtn() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            btnPermissions.setBackgroundColor(getColor(R.color.danger))
        }
    }
}