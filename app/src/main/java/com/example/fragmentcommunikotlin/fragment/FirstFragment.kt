package com.example.fragmentcommunikotlin.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.fragmentcommunikotlin.R
import java.lang.RuntimeException

class FirstFragment : Fragment() {

    lateinit var txt_first: TextView
    lateinit var listener: FirstListner
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_first, container, false)

        txt_first=view.findViewById(R.id.txt_first)
        var b_first=view.findViewById<Button>(R.id.b_first)
        b_first.setOnClickListener{
            listener.onFirstSend("ACADEMY")
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is FirstListner){
            listener=context
        }else{
            throw RuntimeException(context.toString())
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener==null
    }
    fun updateFirstText(str:String){
        txt_first.setText(str)
    }
    public interface FirstListner {
        fun onFirstSend(str: String)
    }
}