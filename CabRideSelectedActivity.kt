package com.example.swiftshareapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity

class CabRideSelectedActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cab_ride_selected)

        // Receive the data passed from the previous activity
        val driverName = intent.getStringExtra("driver_name")
        val driverPhone = intent.getStringExtra("driver_phone")
        val plateNumber = intent.getStringExtra("plate_number")
        val distance = intent.getStringExtra("distance")
        val price = intent.getStringExtra("price")  // Receive price
        val rideImage = intent.getIntExtra("ride_image", R.drawable.ic_car)  // Default to ic_car if not provided

        // Find views
        val driverNameText = findViewById<TextView>(R.id.driver_name)
        val driverPhoneText = findViewById<TextView>(R.id.driver_phone)
        val plateNumberText = findViewById<TextView>(R.id.plate_number)
        val distanceText = findViewById<TextView>(R.id.distance)
        val priceText = findViewById<TextView>(R.id.price)  // Find the price TextView
        val rideImageView = findViewById<ImageView>(R.id.ride_image)
        val selectPassengersButton = findViewById<Button>(R.id.buttonClick1) // Your button to navigate

        // Use string resources with placeholders
        driverNameText.text = getString(R.string.driver_name_template, driverName)
        driverPhoneText.text = getString(R.string.phone_template, driverPhone)
        plateNumberText.text = getString(R.string.plate_number_template, plateNumber)
        distanceText.text = getString(R.string.distance_template, distance)
        priceText.text = getString(R.string.price_template, price)  // Set the price text

        // Set ride image
        rideImageView.setImageResource(rideImage)

        // Set up the button click listener to navigate to PeopleNearActivity
        selectPassengersButton.setOnClickListener {
            val intent = Intent(this, PeopleNearActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}
