package edu.msudenver.cs3013.colorfragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

private const val ARG_CHOICE = "COLOR CHOICE"

class ColorFragment : Fragment() {
    private var choice: Int = 0
    private var myIndex: Int = 0
    private var chosenColorTV: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            choice = it.getInt(ARG_CHOICE)
        }

        if (savedInstanceState == null) {
            myIndex = ++fragmentCount
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_color, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        chosenColorTV = view.findViewById(R.id.mycolor)

        when (choice) {
            1 -> { // BLUE
                chosenColorTV?.text = "GENERIC BLUE FRAGMENT - UID $myIndex"
                chosenColorTV?.setBackgroundColor(Color.rgb(150, 150, 255))
            }
            2 -> { // RED
                chosenColorTV?.text = "GENERIC RED FRAGMENT - UID $myIndex"
                chosenColorTV?.setBackgroundColor(Color.rgb(255, 150, 150))
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(choice: Int) =
            ColorFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_CHOICE, choice)
                }
            }

        var fragmentCount = 0
    }
}