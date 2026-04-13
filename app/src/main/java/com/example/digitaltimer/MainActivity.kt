package com.example.digitaltimer

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

        var iPositionNumber=0
        lateinit var navegation : BottomNavigationView

        val mOnValMenu= BottomNavigationView.OnNavigationItemSelectedListener { item ->

            when(item.itemId){
                R.id.ID_itemMonitoring -> {
                    //A1
                    val bundle = Bundle()
                    bundle.putInt("dato",++iPositionNumber)

                    val transaccion = supportFragmentManager.beginTransaction()
                    val fragmento = fragment_Monitoring()

                    fragmento.arguments= bundle
                    transaccion.replace(R.id.ID_fragmentContainer,fragmento)
                    transaccion.addToBackStack(null)
                    transaccion.commit()


                    return@OnNavigationItemSelectedListener true

                }//Finish R.id.itemFragment1

                R.id.ID_itemManual -> {
                    supportFragmentManager.commit {
                        replace<fragment_Manual>(R.id.ID_fragmentContainer)
                        setReorderingAllowed(true)
                        addToBackStack("replacement")
                    }//Finish fragment manager
                    return@OnNavigationItemSelectedListener true

                }//Finish R.id.itemFragment2

                R.id.ID_itemSetAlarm -> {
                    supportFragmentManager.commit {
                        replace<fragment_SetAlarm>(R.id.ID_fragmentContainer)
                        setReorderingAllowed(true)
                        addToBackStack("replacement")
                    }//Finish fragment manager
                    return@OnNavigationItemSelectedListener true

                }//Finish R.id.itemFragment3


                R.id.ID_itemDetails -> {
                    supportFragmentManager.commit {
                        replace<fragment_Details>(R.id.ID_fragmentContainer)
                        setReorderingAllowed(true)
                        addToBackStack("replacement")
                    }//Finish fragment manager
                    return@OnNavigationItemSelectedListener true

                }//Finish R.id.itemFragment3

                R.id.ID_itemDeviceConection -> {
                    supportFragmentManager.commit {
                        replace<fragment_DeviceConnection>(R.id.ID_fragmentContainer)
                        setReorderingAllowed(true)
                        addToBackStack("replacement")
                    }//Finish fragment manager
                    return@OnNavigationItemSelectedListener true

                }//Finish R.id.itemFragment4

                R.id.ID_itemSetCofiguration -> {
                    supportFragmentManager.commit {
                        replace<Bfragment_Configuration>(R.id.ID_fragmentContainer)
                        setReorderingAllowed(true)
                        addToBackStack("replacement")
                    }//Finish fragment manager
                    return@OnNavigationItemSelectedListener true

                }//Finish R.id.itemFragment4


            }//Finish when

            false
        }//fINISH MoNvALmENU



        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            navegation =findViewById(R.id.ID_navigationMenu)
            navegation.setOnNavigationItemSelectedListener ( mOnValMenu )


            supportFragmentManager.commit {
                replace<fragment_Monitoring>(R.id.ID_fragmentContainer)
                setReorderingAllowed(true)
                addToBackStack("replacement")
            }//Finish fragment manager

        }//Finish onCreate



    }


