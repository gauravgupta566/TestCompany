package com.example.demochat.testsuntist

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

/**
 * Created by Admin on 1/23/2018.
 */

class KotlinSample : AppCompatActivity() {


   lateinit var user_sex: TextView
    lateinit var user_name: TextView
    lateinit var maleradio: TextView
    lateinit var femaleradio: TextView
    lateinit var user_age: TextView

    lateinit var submitbutton: TextView
    lateinit var myname: EditText
    lateinit var myage: EditText


    /* internal var user_sex: TextView?=null
    internal var user_age: TextView?=null
    internal var user_name: TextView?=null
    internal var maleradio: TextView?=null
    internal var femaleradio: TextView?=null
    internal var submitbutton: Button?=null
    internal var myname: EditText?=null
    internal var myage: EditText?=null
*/
    internal var selecetedradio = "null"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         myname = findViewById(R.id.myname) as EditText
         myage = findViewById(R.id.myage) as EditText
         maleradio = findViewById(R.id.maleradio) as TextView
         femaleradio = findViewById(R.id.femaleradio) as TextView
         submitbutton = findViewById(R.id.submitbutton) as Button
         user_sex = findViewById(R.id.user_sex) as TextView
         user_age = findViewById(R.id.user_age) as TextView
         user_name = findViewById(R.id.user_name) as TextView


        myname.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                val gd = GradientDrawable()
                gd.setColor(Color.parseColor("#ffffff"))
                gd.cornerRadius = 10f
                gd.setStroke(2, resources.getColor(R.color.colorAccent))
                selecetedradio = "null"

                maleradio.background = gd
                femaleradio.background = gd
            }

            override fun afterTextChanged(s: Editable) {

            }
        })

        myage.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                selecetedradio = "null"
                val gd = GradientDrawable()
                gd.setColor(Color.parseColor("#ffffff"))
                gd.cornerRadius = 10f
                gd.setStroke(2, resources.getColor(R.color.colorAccent))

                maleradio.background = gd
                femaleradio.background = gd


            }

            override fun afterTextChanged(s: Editable) {

            }
        })

        maleradio.setOnClickListener {
            if (selecetedradio == "female") {

                selecetedradio = "male"
                val gd = GradientDrawable()
                val gd1 = GradientDrawable()

                gd.setColor(Color.parseColor("#ffffff"))
                gd.cornerRadius = 10f

                gd1.setColor(Color.parseColor("#FF4081"))
                gd1.cornerRadius = 10f

                maleradio.background = gd1

                femaleradio.background = gd

            } else {
                selecetedradio = "male"
                val gd1 = GradientDrawable()
                gd1.setColor(Color.parseColor("#FF4081"))
                gd1.cornerRadius = 10f

                maleradio.background = gd1


            }
        }


        femaleradio.setOnClickListener {
            if (selecetedradio == "male") {

                selecetedradio = "female"
                val gd = GradientDrawable()
                val gd1 = GradientDrawable()

                gd.setColor(Color.parseColor("#ffffff"))
                gd.cornerRadius = 10f

                gd1.setColor(Color.parseColor("#FF4081"))
                gd1.cornerRadius = 10f

                maleradio.background = gd

                femaleradio.background = gd1

            } else {

                selecetedradio = "female"
                val gd1 = GradientDrawable()
                gd1.setColor(Color.parseColor("#FF4081"))
                gd1.cornerRadius = 10f
                femaleradio.background = gd1
            }
        }

        submitbutton.setOnClickListener {
            if (myage.text.length > 0 && myname.text.length > 0 && selecetedradio !== "null") {


                user_age.text = myage.text.toString()
                user_name.text = myname.text.toString()
                user_sex.text = selecetedradio


            } else {
                Toast.makeText(this@KotlinSample, "either you have not filled details", Toast.LENGTH_LONG).show()
            }
        }


    }
}
