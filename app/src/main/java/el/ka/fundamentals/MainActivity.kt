package el.ka.fundamentals

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val images = listOf<Int>(
            R.drawable.kermit1,
            R.drawable.kermit2,
            R.drawable.kermit3,
            R.drawable.kermit4
        )

        val adapter = ViewPagerAdapter(images)
        viewPage.adapter = adapter

        viewPage.orientation = ViewPager2.ORIENTATION_HORIZONTAL

//        viewPage.beginFakeDrag()
//        viewPage.fakeDragBy(100f)
//        viewPage.endFakeDrag()
    }
}