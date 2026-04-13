package com.example.digitaltimer

import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker
import android.widget.TimePicker

class fragment_SetAlarm : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__set_alarm, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val numberPicker = requireView().findViewById<NumberPicker>(R.id.ID_PickerAlarms)

        numberPicker.minValue = 1
        numberPicker.maxValue = 50
        numberPicker.wrapSelectorWheel = true




    }

}