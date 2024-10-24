package com.example.swiftshareapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import kotlin.random.Random

class AutoOptionsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auto_options)

        // Setting random data for auto options
        setRandomAutoInfo(R.id.plate_number_1, R.id.driver_name_1, R.id.driver_phone_1, R.id.distance_1, R.id.price_auto_1, R.id.select_ride_1)
        setRandomAutoInfo(R.id.plate_number_2, R.id.driver_name_2, R.id.driver_phone_2, R.id.distance_2, R.id.price_auto_2, R.id.select_ride_2)
        setRandomAutoInfo(R.id.plate_number_3, R.id.driver_name_3, R.id.driver_phone_3, R.id.distance_3, R.id.price_auto_3, R.id.select_ride_3)
        setRandomAutoInfo(R.id.plate_number_4, R.id.driver_name_4, R.id.driver_phone_4, R.id.distance_4, R.id.price_auto_4, R.id.select_ride_4)
    }

    // Function to set random data for each auto option
    private fun setRandomAutoInfo(
        plateNumberId: Int, driverNameId: Int, driverPhoneId: Int, distanceId: Int, priceId: Int, selectButtonId: Int
    ) {
        val plateNumber = generateRandomPlateNumber()
        val driverName = getRandomDriverName()
        val driverPhone = "+91 " + Random.nextInt(1000000000, 999999999).toString()
        val distance = "${Random.nextInt(100, 600)} m"
        val price = "INR ${Random.nextInt(100, 250)}"

        // Set the values into the respective views
        findViewById<TextView>(plateNumberId).text = plateNumber
        findViewById<TextView>(driverNameId).text = driverName
        findViewById<TextView>(driverPhoneId).text = driverPhone
        findViewById<TextView>(distanceId).text = distance
        findViewById<TextView>(priceId).text = price

        // Set up the select ride button
        findViewById<Button>(selectButtonId).setOnClickListener {
            // Handle ride selection here
            val intent = Intent(this, AutoRideSelectedActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            intent.putExtra("driver_name", driverName)
            intent.putExtra("driver_phone", driverPhone)
            intent.putExtra("plate_number", plateNumber)
            intent.putExtra("distance", distance)
            intent.putExtra("price", price)  // Passing the price information
            intent.putExtra("ride_image", R.drawable.ic_auto)  // Passing the image reference
            startActivity(intent)
        }
    }

    // Function to generate random plate numbers (KA 56B 3464)
    private fun generateRandomPlateNumber(): String {
        val region = "KA"
        val number = Random.nextInt(10, 100).toString()
        val letter = ('A'..'Z').random()
        val vehicleNumber = Random.nextInt(1000, 9999).toString()
        return "$region $number$letter $vehicleNumber"
    }

    // Function to get random Kannada driver names
    private fun getRandomDriverName(): String {
        val driverNames = arrayOf("Raghavendra", "Venkatesh", "Prakash", "Manjunath", "Suresh", "Shivakumar")
        return driverNames.random()
    }
}
