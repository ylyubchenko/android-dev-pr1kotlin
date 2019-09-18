package ua.nure.liubchenko.pr1.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProviders

import ua.nure.liubchenko.pr1.R
import android.widget.TextView
import androidx.lifecycle.Observer

class PortraitFragment : Fragment() {

    companion object {
        fun newInstance() = PortraitFragment()
    }

    private lateinit var model: MyViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_portrait, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model = activity!!.let { ViewModelProviders.of(it).get(MyViewModel::class.java) }

        model.color.observe(viewLifecycleOwner, Observer { color ->
            view.findViewById<LinearLayout>(R.id.colorPanel).apply {
                setBackgroundColor(color)
            }
        })

        model.hexColor.observe(viewLifecycleOwner, Observer { hexColor ->
            view.findViewById<TextView>(R.id.colorLabel).apply {
                text = hexColor
            }
        })
    }

}