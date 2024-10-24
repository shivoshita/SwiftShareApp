package com.example.swiftshareapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity

class PeopleNearActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_people_near)

        // Initialize your views here if needed
        val headingText = findViewById<TextView>(R.id.heading_text)
        val logoImageView = findViewById<ImageView>(R.id.imageView)

        // Example of setting some text dynamically if needed
        headingText.text = "Select Co-Passengers"

        // Passenger buttons
        val passenger1Button = findViewById<Button>(R.id.passenger_1_image).parent as Button
        val passenger2Button = findViewById<Button>(R.id.passenger_2_image).parent as Button
        val passenger3Button = findViewById<Button>(R.id.passenger_3_image).parent as Button
        val passenger4Button = findViewById<Button>(R.id.passenger_4_image).parent as Button

        // Retrieve driver and vehicle details passed from previous activity
        val driverName = intent.getStringExtra("driver_name")
        val driverPhone = intent.getStringExtra("driver_phone")
        val plateNumber = intent.getStringExtra("plate_number")
        val vehicleType = intent.getStringExtra("vehicle_type")

        // Set up click listeners for each passenger button
        passenger1Button.setOnClickListener {
            navigateToLastActivity("Kris Tanna", "+91 9876543210", vehicleType, driverName, driverPhone, plateNumber)
        }

        passenger2Button.setOnClickListener {
            navigateToLastActivity("Shivoshita Jhalta", "+91 9123456789", vehicleType, driverName, driverPhone, plateNumber)
        }

        passenger3Button.setOnClickListener {
            navigateToLastActivity("Thanishka B", "+91 9876501234", vehicleType, driverName, driverPhone, plateNumber)
        }

        passenger4Button.setOnClickListener {
            navigateToLastActivity("Likitha", "+91 9876547890", vehicleType, driverName, driverPhone, plateNumber)
        }
    }

    private fun navigateToLastActivity(passengerName: String, passengerPhone: String, vehicleType: String?, driverName: String?, driverPhone: String?, plateNumber: String?) {
        val intent = Intent(this, LastActivity::class.java).apply {
            putExtra("passenger_name", passengerName)
            putExtra("passenger_phone", passengerPhone)
            putExtra("vehicle_type", vehicleType)
            putExtra("driver_name", driverName)
            putExtra("driver_phone", driverPhone)
            putExtra("plate_number", plateNumber)
        }
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}
