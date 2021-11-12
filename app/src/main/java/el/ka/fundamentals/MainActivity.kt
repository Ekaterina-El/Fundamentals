package el.ka.fundamentals

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val thirdFragment = ThirdFragment()

        changeFragment(firstFragment)

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.mbHome -> changeFragment(firstFragment, true)
                R.id.mbMessage -> changeFragment(secondFragment, true)
                R.id.mbProfile -> changeFragment(thirdFragment, true)
            }
            true
        }

        bottomNavigationView.getOrCreateBadge(R.id.mbMessage).apply {
            number = 3
            isVisible = true
            backgroundColor = getColor(R.color.danger)
        }
    }

    private fun changeFragment(fragment: Fragment, addToBack: Boolean = false) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            if (addToBack) {
                addToBackStack(null)
            }
            commit()
        }
    }


}