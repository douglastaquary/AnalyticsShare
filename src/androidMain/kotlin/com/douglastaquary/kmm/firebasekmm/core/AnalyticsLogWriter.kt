package com.douglastaquary.kmm.firebasekmm.core

import co.touchlab.kermit.ExperimentalKermitApi
import co.touchlab.kermit.Severity
import co.touchlab.kermit.Logger
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase

@ExperimentalKermitApi
class AnalyticsLogWriter actual constructor(
    private val minSeverity: Severity,
    private val minCrashSeverity: Severity,
) : KotlinAnlytics {
    private val analytics: FirebaseAnalytics
        get() = Firebase.analytics

    init {
        assert(minSeverity <= minCrashSeverity) {
            "minSeverity ($minSeverity) cannot be greater than minCrashSeverity ($minCrashSeverity)"
        }
    }

    override fun logEvent(name: String, parameters: Map<String, Any>) {
        analytics.logEvent(name) {
            param("tag_name", name)
            Logger.a("[LOG] Value Name: $name")
            for (param in parameters) {
                param("${param.key}", "${param.value}")
                Logger.a("[LOG] Key: ${param.key} - Value: ${param.value}")
            }
        }
    }
    private fun sendException(throwable: Throwable) {
        //cl.recordException(throwable)
    }
}