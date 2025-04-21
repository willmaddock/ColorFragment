// William Maddock
package edu.msudenver.cs3013.colorfragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView

class MainActivity : AppCompatActivity(), ChoiceFragment.ChoiceListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val choiceFragment = ChoiceFragment()
            val cfv = findViewById<FragmentContainerView>(R.id.upperfragment_container) // Get FragmentContainerView
            supportFragmentManager.beginTransaction()
                .add(cfv.id, choiceFragment)
                .commit()
        }
    }

    override fun onColorChosen(choice: Int) {
        val newColorFragment = ColorFragment.newInstance(choice)
        val fcv = findViewById<FragmentContainerView>(R.id.lowerfragment_container) // Get FragmentContainerView

        supportFragmentManager.beginTransaction()
            .replace(fcv.id, newColorFragment)
            .addToBackStack(null)
            .commit()
    }

    interface ChoiceListener {
        fun onColorChosen(choice: Int)
    }
}