// William Maddock
package edu.msudenver.cs3013.colorfragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ChoiceFragment : Fragment() {

    private var choiceListener: ChoiceListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        choiceListener = context as? ChoiceListener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_choice, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val redT = view.findViewById<TextView>(R.id.redText)
        val blueT = view.findViewById<TextView>(R.id.blueText)

        redT.setOnClickListener {
            val choice = 2 // RED
            choiceListener?.onColorChosen(choice)
        }

        blueT.setOnClickListener {
            val choice = 1 // BLUE
            choiceListener?.onColorChosen(choice)
        }
    }

    override fun onDetach() {
        super.onDetach()
        choiceListener = null
    }

    interface ChoiceListener {
        fun onColorChosen(choice: Int)
    }
}