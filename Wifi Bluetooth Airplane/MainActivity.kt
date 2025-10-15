package com.example.unit5

import android.bluetooth.BluetoothAdapter
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.wifi.WifiManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnWifi = findViewById<Button>(R.id.btnWifi)
        val btnBluetooth = findViewById<Button>(R.id.btnBluetooth)
        val btnAirplane = findViewById<Button>(R.id.btnAirplane)

        // WiFi Button
        btnWifi.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                // Android 10 and above → open system Wi-Fi panel
                val panelIntent = Intent(Settings.Panel.ACTION_WIFI)
                startActivity(panelIntent)
            } else {
                // Below Android 10 → toggle directly
                val wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
                wifiManager.isWifiEnabled = !wifiManager.isWifiEnabled
                Toast.makeText(
                    this,
                    if (wifiManager.isWifiEnabled) "Wi-Fi Enabled" else "Wi-Fi Disabled",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        // Bluetooth Button
        btnBluetooth.setOnClickListener {
            if (checkSelfPermission(android.Manifest.permission.BLUETOOTH_CONNECT)
                != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(arrayOf(android.Manifest.permission.BLUETOOTH_CONNECT), 1)
                return@setOnClickListener
            }

            val bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()

            if (bluetoothAdapter == null) {
                Toast.makeText(this, "Bluetooth not supported", Toast.LENGTH_SHORT).show()
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                    // Android 12 and above → open Bluetooth settings directly
                    val intent = Intent(Settings.ACTION_BLUETOOTH_SETTINGS)
                    startActivity(intent)
                } else {
                    if (bluetoothAdapter.isEnabled) {
                        bluetoothAdapter.disable()
                        Toast.makeText(this, "Bluetooth Disabled", Toast.LENGTH_SHORT).show()
                    } else {
                        bluetoothAdapter.enable()
                        Toast.makeText(this, "Bluetooth Enabled", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }


        // Airplane Mode Button (opens settings panel — direct toggle restricted by Android)
        btnAirplane.setOnClickListener {
            // Open the Airplane Mode Settings screen
            val intent = Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS)
            startActivity(intent)
        }
    }
}