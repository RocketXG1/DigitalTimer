package com.example.digitaltimer

import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.NumberPicker
import android.widget.TimePicker

class fragment_SetAlarm : Fragment() {


    fun NumberPicker.styleCompat(sizeSp: Float, color: Int = Color.BLACK, minValue:Int = 1, maxValue:Int = 50) {

        this.minValue = minValue
        this.maxValue = maxValue

        val sizePx = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP,
            sizeSp,
            resources.displayMetrics
        )

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            this.textSize = sizePx
            this.setTextColor(color)
        } else {
            runCatching {
                val paintField = NumberPicker::class.java.getDeclaredField("mSelectorWheelPaint")
                paintField.isAccessible = true
                val paint = paintField.get(this) as? Paint
                paint?.textSize = sizePx
                paint?.color = color
            }
        }

        for (i in 0 until childCount) {
            val child: View = getChildAt(i)
            if (child is EditText) {
                child.setTextSize(TypedValue.COMPLEX_UNIT_SP, sizeSp)
                child.setTextColor(color)
                child.invalidate()
            }
        }

        invalidate()
        requestLayout()
    }





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

        val checkBox = requireView().findViewById<com.google.android.material.checkbox.MaterialCheckBox>(R.id.ID_CheckBoxMonday)
        checkBox.isUseMaterialThemeColors = false

        val numberPicker = requireView().findViewById<NumberPicker>(R.id.ID_PickerAlarms)
        val numPickerHrs = requireView().findViewById<NumberPicker>(R.id.ID_NumbPickHours)
        val numPickerMin = requireView().findViewById<NumberPicker>(R.id.ID_NumbPickMinutes)
        val numPickerSec = requireView().findViewById<NumberPicker>(R.id.ID_NumbPickSeconds)

        numberPicker.styleCompat(40f, color = Color.WHITE,minValue = 1, maxValue = 50)
        numPickerHrs.styleCompat(20f, color = Color.WHITE,1,12)
        numPickerMin.styleCompat(20f, color = Color.WHITE,0,59)
        numPickerSec.styleCompat(20f, color = Color.WHITE,0,59)

        val numPickerAmPm = requireView().findViewById<NumberPicker>(R.id.ID_NumbPickAmPm)
        val opciones = arrayOf("AM", "PM")
        numPickerAmPm.minValue = 0
        numPickerAmPm.maxValue = opciones.size - 1
        numPickerAmPm.displayedValues = opciones



    }

}