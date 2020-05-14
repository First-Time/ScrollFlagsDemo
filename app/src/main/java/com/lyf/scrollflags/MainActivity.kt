package com.lyf.scrollflags

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.lyf.scrollflags.android.AndroidFragment
import com.lyf.scrollflags.flutter.FlutterFragment
import com.lyf.scrollflags.kotlin.KotlinFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val fragments = mutableListOf<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolBar)

        initFragments()

        val myPagerAdapter = MyPagerAdapter()

        viewPager.adapter = myPagerAdapter

//        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
//        tabLayout.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(viewPager))

        tabLayout.setupWithViewPager(viewPager)
    }

    private fun initFragments() {
        fragments.add(AndroidFragment.newInstance("", ""))
        fragments.add(KotlinFragment.newInstance("", ""))
        fragments.add(FlutterFragment.newInstance("", ""))
    }

    inner class MyPagerAdapter :
        FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount(): Int {
            return fragments.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return when (position) {
                0 -> "Android"
                1 -> "Kotlin"
                2 -> "Flutter"
                else -> super.getPageTitle(position)
            }
        }
    }
}
