package com.sakal_n.myapplicationcinemasearch.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.sakal_n.myapplicationcinemasearch.data.entity.Film
import com.sakal_n.myapplicationcinemasearch.view.notifications.NotificationConstants
import com.sakal_n.myapplicationcinemasearch.view.notifications.NotificationHelper

class ReminderBroadcast : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        val bundle = intent?.getBundleExtra(NotificationConstants.FILM_BUNDLE_KEY)
        val film: Film = bundle?.get(NotificationConstants.FILM_KEY) as Film

        NotificationHelper.createNotification(context!!, film)
    }
}
