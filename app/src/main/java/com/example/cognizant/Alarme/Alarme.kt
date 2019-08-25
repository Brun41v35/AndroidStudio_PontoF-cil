package com.example.cognizant.Alarme

import android.app.TimePickerDialog
import android.content.ComponentName
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.alarms.BootCompleteReceiver
import com.example.alarms.Utils
import com.example.cognizant.R
import kotlinx.android.synthetic.main.activity_alarme.*
import java.text.SimpleDateFormat
import java.util.*

class Alarme : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarme)

        var timeInMilliSeconds: Long = 0
        val receiver = ComponentName(applicationContext, BootCompleteReceiver::class.java)

        applicationContext.packageManager?.setComponentEnabledSetting(
            receiver,
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP
        )

        startTimeText.setOnClickListener {
            // Get Current Time
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            // Launch Time Picker Dialog
            val timePickerDialog = TimePickerDialog(this,
                TimePickerDialog.OnTimeSetListener { _, hourOfDay, minuteOfHour ->

                    calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
                    calendar.set(Calendar.MINUTE, minuteOfHour)
                    calendar.set(Calendar.SECOND, 0)

                    val amPm = if (hourOfDay < 12) "horas" else "horas"
                    val formattedTime = String.format("%02d:%02d %s", hourOfDay, minuteOfHour, amPm)
                    startTimeText.text = formattedTime

                    val sdf = SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault())
                    val formattedDate = sdf.format(calendar.time)
                    val date = sdf.parse(formattedDate)
                    if (date != null) {
                        timeInMilliSeconds = date.time
                    }
                }, hour, minute, false
            )
            timePickerDialog.show()
        }

        setAlarm.setOnClickListener {
            if (timeInMilliSeconds.toInt() != 0) {
                Toast.makeText(this, "Alarme adicionado com sucesso!", Toast.LENGTH_LONG).show()

                val sharedPref = this.getSharedPreferences("MyPref", Context.MODE_PRIVATE)
                    ?: return@setOnClickListener
                with(sharedPref.edit()) {
                    putLong("timeInMilli", timeInMilliSeconds)
                    apply()
                }
                Utils.setAlarm(this, timeInMilliSeconds)
            } else {
                Toast.makeText(this, "Opa, adicione um horário primeiro!!", Toast.LENGTH_LONG).show()
            }
        }
    }
}