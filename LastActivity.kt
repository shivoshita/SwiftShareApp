package com.example.swiftshareapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity

class LastActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_last)

        // Retrieve data passed from PeopleNearActivity
        val passengerName = intent.getStringExtra("passenger_name")
        val passengerPhone = intent.getStringExtra("passenger_phone")
        val vehicleType = intent.getStringExtra("vehicle_type")
        val driverName = intent.getStringExtra("driver_name")
        val driverPhone = intent.getStringExtra("driver_phone")
        val plateNumber = intent.getStringExtra("plate_number")

        // Find views
        val passengerNameText = findViewById<TextView>(R.id.passenger_name)
        val passengerPhoneText = findViewById<TextView>(R.id.passenger_phone)
        val vehicleTypeText = findViewById<TextView>(R.id.vehicle_type)
        val driverNameText = findViewById<TextView>(R.id.driver_name)
        val driverPhoneText = findViewById<TextView>(R.id.driver_phone)
        val plateNumberText = findViewById<TextView>(R.id.plate_number)

        // Set the data to the views
        passengerNameText.text = getString(R.string.passenger_name_template, passengerName)
        passengerPhoneText.text = getString(R.string.phone_template, passengerPhone)
        vehicleTypeText.text = getString(R.string.vehicle_type_template, vehicleType)
        driverNameText.text = getString(R.string.driver_name_template, driverName)
        driverPhoneText.text = getString(R.string.phone_template, driverPhone)
        plateNumberText.text = getString(R.string.plate_number_template, plateNumber)
    }
}
