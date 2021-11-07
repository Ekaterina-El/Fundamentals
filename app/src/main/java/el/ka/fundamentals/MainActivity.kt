package el.ka.fundamentals

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

        changeFragment(firstFragment)

        fragment1.setOnClickListener { changeFragment(firstFragment, true) }
        fragment2.setOnClickListener { changeFragment(secondFragment, true) }
    }

    private fun changeFragment(fragment: Fragment, addToBackStack: Boolean = false) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment, fragment)
            if (addToBackStack) {
                addToBackStack(null)
            }
            commit()
        }
    }
}