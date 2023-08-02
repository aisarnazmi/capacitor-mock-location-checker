package com.mocklocationchecker.capacitor

import android.app.Activity
import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.location.Location
import android.os.Build
import android.provider.Settings
import android.util.Log
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import java.util.ArrayList
import java.util.Arrays
import java.util.List

const val TAG: String = "MockLocationChecker"

class CapacitorMockLocationChecker {
    private lateinit var mFusedLocationClient: FusedLocationProviderClient
    
    @SuppressLint("ObsoleteSdkInt")
    fun isLocationFromMockProvider(activity: Activity, callback: LocationCallbackListener) {
        var locationCallbackCompleted = false
        var counter = 0
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(activity)
        val locationRequest = LocationRequest.create().apply {
            interval = 1000
            fastestInterval = 500
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }

        val locationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            locationResult.lastLocation?.let { location ->
            try {
                val isFromMockProvider = if (Build.VERSION.SDK_INT <= 30) {
                location.isFromMockProvider
                } else if (Build.VERSION.SDK_INT >= 31) {
                location.isMock
                } else {
                false
                }
                Log.i(TAG, "Check Mock: $isFromMockProvider")
                if (isFromMockProvider || counter >= 3) {
                locationCallbackCompleted = true
                callback.onLocationCallbackCompleted(isFromMockProvider)
                mFusedLocationClient.removeLocationUpdates(this)
                }
                counter++
            } catch (e: Exception) {
                Log.e("MockLocationChecker", e.toString())
            }
            }
        }
        }

        // Request location updates
        if (Build.VERSION.SDK_INT >= 18) {
        if (ActivityCompat.checkSelfPermission(
            activity.applicationContext,
            Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
            activity.applicationContext,
            Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            callback.onLocationCallbackCompleted(false)
            return
        }
        mFusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, null)
        } else {
        callback.onLocationCallbackCompleted(
            Settings.Secure.getString(
            activity.applicationContext.contentResolver,
            Settings.Secure.ALLOW_MOCK_LOCATION
            ) != "0"
        )
        }
    }

    interface LocationCallbackListener {
        fun onLocationCallbackCompleted(isFromMockProvider: Boolean)
    }
}