package com.douglastaquary.kmm.firebasekmm.core


import co.touchlab.kermit.ExperimentalKermitApi
import co.touchlab.kermit.LogWriter
import co.touchlab.kermit.Severity

interface KotlinAnalytics {
    fun logEvent(name: String, parameters: Map<String, Any>)
}


@ExperimentalKermitApi
expect class AnalyticsLogWriter(
    minSeverity: Severity = Severity.Info,
    minCrashSeverity: Severity = Severity.Warn
) : KotlinAnalytics
