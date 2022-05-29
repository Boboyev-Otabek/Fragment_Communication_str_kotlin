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

class SecondFragment : Fragment() {
    lateinit var listener: SecondListener
    lateinit var txt_second:TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view=inflater.inflate(R.layout.fragment_second,container,false)
        txt_second=view.findViewById(R.id.txt_second)
        var b_second:Button=view.findViewById(R.id.b_second)
        b_second.setOnClickListener{
            listener.onSecondSend("PDP")
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is SecondListener){
            listener=context
        }else{
            throw RuntimeException(context.toString())
        }

    }

    override fun onDetach() {
        super.onDetach()
        listener==null
    }
    fun updateSeconText(str:String){
        txt_second.setText(str)
    }
    public interface SecondListener{
        fun onSecondSend(str:String)
    }
}