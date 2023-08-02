package com.mocklocationchecker.capacitor

import com.getcapacitor.JSObject
import com.getcapacitor.Plugin
import com.getcapacitor.PluginCall
import com.getcapacitor.PluginMethod
import com.getcapacitor.annotation.CapacitorPlugin

@CapacitorPlugin(name = "CapacitorMockLocationChecker")
class CapacitorMockLocationCheckerPlugin : Plugin() {
	private val implementation = CapacitorMockLocationChecker()

	@PluginMethod
	fun isLocationFromMockProvider(call: PluginCall)  {
		val ret = JSObject()

		val result = implementation.isLocationFromMockProvider(activity, object :
			CapacitorMockLocationChecker.LocationCallbackListener {
			override fun onLocationCallbackCompleted(isFromMockProvider: Boolean) {
				ret.put("isMock", isFromMockProvider)
				call.resolve(ret)
			}
		})
	}
}
