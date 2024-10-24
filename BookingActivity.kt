package com.example.swiftshareapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback

class BookingActivity : ComponentActivity() {

    private lateinit var rideTypeSpinner: Spinner
    private lateinit var pickupLocationEditText: EditText
    private lateinit var dropLocationEditText: EditText
    private lateinit var searchRidesButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)

        // Initialize UI components
        rideTypeSpinner = findViewById(R.id.ride_type_spinner)
        pickupLocationEditText = findViewById(R.id.pickup_location)
        dropLocationEditText = findViewById(R.id.drop_location)
        searchRidesButton = findViewById(R.id.search_rides_button)

        // Setup spinner
        setupRideTypeSpinner()

        // Handle search button click
        searchRidesButton.setOnClickListener {
            handleSearchRides()
        }

        // Handle back button press
        handleBackPress()
    }

    private fun setupRideTypeSpinner() {
        val rideTypes = arrayOf("Cab", "Auto")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, rideTypes)
        rideTypeSpinner.adapter = adapter
    }

    private fun handleSearchRides() {
        val pickupLocation = pickupLocationEditText.text.toString().trim()
        val dropLocation = dropLocationEditText.text.toString().trim()

        if (pickupLocation.isEmpty() || dropLocation.isEmpty()) {
            Toast.makeText(this, "Please enter both pickup and drop locations", Toast.LENGTH_SHORT)
                .show()
            return
        }

        Toast.makeText(this, "Please wait while we search rides for you...", Toast.LENGTH_SHORT)
            .show()

        val selectedRideType = rideTypeSpinner.selectedItem.toString()
        val nextActivity = if (selectedRideType == "Cab") {
            CabOptionsActivity::class.java
        } else {
            AutoOptionsActivity::class.java
        }

        val intent = Intent(this, nextActivity).apply {
            putExtra("pickup_location", pickupLocation)
            putExtra("drop_location", dropLocation)
        }
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    private fun handleBackPress() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Handle back button press
                finish()
            }
        })
    }
}
